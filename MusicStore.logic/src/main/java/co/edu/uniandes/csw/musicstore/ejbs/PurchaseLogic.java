/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.IPurchaseLogic;
import co.edu.uniandes.csw.musicstore.converters.PurchaseConverter;
import co.edu.uniandes.csw.musicstore.converters.PurchaseDetailConverter;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDetailDTO;
import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import co.edu.uniandes.csw.musicstore.persistence.PurchaseDetailPersistence;
import co.edu.uniandes.csw.musicstore.persistence.PurchasePersistence;
import co.edu.uniandes.csw.musicstore.util.MailManager;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.client.ApiKey;
import com.stormpath.sdk.client.ApiKeys;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jd.patino10
 */
@Stateless
public class PurchaseLogic implements IPurchaseLogic{
     @Inject private PurchasePersistence persistence;
     @Inject private PurchaseDetailPersistence persistenceDetail;

    /**
     * @generated
     */
    @Override
    public int countPurchases() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public PurchaseDTO getPurchase(Long id) {
        return PurchaseConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public PurchaseDTO createPurchase(PurchaseDTO dto) {
        PurchaseEntity entity = PurchaseConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PurchaseConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public PurchaseDTO updatePurchase(PurchaseDTO dto) {
        PurchaseEntity entity = persistence.update(PurchaseConverter.fullDTO2Entity(dto));
        return PurchaseConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deletePurchase(Long id) {
        persistence.delete(id);
    }

    @Override
    public List<PurchaseDTO> getUserPurchases(String userId) {
        return PurchaseConverter.listEntity2DTO(persistence.getUserPurchases(userId));
    }
    
    @Override
    public List<PurchaseDetailDTO> getProviderPurchases(String providerId) {
        return PurchaseDetailConverter.listEntity2DTO(persistence.getProviderPurchases(providerId));
    }

    @Override
    public PurchaseDetailDTO confirmOrder(PurchaseDetailDTO dto) {
        PurchaseDetailEntity entity = persistenceDetail.update(PurchaseDetailConverter.fullDTO2Entity(dto));
        if(dto.getPurchase()!=null)
        {    
            //Query user mail
            String path = "C:\\.stormpath/apiKey.properties";
            ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build();
            Client client = Clients.builder().setApiKey(apiKey).build();
            Account account = client.getResource(persistence.find(dto.getPurchase().getId()).getClient().getUserId(), Account.class);
            //Send email
            String emailBody="<h2>Hello, your order has been confirm!</h2>"+
                    "you will receive your order on "+dto.getConfirmDate();
            MailManager.generateAndSendEmail(emailBody, account.getEmail(), "Order Confirmation");
        }
        return PurchaseDetailConverter.fullEntity2DTO(entity);
    }

    @Override
    public PurchaseDetailDTO cancelOrder(PurchaseDetailDTO dto) {
        PurchaseDetailEntity entity = persistenceDetail.update(PurchaseDetailConverter.fullDTO2Entity(dto));
        if(dto.getPurchase()!=null)
        {  
            //Query user mail
            String path = "C:\\.stormpath/apiKey.properties";
            ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build();
            Client client = Clients.builder().setApiKey(apiKey).build();
            Account account = client.getResource(persistence.find(dto.getPurchase().getId()).getClient().getUserId(), Account.class);
            //Send email
            String emailBody="<h2>Hello, your order has been canceled!</h2>"+
                    "the reason is that: "+dto.getConfirmObservations();
            MailManager.generateAndSendEmail(emailBody, account.getEmail(), "Order Cancelation");
        }
        return PurchaseDetailConverter.fullEntity2DTO(entity);
    }
}
