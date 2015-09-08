/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.services;
import co.edu.uniandes.csw.musicstore.api.IPurchaseLogic;
import co.edu.uniandes.csw.musicstore.api.IClientLogic;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDTO;
import co.edu.uniandes.csw.musicstore.dtos.ClientDTO;
import co.edu.uniandes.csw.musicstore.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;
/**
 *
 * @author jd.patino10
 */
@Path("/purchases")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseService {

    @Inject
    private IPurchaseLogic PurchaseLogic;
    @Inject
    private IClientLogic clientLogic;
    @Context
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public PurchaseDTO createPurchase(PurchaseDTO dto) {
        if (client != null) {            
            dto.setClient(client);
            return PurchaseLogic.createPurchase(dto);
        }
        return null;
    }

    /**
     * @generated
     */
    /*@GET
    public List<PurchaseDTO> getPurchases() {
        return clientLogic.getClient(client.getId()).getPurchases();
    }*/

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public PurchaseDTO getPurchase(@PathParam("id") Long id) {
        return PurchaseLogic.getPurchase(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public PurchaseDTO updatePurchase(@PathParam("id") Long id, PurchaseDTO dto) {
        dto.setId(id);
        return PurchaseLogic.updatePurchase(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePurchase(@PathParam("id") Long id) {
        PurchaseLogic.deletePurchase(id);
    }
}
