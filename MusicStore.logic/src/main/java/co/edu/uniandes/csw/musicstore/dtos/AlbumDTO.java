package co.edu.uniandes.csw.musicstore.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @generated
 */
@XmlRootElement 
public class AlbumDTO {
    
    @PodamExclude
    private Long id;
    private String name;
    private String cover;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @PodamExclude
    private Date release;
    private Boolean single;
    private String artist;
    @PodamExclude
    private Date publicationDate;    // Nuevo atributo
    
    private String awards;
    
    private String historicReview;
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
    public String getCover() {
        return cover;
    }

    /**
     * @generated
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * @generated
     */
    public Date getRelease() {
        return release;
    }

    /**
     * @generated
     */
    public void setRelease(Date release) {
        this.release = release;
    }

    /**
     * @generated
     */
    public Boolean getSingle() {
        return single;
    }

    /**
     * @generated
     */
    public void setSingle(Boolean single) {
        this.single = single;
    }

    /**
     * @generated
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @generated
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public Date getPublicationDate() {
      return publicationDate;
    }

   public void setPublicationDate(Date publicationDate) {
     this.publicationDate = publicationDate;
   }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getHistoricReview() {
        return historicReview;
    }

    public void setHistoricReview(String historicReview) {
        this.historicReview = historicReview;
    }

   
}
