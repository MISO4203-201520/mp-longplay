/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import java.util.List;

/**
 *
 * @author jd.patino10
 */
public interface IPurchaseLogic {
    public int countPurchases();
    //public List<PurchaseDTO> getPurchases(Integer page, Integer maxRecords);
    public PurchaseDTO getPurchase(Long id);
    public PurchaseDTO createPurchase(PurchaseDTO dto);
    public PurchaseDTO updatePurchase(PurchaseDTO dto);
    public void deletePurchase(Long id);
    
}
