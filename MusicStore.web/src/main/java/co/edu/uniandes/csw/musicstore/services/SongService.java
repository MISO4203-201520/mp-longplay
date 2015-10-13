package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.ISongLogic;
import co.edu.uniandes.csw.musicstore.dtos.SongDTO;
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
 *
 * @author je.barrera11
 */
@Path("/songs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SongService {

    @Inject
    private ISongLogic songLogic;
    @Context
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    @QueryParam("q")
    private String longPlay;

    @POST
    @StatusCreated
    public SongDTO createSong(SongDTO dto) {
        return songLogic.createSong(dto);
    }

    @GET
    public List<SongDTO> getSongs() {

        if (longPlay != null) {
            return songLogic.findByLongPlay(longPlay);
        }
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", songLogic.countSongs());
        }
        return songLogic.getSongs(page, maxRecords);

    }

    @GET
    @Path("{id: \\d+}")
    public SongDTO getSong(@PathParam("id") Long id) {
        return songLogic.getSong(id);
    }

    @PUT
    @Path("{id: \\d+}")
    public SongDTO updateSong(@PathParam("id") Long id, SongDTO dto) {
        dto.setId(id);
        return songLogic.updateSong(dto);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteSong(@PathParam("id") Long id) {
        songLogic.deleteSong(id);
    }
}
