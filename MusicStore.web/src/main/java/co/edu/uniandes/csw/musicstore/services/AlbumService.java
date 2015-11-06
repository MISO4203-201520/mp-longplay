package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.IAlbumLogic;
import co.edu.uniandes.csw.musicstore.dtos.AlbumDTO;
import co.edu.uniandes.csw.musicstore.dtos.PurchaseDetailDTO;
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

/**
 * @generated
 */
@Path("/albums")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlbumService {

    @Inject private IAlbumLogic albumLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public AlbumDTO createAlbum(AlbumDTO dto) {
        return albumLogic.createAlbum(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<AlbumDTO> getAlbums() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", albumLogic.countAlbums());
        }
        return albumLogic.getAlbums(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public AlbumDTO getAlbum(@PathParam("id") Long id) {
        return albumLogic.getAlbum(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public AlbumDTO updateAlbum(@PathParam("id") Long id, AlbumDTO dto) {
        dto.setId(id);
        return albumLogic.updateAlbum(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteAlbum(@PathParam("id") Long id) {
        albumLogic.deleteAlbum(id);
    }
    
    @GET
    @Path("/sellers")
    public List<AlbumDTO> getTopSellerAlbums() {
        System.out.println("entro1");
        return albumLogic.getTopSellerAlbums();
    }
}
