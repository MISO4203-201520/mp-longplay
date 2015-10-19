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
    @Override
    public int countLongPlays() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public List<LongPlayDTO> getLongPlays(Integer page, Integer maxRecords) {
        return LongPlayConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public LongPlayDTO getLongPlay(Long id) {
        return LongPlayConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public LongPlayDTO createLongPlay(LongPlayDTO dto) {
        LongPlayEntity entity = LongPlayConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return LongPlayConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public LongPlayDTO updateLongPlay(LongPlayDTO dto) {
        LongPlayEntity entity = persistence.update(LongPlayConverter.fullDTO2Entity(dto));
        return LongPlayConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deleteLongPlay(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    @Override
    public List<LongPlayDTO> findByName(String name) {
        return LongPlayConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    @Override
    public List<LongPlayDTO> findByAlbumName(String albumName) {
        return LongPlayConverter.listEntity2DTO(persistence.findByAlbumName(albumName));
    }
    
    @Override
    public List<LongPlayDTO> getCheaperProduct(Long priceMax){       
        return LongPlayConverter.listEntity2DTO(persistence.getCheaperProduct(priceMax));
    }
}
