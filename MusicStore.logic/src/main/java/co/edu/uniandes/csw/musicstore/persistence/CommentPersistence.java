/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.CommentEntity;
import javax.ejb.Stateless;

/**
 *
 * @author va.bastidas10
 */
@Stateless
public class CommentPersistence extends CrudPersistence<CommentEntity>{
    public CommentPersistence() {
        this.entityClass = CommentEntity.class;
    }
}
