package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @generated
 */
@Entity
public class AlbumEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Album")
    private Long id;

    private String name;

    private String cover;

    @Temporal(TemporalType.DATE)
    private Date release;

    private Boolean single;

    private String artist;
    
    @Temporal(TemporalType.DATE)  // Nuevo a tributo y definición de formato
    private Date publicationDate; 
            
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
    public String getCover(){
        return cover;
    }

    /**
     * @generated
     */
    public void setCover(String cover){
        this.cover = cover;
    }

    /**
     * @generated
     */
    public Date getRelease(){
        return release;
    }

    /**
     * @generated
     */
    public void setRelease(Date release){
        this.release = release;
    }

    /**
     * @generated
     */
    public Boolean getSingle(){
        return single;
    }

    /**
     * @generated
     */
    public void setSingle(Boolean single){
        this.single = single;
    }

    /**
     * @generated
     */
    public String getArtist(){
        return artist;
    }

    /**
     * @generated
     */
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

}
