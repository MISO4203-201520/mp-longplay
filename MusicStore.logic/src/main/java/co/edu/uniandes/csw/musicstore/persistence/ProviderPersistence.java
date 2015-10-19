package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.ProviderEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ProviderPersistence extends CrudPersistence<ProviderEntity> {

    /**
     * @generated
     */
    public ProviderPersistence() {
        this.entityClass = ProviderEntity.class;
    }

    public ProviderEntity getProviderByUserId(String userId) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("user_id", userId);
            return this.executeSingleNamedQuery("Provider.getByUserId", params);
        } catch (NoResultException e) {
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }
}
