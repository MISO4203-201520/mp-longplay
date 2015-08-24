package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.AlbumEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class AlbumPersistence extends CrudPersistence<AlbumEntity> {

    /**
     * @generated
     */
    public AlbumPersistence() {
        this.entityClass = AlbumEntity.class;
    }
}
