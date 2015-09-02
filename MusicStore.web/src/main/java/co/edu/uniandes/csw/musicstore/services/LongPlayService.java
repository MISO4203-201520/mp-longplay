package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.ILongPlayLogic;
import co.edu.uniandes.csw.musicstore.api.IProviderLogic;
import co.edu.uniandes.csw.musicstore.dtos.LongPlayDTO;
import co.edu.uniandes.csw.musicstore.dtos.ProviderDTO;
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
@Path("/longPlays")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LongPlayService {

    @Inject
    private ILongPlayLogic longPlayLogic;
    @Inject
    private IProviderLogic providerLogic;
    @Context
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    @QueryParam("q")
    private String albumName;
    private ProviderDTO provider = (ProviderDTO) SecurityUtils.getSubject().getSession().getAttribute("Provider");

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public LongPlayDTO createLongPlay(LongPlayDTO dto) {
        dto.setProvider(provider);
        return longPlayLogic.createLongPlay(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<LongPlayDTO> getLongPlays() {
        if (provider != null) {
            return providerLogic.getProvider(provider.getId()).getLongPlays();
        } else {
            if (albumName != null) {
                return longPlayLogic.findByAlbumName(albumName);
            }
            if (page != null && maxRecords != null) {
                this.response.setIntHeader("X-Total-Count", longPlayLogic.countLongPlays());
            }
            return longPlayLogic.getLongPlays(page, maxRecords);
        }
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public LongPlayDTO getLongPlay(@PathParam("id") Long id) {
        return longPlayLogic.getLongPlay(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public LongPlayDTO updateLongPlay(@PathParam("id") Long id, LongPlayDTO dto) {
        dto.setId(id);
        return longPlayLogic.updateLongPlay(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteLongPlay(@PathParam("id") Long id) {
        longPlayLogic.deleteLongPlay(id);
    }
}
