/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.dtos;

import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jd.patino10
 */
public class PurchaseDetailDTO {
    @PodamExclude
    private Long id;
    @PodamExclude
    private PurchaseDTO purchase;
    @PodamExclude
    private LongPlayDTO longPlay;         
    
    private Integer quantity;
    
    private Integer price; 
    
    private Boolean isConfirm;
    
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date confirmDate;
    
    private String confirmObservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchaseDTO getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDTO purchase) {
        this.purchase = purchase;
    }

    public LongPlayDTO getLongPlay() {
        return longPlay;
    }

    public void setLongPlay(LongPlayDTO longPlay) {
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
