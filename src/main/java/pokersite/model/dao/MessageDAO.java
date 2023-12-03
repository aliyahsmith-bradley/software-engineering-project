package pokersite.model.dao;

import pokersite.model.entity.Message;
import pokersite.model.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class MessageDAO extends GenericDAO<Message> {
    public MessageDAO() {
        super(Message.class);
    }
    public List<Message> getMessages(User user) {
        EntityManager em = getEntityManager();

        //language=sql
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.id_user_receiver = :userID";
        List<Message> messages;

        messages = em.createQuery(query, Message.class).setParameter("userID", user.getID()).getResultList();
        em.close();

        return messages;
    }
}
