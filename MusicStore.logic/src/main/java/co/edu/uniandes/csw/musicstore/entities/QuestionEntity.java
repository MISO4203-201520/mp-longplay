package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author je.barrera11
 */
@Entity
public class QuestionEntity implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @GeneratedValue(generator = "Question")
    @PodamExclude
    private Long id;

    @PodamExclude
    private AlbumEntity album;

    @PodamExclude
    private ClientEntity client;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date postDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
