package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.CascadeType;

/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "LongPlay.getByAlbumName", query = "select u from LongPlayEntity u WHERE u.album.name = :albumName"),
    @NamedQuery(name = "LongPlay.getCheaperProduct", query = "select u from LongPlayEntity u WHERE u.price <= :priceMax order by u.price")
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

    @OneToMany(mappedBy = "longPlay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "longPlay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SongEntity> songs;

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

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<SongEntity> getSongs() {
        return songs;
    }

    public void setSongs(List<SongEntity> songs) {
        this.songs = songs;
    }
}
