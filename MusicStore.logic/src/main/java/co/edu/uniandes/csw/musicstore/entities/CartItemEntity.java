package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @generated
 */
@Entity
public class CartItemEntity implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    @Id
    @GeneratedValue(generator = "CartItem")
    private Long id;

    private String name;

    private Integer quantity;

    @ManyToOne
    private ClientEntity client;
    @ManyToOne
    private LongPlayEntity longPlay;
    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName(){
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @generated
     */
    public Integer getQuantity(){
        return quantity;
    }

    /**
     * @generated
     */
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    /**
     * @generated
     */
    public ClientEntity getClient() {
        return client;
    }

    /**
     * @generated
     */
    public void setClient(ClientEntity client) {
        this.client = client;
    }

    /**
     * @generated
     */
    public LongPlayEntity getLongPlay() {
        return longPlay;
    }

    /**
     * @generated
     */
    public void setLongPlay(LongPlayEntity longplay) {
        this.longPlay = longplay;
    }

}
