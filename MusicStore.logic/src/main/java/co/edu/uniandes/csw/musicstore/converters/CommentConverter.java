/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.CommentDTO;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.CommentEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author va.bastidas10
 */
public abstract class CommentConverter {

    /**
     * @param entity
     * @return
     * @generated
     */
    public static CommentDTO refEntity2DTO(CommentEntity entity) {
        if (entity != null) {
            CommentDTO dto = new CommentDTO();
            dto.setId(entity.getId());
            dto.setDescription(entity.getDescription());
            dto.setCommentDate(entity.getCommentDate());
            dto.setIdPadre(entity.getIdPadre());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static CommentEntity refDTO2Entity(CommentDTO dto) {
        if (dto != null) {
            CommentEntity entity = new CommentEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static CommentDTO basicEntity2DTO(CommentEntity entity) {
        if (entity != null) {
            CommentDTO dto = new CommentDTO();
            dto.setId(entity.getId());
            dto.setDescription(entity.getDescription());
            dto.setCommentDate(entity.getCommentDate());
            dto.setLongPlay(LongPlayConverter.refEntity2DTO(entity.getLongPlay()));
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));  
            dto.setIdPadre(entity.getIdPadre());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static CommentEntity basicDTO2Entity(CommentDTO dto) {
        if (dto != null) {
            CommentEntity entity = new CommentEntity();
            entity.setId(dto.getId());
            entity.setDescription(dto.getDescription());
            entity.setCommentDate(dto.getCommentDate());
            entity.setLongPlay(LongPlayConverter.refDTO2Entity(dto.getLongPlay()));
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));
            entity.setIdPadre(dto.getIdPadre());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static CommentDTO fullEntity2DTO(CommentEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static CommentEntity fullDTO2Entity(CommentDTO dto) {
        if (dto != null) {
            CommentEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static List<CommentDTO> listEntity2DTO(List<CommentEntity> entities) {
        List<CommentDTO> dtos = new ArrayList<CommentDTO>();
        if (entities != null) {
            for (CommentEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<CommentEntity> listDTO2Entity(List<CommentDTO> dtos) {
        List<CommentEntity> entities = new ArrayList<CommentEntity>();
        if (dtos != null) {
            for (CommentDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static CommentEntity childDTO2Entity(CommentDTO dto, LongPlayEntity parent) {
        CommentEntity entity = basicDTO2Entity(dto);
        entity.setLongPlay(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<CommentEntity> childListDTO2Entity(List<CommentDTO> dtos, LongPlayEntity parent) {
        List<CommentEntity> entities = new ArrayList<CommentEntity>();
        if (dtos != null) {
            for (CommentDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
