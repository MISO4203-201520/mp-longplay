package co.edu.uniandes.csw.musicstore.dtos;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @generated
 */
@XmlRootElement
public class LongPlayDTO {

    private Long id;
    private String name;
    private Integer price;
    private Integer discount;
    @PodamExclude
    private AlbumDTO album;
    @PodamExclude
    private ProviderDTO provider;
    @PodamExclude
    private List<CommentDTO> comments;
    @PodamExclude
    private List<SongDTO> songs;
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

    /**
     * @return the comments
     */
    public List<CommentDTO> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
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
