package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.AlbumEntity;
import java.util.List;
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
    
    public List<AlbumEntity> getTopSeller()
    {
        return em.createNamedQuery("PurchaseDetailEntity.getTopSellerAlbums").setMaxResults(3).getResultList();
    }
}
