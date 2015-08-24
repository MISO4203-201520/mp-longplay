package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.CartItemEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class CartItemPersistence extends CrudPersistence<CartItemEntity> {

    /**
     * @generated
     */
    public CartItemPersistence() {
        this.entityClass = CartItemEntity.class;
    }
}
