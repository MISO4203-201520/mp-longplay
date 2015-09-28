/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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
    
    public List<PurchaseEntity> getUserPurchases(String userId) {
        List<PurchaseEntity> result = new ArrayList<PurchaseEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            result = executeListNamedQuery("PurchaseEntity.getUserPurchases", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}