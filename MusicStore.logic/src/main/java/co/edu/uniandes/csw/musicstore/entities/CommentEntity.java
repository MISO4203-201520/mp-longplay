/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author va.bastidas10
 */
@Entity
public class CommentEntity implements Serializable{
    
    private static final long serialVersionUID = 1905122041950251207L;
    @Id
    @GeneratedValue(generator = "Comment")
    private Long id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date commentDate;
    private Long idPadre;
    @PodamExclude
    @ManyToOne
    private LongPlayEntity longPlay;
    @PodamExclude
    @ManyToOne
    private ClientEntity client;

    public Long getId() {
       return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
        
    public void setDescription(String description) {
        this.description = description;
    }
        
    public Date getCommentDate() {
         return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
    
    public LongPlayEntity getLongPlay() {
        return longPlay;
    }

    public void setLongPlay(LongPlayEntity longPlay) {
         this.longPlay = longPlay;
    }
    
    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
         this.client = client;
    }
    
    public Long getIdPadre() {
       return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }
}



