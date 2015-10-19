package co.edu.uniandes.csw.musicstore.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author je.barrera11
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Song.getByLongPlay", query = "select s from SongEntity s WHERE s.longPlay.id = :longPlay")})
public class SongEntity implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    @Id
    @GeneratedValue(generator = "Song")
    @PodamExclude
    private Long id;

    private String title;

    private Float duration;

    private String genre;

    private String author;

    private String sample;

    @ManyToOne
    @PodamExclude
    private LongPlayEntity longPlay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public LongPlayEntity getLongPlay() {
        return longPlay;
    }

    public void setLongPlay(LongPlayEntity longPlay) {
        this.longPlay = longPlay;
    }
}
