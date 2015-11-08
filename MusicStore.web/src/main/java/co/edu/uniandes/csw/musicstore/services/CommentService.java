/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.IClientLogic;
import co.edu.uniandes.csw.musicstore.api.ICommentLogic;
import co.edu.uniandes.csw.musicstore.dtos.ClientDTO;
import co.edu.uniandes.csw.musicstore.dtos.CommentDTO;
import co.edu.uniandes.csw.musicstore.providers.StatusCreated;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author va.bastidas10
 */
@Path("/comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentService {
    @Inject
    private ICommentLogic commentLogic;
    @Inject private IClientLogic clientLogic;
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");
    
    
    @POST
    @StatusCreated
    public CommentDTO createComment (CommentDTO dto) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date fecha = new Date();
	String dateInString = dateFormat.format(fecha);
        try {
		Date date = dateFormat.parse(dateInString);
                dto.setCommentDate(date);
	} catch (ParseException e) {
                dto.setCommentDate(null);
	}
        
        ClientDTO clientSession = null;
        if(client == null)
            clientSession = clientLogic.getClient(dto.getClientId());
        else
            clientSession = client;
        
        dto.setClient(clientSession);
        
        
        return commentLogic.createComment(dto);
    }
}
