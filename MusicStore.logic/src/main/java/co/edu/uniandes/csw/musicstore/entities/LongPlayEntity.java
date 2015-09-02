package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "LongPlay.getByAlbumName", query = "select u from LongPlayEntity u WHERE u.album.name = :albumName")
})
public class LongPlayEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "LongPlay")
    private Long id;

    private String name;

    private Integer price;
    private Integer discount;

    @ManyToOne
    private AlbumEntity album;
    @ManyToOne
    private ProviderEntity provider;
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
    public Integer getPrice(){
        return price;
    }

    /**
     * @generated
     */
    public void setPrice(Integer price){
        this.price = price;
    }

    /**
     * @generated
     */
    public AlbumEntity getAlbum() {
        return album;
    }

    /**
     * @generated
     */
    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    /**
     * @generated
     */
    public ProviderEntity getProvider() {
        return provider;
    }

    /**
     * @generated
     */
    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
