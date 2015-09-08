/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.ICommentLogic;
import co.edu.uniandes.csw.musicstore.dtos.CommentDTO;
import co.edu.uniandes.csw.musicstore.providers.StatusCreated;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    
    @POST
    @StatusCreated
    public CommentDTO createComment (CommentDTO dto) {
        //dto.setLongPlay(longPlayLogic.getLongPlay(dto.getLongPlay().getLongPlayId()));
        return commentLogic.createComment(dto);
    }
}
