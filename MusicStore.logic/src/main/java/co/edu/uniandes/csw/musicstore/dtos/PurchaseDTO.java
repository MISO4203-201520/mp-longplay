/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.dtos;

import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jd.patino10
 */
public class PurchaseDTO {
    @PodamExclude
    private Long id;
    
    @PodamExclude
    private ClientDTO client;

    private String paymentMethod;    
    @XmlJavaTypeAdapter(DateAdapter.class)
    @PodamExclude
    private Date date;
    
    
    private Float total;

    private Float iva;
    @PodamExclude
    private List<PurchaseDetailDTO> purchaseDetail;
    private String cardNumber;
    private String nameCardOwner;
    private String expirationDate;
    private String CVC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public List<PurchaseDetailDTO> getPurchaseDetail() {
        return purchaseDetail;
    }

    public void setPurchaseDetail(List<PurchaseDetailDTO> purchaseDetail) {
        this.purchaseDetail = purchaseDetail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameCardOwner() {
        return nameCardOwner;
    }

    public void setNameCardOwner(String nameCardOwner) {
        this.nameCardOwner = nameCardOwner;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }
}
