package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.ICartItemLogic;
import co.edu.uniandes.csw.musicstore.api.IClientLogic;
import co.edu.uniandes.csw.musicstore.dtos.CartItemDTO;
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
 * @generated
 */
@Path("/cartItems")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartItemService {

    @Inject
    private ICartItemLogic cartItemLogic;
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
    public CartItemDTO createCartItem(CartItemDTO dto) {
        if (client != null) {
            dto.setClient(client);
            return cartItemLogic.createCartItem(dto);
        }
        return null;
    }

    /**
     * @generated
     */
    @GET
    public List<CartItemDTO> getCartItems() {
        return clientLogic.getClient(client.getId()).getCartItems();
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public CartItemDTO getCartItem(@PathParam("id") Long id) {
        return cartItemLogic.getCartItem(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public CartItemDTO updateCartItem(@PathParam("id") Long id, CartItemDTO dto) {
        dto.setId(id);
        return cartItemLogic.updateCartItem(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCartItem(@PathParam("id") Long id) {
        cartItemLogic.deleteCartItem(id);
    }
}
