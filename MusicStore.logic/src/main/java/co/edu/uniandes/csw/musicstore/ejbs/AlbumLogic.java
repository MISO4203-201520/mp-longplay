package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.IAlbumLogic;
import co.edu.uniandes.csw.musicstore.converters.AlbumConverter;
import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO;
import co.edu.uniandes.csw.musicstore.entities.AlbumEntity;
import co.edu.uniandes.csw.musicstore.persistence.AlbumPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class AlbumLogic implements IAlbumLogic {

    @Inject private AlbumPersistence persistence;

    /**
     * @generated
     */
    public int countAlbums() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<AlbumDTO> getAlbums(Integer page, Integer maxRecords) {
        return AlbumConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public AlbumDTO getAlbum(Long id) {
        return AlbumConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public AlbumDTO createAlbum(AlbumDTO dto) {
        AlbumEntity entity = AlbumConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return AlbumConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public AlbumDTO updateAlbum(AlbumDTO dto) {
        AlbumEntity entity = persistence.update(AlbumConverter.fullDTO2Entity(dto));
        return AlbumConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteAlbum(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<AlbumDTO> findByName(String name) {
        return AlbumConverter.listEntity2DTO(persistence.findByName(name));
    }
}
