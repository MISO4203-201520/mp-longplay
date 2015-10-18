/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDetailDTO;
import java.util.List;

/**
 *
 * @author jd.patino10
 */
public interface IPurchaseLogic {
    public int countPurchases();
    public PurchaseDTO getPurchase(Long id);
    public PurchaseDTO createPurchase(PurchaseDTO dto);
    public PurchaseDTO updatePurchase(PurchaseDTO dto);
    public void deletePurchase(Long id);
    public List<PurchaseDTO> getUserPurchases(String userId);
    public List<PurchaseDetailDTO> getProviderPurchases(String providerId);
    public PurchaseDetailDTO confirmOrder(PurchaseDetailDTO dto);
    public PurchaseDetailDTO cancelOrder(PurchaseDetailDTO dto);
}
