package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.musicstore.entities.ProviderEntity;

/**
 * @generated
 */
public abstract class LongPlayConverter {

    /**
     * @generated
     */
    private LongPlayConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static LongPlayDTO refEntity2DTO(LongPlayEntity entity) {
        
        if (entity != null) {
            LongPlayDTO dto = new LongPlayDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDiscount(entity.getDiscount());
            dto.setAlbum(AlbumConverter.refEntity2DTO(entity.getAlbum()));
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
    public static LongPlayEntity refDTO2Entity(LongPlayDTO dto) {
        
        if (dto != null) {
            LongPlayEntity entity = new LongPlayEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static LongPlayDTO basicEntity2DTO(LongPlayEntity entity) {
      
        if (entity != null) {
            LongPlayDTO dto = new LongPlayDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDiscount(entity.getDiscount());
            dto.setAlbum(AlbumConverter.refEntity2DTO(entity.getAlbum()));
            dto.setProvider(ProviderConverter.refEntity2DTO(entity.getProvider()));
            dto.setComments(CommentConverter.listEntity2DTO(entity.getComments()));
            dto.setSongs(SongConverter.listEntity2DTO(entity.getSongs()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static LongPlayEntity basicDTO2Entity(LongPlayDTO dto) {
        if (dto != null) {
            LongPlayEntity entity = new LongPlayEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setPrice(dto.getPrice());
            entity.setDiscount(dto.getDiscount());
            entity.setAlbum(AlbumConverter.refDTO2Entity(dto.getAlbum()));
            entity.setProvider(ProviderConverter.refDTO2Entity(dto.getProvider()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static LongPlayDTO fullEntity2DTO(LongPlayEntity entity) {
        if (entity != null) {
            LongPlayDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static LongPlayEntity fullDTO2Entity(LongPlayDTO dto) {
        if (dto != null) {
            LongPlayEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<LongPlayDTO> listEntity2DTO(List<LongPlayEntity> entities) {
        List<LongPlayDTO> dtos = new ArrayList<LongPlayDTO>();
        if (entities != null) {
            for (LongPlayEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<LongPlayEntity> listDTO2Entity(List<LongPlayDTO> dtos) {
        List<LongPlayEntity> entities = new ArrayList<LongPlayEntity>();
        if (dtos != null) {
            for (LongPlayDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static LongPlayEntity childDTO2Entity(LongPlayDTO dto, ProviderEntity parent){
        LongPlayEntity entity = basicDTO2Entity(dto);
        entity.setProvider(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<LongPlayEntity> childListDTO2Entity(List<LongPlayDTO> dtos, ProviderEntity parent) {
        List<LongPlayEntity> entities = new ArrayList<LongPlayEntity>();
        if (dtos != null) {
            for (LongPlayDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}