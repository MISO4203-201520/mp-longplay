package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.IQuestionLogic;
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

/**
 * @generated
 */
@Path("/questions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionService {

    @Inject private IQuestionLogic questionLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public QuestionDTO createQuestion(QuestionDTO dto) {
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
