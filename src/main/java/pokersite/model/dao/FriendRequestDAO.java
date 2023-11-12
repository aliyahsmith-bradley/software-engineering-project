package pokersite.model.dao;

import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class FriendRequestDAO extends GenericDAO<Friend_Request> {
    public FriendRequestDAO() {
        super(Friend_Request.class);
    }

    public Friend_Request findFriendRequestByID(Integer ID) {
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

    public Friend_Request findFriendRequestByUserID(Integer ID) {
        EntityManager em = getEntityManager();

        //language=mysql
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.id_user_sender = :ID";
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

    public List<Friend_Request> findFriendRequests(Integer userID) {
        EntityManager em = getEntityManager();

        //language=SQL
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.id_user_receiver = :userID";
        List<Friend_Request> friendRequests = null;

        try {
            friendRequests = em.createQuery(query, Friend_Request.class).setParameter("userID", userID).getResultList();
        } catch(NoResultException e) {
            friendRequests = null;
        } finally {
            em.close();
        }
        return friendRequests;
    }
}