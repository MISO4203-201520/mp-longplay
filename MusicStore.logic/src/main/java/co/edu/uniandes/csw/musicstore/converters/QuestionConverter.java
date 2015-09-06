/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.QuestionDTO;
import co.edu.uniandes.csw.musicstore.entities.QuestionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author je.barrera11
 */
public abstract class QuestionConverter {
    
    /**
     * @generated
     */
    private QuestionConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static QuestionDTO refEntity2DTO(QuestionEntity entity) {
        if (entity != null) {
            
            QuestionDTO dto = new QuestionDTO();
            dto.setId(entity.getId());
            dto.setDescription(entity.getDescription());
            dto.setPostDate(entity.getPostDate());

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
    public static QuestionEntity refDTO2Entity(QuestionDTO dto) {
        if (dto != null) {
            
            QuestionEntity entity = new QuestionEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static QuestionDTO basicEntity2DTO(QuestionEntity entity) {
        if (entity != null) {
            
            QuestionDTO dto = new QuestionDTO();
            dto.setId(entity.getId());
            dto.setDescription(entity.getDescription());
            dto.setPostDate(entity.getPostDate());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static QuestionEntity basicDTO2Entity(QuestionDTO dto) {
        if (dto != null) {
            
            QuestionEntity entity = new QuestionEntity();
            entity.setId(dto.getId());
            entity.setDescription(dto.getDescription());
            entity.setPostDate(dto.getPostDate());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static QuestionDTO fullEntity2DTO(QuestionEntity entity) {
        if (entity != null) {
            QuestionDTO dto = basicEntity2DTO(entity);
            dto.setAlbum(AlbumConverter.fullEntity2DTO(entity.getAlbum()));
            dto.setClient(ClientConverter.fullEntity2DTO(entity.getClient()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static QuestionEntity fullDTO2Entity(QuestionDTO dto) {
        if (dto != null) {
            QuestionEntity entity = basicDTO2Entity(dto);
            entity.setAlbum(AlbumConverter.fullDTO2Entity(dto.getAlbum()));
            entity.setClient(ClientConverter.fullDTO2Entity(dto.getClient()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<QuestionDTO> listEntity2DTO(List<QuestionEntity> entities) {
        List<QuestionDTO> dtos = new ArrayList<QuestionDTO>();
        if (entities != null) {
            for (QuestionEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<QuestionEntity> listDTO2Entity(List<QuestionDTO> dtos) {
        List<QuestionEntity> entities = new ArrayList<QuestionEntity>();
        if (dtos != null) {
            for (QuestionDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
}
