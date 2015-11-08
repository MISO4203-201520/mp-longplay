/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.converters;

import co.edu.uniandes.csw.musicstore.dtos.PurchaseDetailDTO;
import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jd.patino10
 */
public abstract class PurchaseDetailConverter {
    
    private PurchaseDetailConverter() {
    }
    
 /**
     * @param entity
     * @return
     * @generated
     */
    public static PurchaseDetailDTO refEntity2DTO(PurchaseDetailEntity entity) {
        if (entity != null) {
            PurchaseDetailDTO dto = new PurchaseDetailDTO();
            dto.setId(entity.getId());
            dto.setQuantity(entity.getQuantity());
            dto.setPrice(entity.getPrice());
            dto.setIsConfirm(entity.getIsConfirm());
            dto.setConfirmDate(entity.getConfirmDate());
            dto.setConfirmObservations(entity.getConfirmObservations());
            
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
    public static PurchaseDetailEntity refDTO2Entity(PurchaseDetailDTO dto) {
        if (dto != null) {
            PurchaseDetailEntity entity = new PurchaseDetailEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PurchaseDetailDTO basicEntity2DTO(PurchaseDetailEntity entity) {
        if (entity != null) {
            PurchaseDetailDTO dto = new PurchaseDetailDTO();
            dto.setId(entity.getId());
            dto.setQuantity(entity.getQuantity());
            dto.setPrice(entity.getPrice());
            dto.setPurchase(PurchaseConverter.refEntity2DTO(entity.getPurchase()));
            dto.setLongPlay(LongPlayConverter.refEntity2DTO(entity.getLongPlay()));
            dto.setConfirmDate(entity.getConfirmDate());
            dto.setConfirmObservations(entity.getConfirmObservations());
            dto.setIsConfirm(entity.getIsConfirm());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PurchaseDetailEntity basicDTO2Entity(PurchaseDetailDTO dto) {
        if (dto != null) {
            PurchaseDetailEntity entity = new PurchaseDetailEntity();
            entity.setId(dto.getId());
            entity.setQuantity(dto.getQuantity());
            entity.setPrice(dto.getPrice());
            entity.setPurchase(PurchaseConverter.refDTO2Entity(dto.getPurchase()));
            entity.setLongPlay(LongPlayConverter.refDTO2Entity(dto.getLongPlay()));
            entity.setIsConfirm(dto.getIsConfirm());
            entity.setConfirmDate(dto.getConfirmDate());
            entity.setConfirmObservations(dto.getConfirmObservations());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PurchaseDetailDTO fullEntity2DTO(PurchaseDetailEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PurchaseDetailEntity fullDTO2Entity(PurchaseDetailDTO dto) {
        if (dto != null) {
            PurchaseDetailEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<PurchaseDetailDTO> listEntity2DTO(List<PurchaseDetailEntity> entities) {
        List<PurchaseDetailDTO> dtos = new ArrayList<PurchaseDetailDTO>();
        if (entities != null) {
            for (PurchaseDetailEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<PurchaseDetailEntity> listDTO2Entity(List<PurchaseDetailDTO> dtos) {
        List<PurchaseDetailEntity> entities = new ArrayList<PurchaseDetailEntity>();
        if (dtos != null) {
            for (PurchaseDetailDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static PurchaseDetailEntity childDTO2Entity(PurchaseDetailDTO dto, PurchaseEntity parent){
        PurchaseDetailEntity entity = basicDTO2Entity(dto);
        entity.setPurchase(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<PurchaseDetailEntity> childListDTO2Entity(List<PurchaseDetailDTO> dtos, PurchaseEntity parent){
        List<PurchaseDetailEntity> entities = new ArrayList<PurchaseDetailEntity>();
        if (dtos != null) {
            for (PurchaseDetailDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
