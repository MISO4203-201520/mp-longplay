package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.IAlbumLogic;
import co.edu.uniandes.csw.musicstore.api.IClientLogic;
import co.edu.uniandes.csw.musicstore.api.IQuestionLogic;
import co.edu.uniandes.csw.musicstore.dtos.ClientDTO;
import co.edu.uniandes.csw.musicstore.dtos.QuestionDTO;
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
@Path("/questions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionService {

    @Inject private IQuestionLogic questionLogic;
    @Inject private IAlbumLogic albumLogic;
    @Inject private IClientLogic clientLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;
    
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public QuestionDTO createQuestion(QuestionDTO dto) {
        
        ClientDTO clientSession = null;
        if(client == null)
            clientSession = clientLogic.getClient(dto.getClientId());
        else
            clientSession = client;
        
        dto.setClient(clientSession);
        dto.setAlbum(albumLogic.getAlbum(dto.getAlbumId()));
        
        return questionLogic.createQuestion(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<QuestionDTO> getQuestions() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", questionLogic.countQuestions());
        }
        return questionLogic.getQuestions(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public QuestionDTO getQuestion(@PathParam("id") Long id) {
        return questionLogic.getQuestion(id);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public QuestionDTO updateQuestion(@PathParam("id") Long id, QuestionDTO dto) {
        dto.setId(id);
        return questionLogic.updateQuestion(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteQuestion(@PathParam("id") Long id) {
        questionLogic.deleteQuestion(id);
    }
}