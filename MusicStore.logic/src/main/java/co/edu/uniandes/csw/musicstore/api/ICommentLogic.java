/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.CommentDTO;

/**
 *
 * @author va.bastidas10
 */
public interface ICommentLogic {
    public CommentDTO createComment(CommentDTO dto);
}
