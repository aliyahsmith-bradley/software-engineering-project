package pokersite.model.dao;

import pokersite.model.entity.BadWord;

import javax.persistence.EntityManager;
import java.util.List;

public class BadWordDAO extends GenericDAO<BadWord> {
    public BadWordDAO() {
        super(BadWord.class);
    }
    public List<BadWord> getBadWords() {
        EntityManager em = getEntityManager();

        //language=SQL
        String query = "SELECT u FROM " + getTableName() + " u";
        List<BadWord> badWords = null;

        // removed try and catch here
        badWords = em.createQuery(query, BadWord.class).getResultList();
        em.close();

        return badWords;

    }
}
