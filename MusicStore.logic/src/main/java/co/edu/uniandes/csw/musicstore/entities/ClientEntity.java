package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

/**
 * @generated
 */
@Entity
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Client")
    private Long id;

    private String name;

    private String userId;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> cartItems;
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
    public String getUserId(){
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * @generated
     */
    public List<CartItemEntity> getCartItems() {
        return cartItems;
    }

    /**
     * @generated
     */
    public void setCartItems(List<CartItemEntity> cartitems) {
        this.cartItems = cartitems;
    }

}
