package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class LongPlayPersistence extends CrudPersistence<LongPlayEntity> {

    /**
     * @generated
     */
    public LongPlayPersistence() {
        this.entityClass = LongPlayEntity.class;
    }

    public List<LongPlayEntity> findByAlbumName(String albumName) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("albumName", albumName);
            return this.executeListNamedQuery("LongPlay.getByAlbumName", params);
        } catch (NoResultException e) {
            return null;
        }
    }
}
