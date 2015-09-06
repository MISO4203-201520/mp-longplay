package co.edu.uniandes.csw.musicstore.api;

import co.edu.uniandes.csw.musicstore.dtos.QuestionDTO;
import java.util.List;

public interface IQuestionLogic {
    public int countQuestions();
    public List<QuestionDTO> getQuestions(Integer page, Integer maxRecords);
    public QuestionDTO getQuestion(Long id);
    public QuestionDTO createQuestion(QuestionDTO dto);
    public QuestionDTO updateQuestion(QuestionDTO dto);
    public void deleteQuestion(Long id);
    public List<QuestionDTO> findByName(String name);
}
