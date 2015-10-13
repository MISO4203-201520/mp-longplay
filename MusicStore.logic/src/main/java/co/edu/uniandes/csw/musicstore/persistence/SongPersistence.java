package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.SongEntity;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author je.barrera11
 */
@Stateless
public class SongPersistence extends CrudPersistence<SongEntity> {

    public SongPersistence() {
        this.entityClass = SongEntity.class;
    }

    public List<SongEntity> findByLongPlay(String longPlay) {
        try {
            HashMap<String, Object> params = new HashMap();
            params.put("longPlay", longPlay);
            return this.executeListNamedQuery("LongPlay.getByAlbumName", params);
        } catch (NoResultException e) {
            return null;
        }
    }
}