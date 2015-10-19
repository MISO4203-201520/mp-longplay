/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jd.patino10
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "PurchaseDetailEntity.getProviderLongPlayPurchases", query = "select u from PurchaseDetailEntity u WHERE u.longPlay.provider.userId = :providerId")
})
public class PurchaseDetailEntity implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    @Id
    @GeneratedValue(generator = "PurchaseDetail")
    private Long id;
    
    @ManyToOne
    private PurchaseEntity purchase;
    @ManyToOne
    private LongPlayEntity longPlay;         
    
    private Integer quantity;

    private Integer price;
    
    private Boolean isConfirm;
    
    @Temporal(TemporalType.DATE)
    private Date confirmDate;
    
    private String confirmObservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseEntity getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseEntity purchase) {
        this.purchase = purchase;
    }

    public LongPlayEntity getLongPlay() {
        return longPlay;
    }

    public void setLongPlay(LongPlayEntity longPlay) {
        this.longPlay = longPlay;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(Boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getConfirmObservations() {
        return confirmObservations;
    }

    public void setConfirmObservations(String confirmObservations) {
        this.confirmObservations = confirmObservations;
    }
}