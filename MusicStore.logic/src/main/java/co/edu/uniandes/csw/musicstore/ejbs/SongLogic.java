package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.ISongLogic;
import co.edu.uniandes.csw.musicstore.converters.SongConverter;
import co.edu.uniandes.csw.musicstore.dtos.SongDTO;
import co.edu.uniandes.csw.musicstore.entities.SongEntity;
import co.edu.uniandes.csw.musicstore.persistence.SongPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class SongLogic implements ISongLogic {

    @Inject
    private SongPersistence persistence;

    @Override
    public int countSongs() {
        return persistence.count();
    }

    @Override
    public List<SongDTO> getSongs(Integer page, Integer maxRecords) {
        return SongConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    @Override
    public SongDTO getSong(Long id) {
        return SongConverter.fullEntity2DTO(persistence.find(id));
    }

    @Override
    public SongDTO createSong(SongDTO dto) {
        SongEntity entity = SongConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return SongConverter.fullEntity2DTO(entity);
    }

    @Override
    public SongDTO updateSong(SongDTO dto) {
        SongEntity entity = persistence.update(SongConverter.fullDTO2Entity(dto));
        return SongConverter.fullEntity2DTO(entity);
    }

    @Override
    public void deleteSong(Long id) {
        persistence.delete(id);
    }

    @Override
    public List<SongDTO> findByName(String name) {
        return SongConverter.listEntity2DTO(persistence.findByName(name));
    }

    @Override
    public List<SongDTO> findByLongPlay(String longPlay) {
        return SongConverter.listEntity2DTO(persistence.findByLongPlay(longPlay));
    }
}
