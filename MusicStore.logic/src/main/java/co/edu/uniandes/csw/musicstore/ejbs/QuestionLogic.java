package co.edu.uniandes.csw.musicstore.ejbs;

import co.edu.uniandes.csw.musicstore.api.IQuestionLogic;
import co.edu.uniandes.csw.musicstore.converters.QuestionConverter;
import co.edu.uniandes.csw.musicstore.dtos.QuestionDTO;
import co.edu.uniandes.csw.musicstore.entities.QuestionEntity;
import co.edu.uniandes.csw.musicstore.persistence.QuestionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author je.barrera11
 */
@Stateless
public class QuestionLogic implements IQuestionLogic {

    @Inject
    private QuestionPersistence persistence;

    /**
     *
     * @return
     */
    public int countQuestions() {
        return persistence.count();
    }

    /**
     *
     * @param page
     * @param maxRecords
     * @return
     */
    public List<QuestionDTO> getQuestions(Integer page, Integer maxRecords) {
        return QuestionConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     *
     * @param id
     * @return
     */
    public QuestionDTO getQuestion(Long id) {
        return QuestionConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     *
     * @param dto
     * @return
     */
    public QuestionDTO createQuestion(QuestionDTO dto) {
        QuestionEntity entity = QuestionConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return QuestionConverter.fullEntity2DTO(entity);
    }

    /**
     *
     * @param dto
     * @return
     */
    public QuestionDTO updateQuestion(QuestionDTO dto) {
        QuestionEntity entity = persistence.update(QuestionConverter.fullDTO2Entity(dto));
        return QuestionConverter.fullEntity2DTO(entity);
    }

    /**
     *
     * @param id
     */
    public void deleteQuestion(Long id) {
        persistence.delete(id);
    }

    /**
     *
     * @param name
     * @return
     */
    public List<QuestionDTO> findByName(String name) {
        return QuestionConverter.listEntity2DTO(persistence.findByName(name));
    }
}
