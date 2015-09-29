/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.IPurchaseLogic;
import co.edu.uniandes.csw.musicstore.converters.LongPlayConverter;
import co.edu.uniandes.csw.musicstore.converters.PurchaseConverter;
import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import co.edu.uniandes.csw.musicstore.persistence.PurchasePersistence;
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

    /**
     * @generated
     */
    public int countPurchases() {
        return persistence.count();
    }

    /**
     * @generated
     */
    /*
    public List<PurchaseDTO> getPurchases(Integer page, Integer maxRecords) {
        return PurchaseConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }
*/
    /**
     * @generated
     */
    public PurchaseDTO getPurchase(Long id) {
        return PurchaseConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public PurchaseDTO createPurchase(PurchaseDTO dto) {
        PurchaseEntity entity = PurchaseConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PurchaseConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public PurchaseDTO updatePurchase(PurchaseDTO dto) {
        PurchaseEntity entity = persistence.update(PurchaseConverter.fullDTO2Entity(dto));
        return PurchaseConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deletePurchase(Long id) {
        persistence.delete(id);
    }

    public List<PurchaseDTO> getUserPurchases(String userId) {
        return PurchaseConverter.listEntity2DTO(persistence.getUserPurchases(userId));
    }
    
    public List<LongPlayDTO> getProviderPurchases(String providerId) {
        return LongPlayConverter.listEntity2DTO(persistence.getProviderPurchases(providerId));
    }
}
