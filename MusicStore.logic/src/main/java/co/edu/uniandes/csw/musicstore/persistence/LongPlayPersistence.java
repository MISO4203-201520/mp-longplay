package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
            return new ArrayList<LongPlayEntity>();
        }
    }
    public List<LongPlayEntity> getCheaperProduct (Long priceMax){
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("priceMax",priceMax);
            return  executeListNamedQuery("LongPlay.getCheaperProduct",params);
            } catch(NoResultException e){
                Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
                return new ArrayList<LongPlayEntity>();
            }
        }
}
