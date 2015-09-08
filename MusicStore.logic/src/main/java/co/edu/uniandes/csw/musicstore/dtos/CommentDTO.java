/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.dtos;
import java.util.Date;

/**
 *
 * @author va.bastidas10
 */
public class CommentDTO {
    private Long id;
    private String description;
    private Date commentDate;  
    private LongPlayDTO longPlay;
    private ClientDTO client;
    private Long clientId;
    
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
    
    public LongPlayDTO getLongPlay() {
        return longPlay;
    }

    public void setLongPlay(LongPlayDTO longPlay) {
         this.longPlay = longPlay;
    }
    
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    public ClientDTO getClient() {
        return client;
    }
    
    public void setClient(ClientDTO client) {
         this.client = client;
    }
}
