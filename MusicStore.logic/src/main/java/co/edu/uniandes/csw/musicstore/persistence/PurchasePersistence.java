/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.LongPlayEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseDetailEntity;
import co.edu.uniandes.csw.musicstore.entities.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
        }
        return result;
    }
    
    public List<PurchaseDetailEntity> getProviderPurchases(String userId) {
        List<PurchaseDetailEntity> result = new ArrayList<PurchaseDetailEntity>();
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("providerId", userId);
            result = executeListNamedQuery("PurchaseDetailEntity.getProviderLongPlayPurchases", params);
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
        }
        return result;
    }
}