package co.edu.uniandes.csw.musicstore.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author je.barrera11
 */
@XmlRootElement
public class SongDTO {

    @PodamExclude
    private Long id;

    private String title;

    private Float duration;

    private String genre;

    private String author;

    private String sample;

    @PodamExclude
    private LongPlayDTO longPlay;

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

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LongPlayDTO getLongPlay() {
        return longPlay;
    }

    public void setLongPlay(LongPlayDTO longPlay) {
        this.longPlay = longPlay;
    }
}
