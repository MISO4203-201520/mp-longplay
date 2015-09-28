package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.SongDTO;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.SongEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class SongConverter {

    private SongConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static SongDTO refEntity2DTO(SongEntity entity) {

        if (entity != null) {
            SongDTO dto = new SongDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setDuration(entity.getDuration());
            dto.setGenre(entity.getGenre());
            dto.setAuthor(entity.getAuthor());
            dto.setLongPlay(LongPlayConverter.refEntity2DTO(entity.getLongPlay()));
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
    public static SongEntity refDTO2Entity(SongDTO dto) {

        if (dto != null) {
            SongEntity entity = new SongEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static SongDTO basicEntity2DTO(SongEntity entity) {
        if (entity != null) {
            SongDTO dto = new SongDTO();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setDuration(entity.getDuration());
            dto.setGenre(entity.getGenre());
            dto.setAuthor(entity.getAuthor());
            dto.setLongPlay(LongPlayConverter.refEntity2DTO(entity.getLongPlay()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static SongEntity basicDTO2Entity(SongDTO dto) {

        if (dto != null) {
            SongEntity entity = new SongEntity();
            entity.setId(dto.getId());
            entity.setTitle(dto.getTitle());
            entity.setDuration(dto.getDuration());
            entity.setGenre(dto.getGenre());
            entity.setAuthor(dto.getAuthor());
            entity.setLongPlay(LongPlayConverter.refDTO2Entity(dto.getLongPlay()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static SongDTO fullEntity2DTO(SongEntity entity) {
        if (entity != null) {
            SongDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static SongEntity fullDTO2Entity(SongDTO dto) {
        if (dto != null) {
            SongEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static List<SongDTO> listEntity2DTO(List<SongEntity> entities) {
        List<SongDTO> dtos = new ArrayList<SongDTO>();
        if (entities != null) {
            for (SongEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<SongEntity> listDTO2Entity(List<SongDTO> dtos) {
        List<SongEntity> entities = new ArrayList<SongEntity>();
        if (dtos != null) {
            for (SongDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static SongEntity childDTO2Entity(SongDTO dto, LongPlayEntity parent) {
        SongEntity entity = basicDTO2Entity(dto);
        entity.setLongPlay(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<SongEntity> childListDTO2Entity(List<SongDTO> dtos, LongPlayEntity parent) {
        List<SongEntity> entities = new ArrayList<SongEntity>();
        if (dtos != null) {
            for (SongDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
