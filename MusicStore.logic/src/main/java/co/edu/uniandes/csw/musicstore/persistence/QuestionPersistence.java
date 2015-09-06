package co.edu.uniandes.csw.musicstore.persistence;

import co.edu.uniandes.csw.musicstore.entities.QuestionEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class QuestionPersistence extends CrudPersistence<QuestionEntity> {

    /**
     * @generated
     */
    public QuestionPersistence() {
        this.entityClass = QuestionEntity.class;
    }
}
