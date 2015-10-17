/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.converters;
import co.edu.uniandes.csw.musicstore.dtos.CartItemDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.entities.CartItemEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import co.edu.uniandes.csw.musicstore.entities.ClientEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jd.patino10
 */
public abstract class PurchaseConverter {
   
    /**
     * @param entity
     * @return
     * @generated
     */
    public static PurchaseDTO refEntity2DTO(PurchaseEntity entity) {
        if (entity != null) {
            PurchaseDTO dto = new PurchaseDTO();
            dto.setId(entity.getId());
            dto.setDate(entity.getDate());
            dto.setPaymentMethod(entity.getPaymentMethod());
            dto.setCardNumber(entity.getCardNumber());
            dto.setNameCardOwner(entity.getNameCardOwner());
            dto.setExpirationDate(entity.getExpirationDate());
            dto.setCVC(entity.getCVC());
            dto.setTotal(entity.getTotal());
            dto.setIva(entity.getIva());

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
    public static PurchaseEntity refDTO2Entity(PurchaseDTO dto) {
        if (dto != null) {
            PurchaseEntity entity = new PurchaseEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static PurchaseDTO basicEntity2DTO(PurchaseEntity entity) {
        if (entity != null) {
            PurchaseDTO dto = new PurchaseDTO();
            dto.setId(entity.getId());
            dto.setDate(entity.getDate());
            dto.setPaymentMethod(entity.getPaymentMethod());
            dto.setCardNumber(entity.getCardNumber());
            dto.setNameCardOwner(entity.getNameCardOwner());
            dto.setExpirationDate(entity.getExpirationDate());
            dto.setCVC(entity.getCVC());
            dto.setTotal(entity.getTotal());
            dto.setIva(entity.getIva());
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PurchaseEntity basicDTO2Entity(PurchaseDTO dto) {
        if (dto != null) {
            PurchaseEntity entity = new PurchaseEntity();
            entity.setId(dto.getId());
            entity.setDate(dto.getDate());
            entity.setPaymentMethod(dto.getPaymentMethod());
            entity.setCardNumber(dto.getCardNumber());
            entity.setNameCardOwner(dto.getNameCardOwner());
            entity.setExpirationDate(dto.getExpirationDate());
            entity.setCVC(dto.getCVC());
            entity.setIva(dto.getIva());
            entity.setTotal(dto.getTotal());
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PurchaseDTO fullEntity2DTO(PurchaseEntity entity) {
        if (entity != null) {
            PurchaseDTO dto = basicEntity2DTO(entity);
            dto.setPurchaseDetail(PurchaseDetailConverter.listEntity2DTO(entity.getPurchaseDetail()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static PurchaseEntity fullDTO2Entity(PurchaseDTO dto) {
        if (dto != null) {
            PurchaseEntity entity = basicDTO2Entity(dto);
            entity.setPurchaseDetail(PurchaseDetailConverter.childListDTO2Entity(dto.getPurchaseDetail(), entity));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<PurchaseDTO> listEntity2DTO(List<PurchaseEntity> entities) {
        List<PurchaseDTO> dtos = new ArrayList<PurchaseDTO>();
        if (entities != null) {
            for (PurchaseEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<PurchaseEntity> listDTO2Entity(List<PurchaseDTO> dtos) {
        List<PurchaseEntity> entities = new ArrayList<PurchaseEntity>();
        if (dtos != null) {
            for (PurchaseDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static PurchaseEntity childDTO2Entity(PurchaseDTO dto, ClientEntity parent){
        PurchaseEntity entity = basicDTO2Entity(dto);
        entity.setClient(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<PurchaseEntity> childListDTO2Entity(List<PurchaseDTO> dtos, ClientEntity parent) {
        List<PurchaseEntity> entities = new ArrayList<PurchaseEntity>();
        if (dtos != null) {
            for (PurchaseDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
