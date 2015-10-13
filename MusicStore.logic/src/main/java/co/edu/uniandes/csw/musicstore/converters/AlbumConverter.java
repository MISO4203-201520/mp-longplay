package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO;
import co.edu.uniandes.csw.musicstore.entities.AlbumEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class AlbumConverter {

    /**
     * @generated
     */
    private AlbumConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static AlbumDTO refEntity2DTO(AlbumEntity entity) {
        if (entity != null) {
            AlbumDTO dto = new AlbumDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCover(entity.getCover());
            dto.setRelease(entity.getRelease());
            dto.setSingle(entity.getSingle());
            dto.setArtist(entity.getArtist());
            dto.setPublicationDate(entity.getPublicationDate());  //Nuevo
            dto.setAwards(entity.getAwards());
            dto.setHistoricReview(entity.getHistoricReview());
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
    public static AlbumEntity refDTO2Entity(AlbumDTO dto) {
        if (dto != null) {
            AlbumEntity entity = new AlbumEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static AlbumDTO basicEntity2DTO(AlbumEntity entity) {
        if (entity != null) {
            AlbumDTO dto = new AlbumDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCover(entity.getCover());
            dto.setRelease(entity.getRelease());
            dto.setSingle(entity.getSingle());
            dto.setArtist(entity.getArtist());
            dto.setPublicationDate(entity.getPublicationDate()); // Nuevo
            dto.setAwards(entity.getAwards());
            dto.setHistoricReview(entity.getHistoricReview());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static AlbumEntity basicDTO2Entity(AlbumDTO dto) {
        if (dto != null) {
            AlbumEntity entity = new AlbumEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setCover(dto.getCover());
            entity.setRelease(dto.getRelease());
            entity.setSingle(dto.getSingle());
            entity.setArtist(dto.getArtist());
            entity.setPublicationDate(dto.getPublicationDate()); // Nuevo
            entity.setAwards(dto.getAwards());
            entity.setHistoricReview(dto.getHistoricReview());
           
                    
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static AlbumDTO fullEntity2DTO(AlbumEntity entity) {
        if (entity != null) {
            AlbumDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static AlbumEntity fullDTO2Entity(AlbumDTO dto) {
        if (dto != null) {
            AlbumEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<AlbumDTO> listEntity2DTO(List<AlbumEntity> entities) {
        List<AlbumDTO> dtos = new ArrayList<AlbumDTO>();
        if (entities != null) {
            for (AlbumEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<AlbumEntity> listDTO2Entity(List<AlbumDTO> dtos) {
        List<AlbumEntity> entities = new ArrayList<AlbumEntity>();
        if (dtos != null) {
            for (AlbumDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
