/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.entities;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author jd.patino10
 */
@Entity
public class PurchaseEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "Purchase")
    private Long id;
    
    @ManyToOne
    private ClientEntity client;

    private String paymentMethod;    
    

    @Temporal(TemporalType.DATE)
    private Date date;
    
    
    private Float total;

    private Float iva;
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseDetailEntity> purchaseDetail;
    private String cardNumber;
    private String nameCardOwner;
    private String expirationDate;
    private String CVC;
    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<PurchaseDetailEntity> getPurchaseDetail() {
        return purchaseDetail;
    }

    public void setPurchaseDetail(List<PurchaseDetailEntity> purchaseDetail) {
        this.purchaseDetail = purchaseDetail;
    }
}
