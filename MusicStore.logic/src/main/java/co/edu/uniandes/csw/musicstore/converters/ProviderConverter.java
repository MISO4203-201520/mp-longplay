package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.ProviderDTO;
import co.edu.uniandes.csw.musicstore.entities.ProviderEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ProviderConverter {

    /**
     * @generated
     */
    private ProviderConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ProviderDTO refEntity2DTO(ProviderEntity entity) {
        if (entity != null) {
            ProviderDTO dto = new ProviderDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUserId(entity.getUserId());

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
    public static ProviderEntity refDTO2Entity(ProviderDTO dto) {
        if (dto != null) {
            ProviderEntity entity = new ProviderEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ProviderDTO basicEntity2DTO(ProviderEntity entity) {
        if (entity != null) {
            ProviderDTO dto = new ProviderDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUserId(entity.getUserId());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ProviderEntity basicDTO2Entity(ProviderDTO dto) {
        if (dto != null) {
            ProviderEntity entity = new ProviderEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setUserId(dto.getUserId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ProviderDTO fullEntity2DTO(ProviderEntity entity) {
        if (entity != null) {
            ProviderDTO dto = basicEntity2DTO(entity);
            dto.setLongPlays(LongPlayConverter.listEntity2DTO(entity.getLongPlays()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ProviderEntity fullDTO2Entity(ProviderDTO dto) {
        if (dto != null) {
            ProviderEntity entity = basicDTO2Entity(dto);
            entity.setLongPlays(LongPlayConverter.childListDTO2Entity(dto.getLongPlays(), entity));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ProviderDTO> listEntity2DTO(List<ProviderEntity> entities) {
        List<ProviderDTO> dtos = new ArrayList<ProviderDTO>();
        if (entities != null) {
            for (ProviderEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ProviderEntity> listDTO2Entity(List<ProviderDTO> dtos) {
        List<ProviderEntity> entities = new ArrayList<ProviderEntity>();
        if (dtos != null) {
            for (ProviderDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
