package co.edu.uniandes.csw.musicstore.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class CartItemDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private ClientDTO client;
    private LongPlayDTO longPlay;
    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @generated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @generated
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * @generated
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

    /**
     * @generated
     */
    public LongPlayDTO getLongPlay() {
        return longPlay;
    }

    /**
     * @generated
     */
    public void setLongPlay(LongPlayDTO longplay) {
        this.longPlay = longplay;
    }

}
