package pokersite.model.dao;

import pokersite.model.entity.Friend_Request;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class FriendRequestDAO extends GenericDAO<Friend_Request> {
    public FriendRequestDAO() {
        super(Friend_Request.class);
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