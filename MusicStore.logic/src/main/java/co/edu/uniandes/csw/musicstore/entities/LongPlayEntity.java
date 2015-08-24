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
public class LongPlayEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "LongPlay")
    private Long id;

    private String name;

    private Integer price;

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

}
