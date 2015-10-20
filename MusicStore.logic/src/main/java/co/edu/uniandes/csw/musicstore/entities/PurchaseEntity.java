/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author jd.patino10
 */
@Entity
    @NamedQueries({
        @NamedQuery(name = "PurchaseEntity.getUserPurchases", query = "select u from PurchaseEntity u WHERE u.client.userId = :userId")})
public class PurchaseEntity implements Serializable{
    
    private static final long serialVersionUID = 1905122041950251207L;
    
    @Id
    @GeneratedValue(generator = "Purchase")
    @PodamExclude
    private Long id;
    
    @ManyToOne
    @PodamExclude
    private ClientEntity client;

    private String paymentMethod;    
    

    @Temporal(TemporalType.DATE)
    @PodamExclude
    private Date date;
    
    
    private Float total;

    private Float iva;
    @PodamExclude
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
