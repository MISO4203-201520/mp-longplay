package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.ILongPlayLogic;
import co.edu.uniandes.csw.musicstore.converters.LongPlayConverter;
import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.persistence.LongPlayPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class LongPlayLogic implements ILongPlayLogic {

    @Inject private LongPlayPersistence persistence;

    /**
     * @generated
     */
    public int countLongPlays() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<LongPlayDTO> getLongPlays(Integer page, Integer maxRecords) {
        return LongPlayConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public LongPlayDTO getLongPlay(Long id) {
        return LongPlayConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public LongPlayDTO createLongPlay(LongPlayDTO dto) {
        LongPlayEntity entity = LongPlayConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return LongPlayConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public LongPlayDTO updateLongPlay(LongPlayDTO dto) {
        LongPlayEntity entity = persistence.update(LongPlayConverter.fullDTO2Entity(dto));
        return LongPlayConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteLongPlay(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<LongPlayDTO> findByName(String name) {
        return LongPlayConverter.listEntity2DTO(persistence.findByName(name));
    }
}
