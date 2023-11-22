package pokersite.model.dao;

import pokersite.model.entity.Friend_Request;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class FriendRequestDAO extends GenericDAO<Friend_Request> {
    public FriendRequestDAO() {
        super(Friend_Request.class);
    }

    public Friend_Request findFriendRequestByFrID(Integer ID) {
        EntityManager em = getEntityManager();

        //language=mysql
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.ID = :ID";
        Friend_Request found = null;

        try {
            found = em.createQuery(query, Friend_Request.class).setParameter("ID", ID).getSingleResult();
        } catch (NoResultException ex) {
            found = null;
        } finally {
            em.close();
        }
        return found;
    }

    public Friend_Request findFrByUserIDSenderAndUserIDReceiver(Integer IDSender, Integer IDReceiver) {
        EntityManager em = getEntityManager();

        //language=mysql
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.id_user_sender = :IDSender AND u.id_user_receiver = :IDReceiver";
        Friend_Request found = null;

        try {
            found = em.createQuery(query, Friend_Request.class).setParameter("IDSender", IDSender).setParameter("IDReceiver", IDReceiver).getSingleResult();
        } catch (NoResultException ex) {
            found = null;
        } finally {
            em.close();
        }
        return found;
    }

    public List<Friend_Request> findFriendRequestsByUserID(Integer userID) {
        EntityManager em = getEntityManager();

        //language=SQL
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.id_user_receiver = :userID";
        List<Friend_Request> friendRequests = null;

        // removed try and catch here
        friendRequests = em.createQuery(query, Friend_Request.class).setParameter("userID", userID).getResultList();
        em.close();

        return friendRequests;
    }
}