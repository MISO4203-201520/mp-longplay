/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import javax.ejb.Stateless;

/**
 *
 * @author jd.patino10
 */
@Stateless
public class PurchasePersistence extends CrudPersistence<PurchaseEntity> {
    public PurchasePersistence() {
        this.entityClass = PurchaseEntity.class;
    }
}
