package co.edu.uniandes.csw.musicstore.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class LongPlayDTO {

    private Long id;
    private String name;
    private Integer price;
    private Integer discount;
    private AlbumDTO album;
    private ProviderDTO provider;
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
    public Integer getPrice() {
        return price;
    }

    /**
     * @generated
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @generated
     */
    public AlbumDTO getAlbum() {
        return album;
    }

    /**
     * @generated
     */
    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    /**
     * @generated
     */
    public ProviderDTO getProvider() {
        return provider;
    }

    /**
     * @generated
     */
    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
