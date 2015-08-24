package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.ClientEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ClientPersistence extends CrudPersistence<ClientEntity> {

    /**
     * @generated
     */
    public ClientPersistence() {
        this.entityClass = ClientEntity.class;
    }
}
