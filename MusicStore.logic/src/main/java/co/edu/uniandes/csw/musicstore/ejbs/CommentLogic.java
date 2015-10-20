/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.ICommentLogic;
import co.edu.uniandes.csw.musicstore.converters.CommentConverter;
import co.edu.uniandes.csw.musicstore.dtos.CommentDTO;
import co.edu.uniandes.csw.musicstore.entities.CommentEntity;
import co.edu.uniandes.csw.musicstore.persistence.CommentPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author va.bastidas10
 */
@Stateless
public class CommentLogic implements ICommentLogic{
    
    @Inject private CommentPersistence persistence;
    
    @Override
    public CommentDTO createComment(CommentDTO dto) {
        CommentEntity entity = CommentConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CommentConverter.fullEntity2DTO(entity);
    }
}
