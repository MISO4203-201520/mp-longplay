/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.dtos;

import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import javax.persistence.ManyToOne;

/**
 *
 * @author jd.patino10
 */
public class PurchaseDetailDTO {
  private Long id;
    
    
    private PurchaseDTO purchase;
    
    private LongPlayDTO longPlay;         
    
    private Integer quantity;

    private Integer price;   

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
}
