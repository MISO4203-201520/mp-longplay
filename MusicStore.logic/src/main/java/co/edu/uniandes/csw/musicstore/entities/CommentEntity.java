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

/**
 *
 * @author va.bastidas10
 */
@Entity
public class CommentEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "Comment")
    private Long id;
    private String description;
    private String commentUser;
    @Temporal(TemporalType.DATE)
    private Date commentDate;
        
    @ManyToOne
    private LongPlayEntity longPlay;

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
        
    public String getCommentUser() {
        return commentUser;
    }
        
    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
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
}



