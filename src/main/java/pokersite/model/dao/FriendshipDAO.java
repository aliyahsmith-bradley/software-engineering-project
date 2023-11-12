package pokersite.model.dao;

import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.Friendship;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class FriendshipDAO extends GenericDAO<Friendship> {
    public FriendshipDAO() {
        super(Friendship.class);
    }

    public List<Friendship> findFriendsByUserID(Integer userID) {
        EntityManager em = getEntityManager();

        //language=SQL
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.id_user2 = :userID";
        List<Friendship> friends = null;

        try {
            friends = em.createQuery(query, Friendship.class).setParameter("userID", userID).getResultList();
        } catch(NoResultException e) {
            friends = null;
        } finally {
            em.close();
        }
        return friends;
    }

    public Friendship findFriendByFriendshipID(Integer ID) {
        EntityManager em = getEntityManager();

        //language=SQL
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.ID = :fsID";
        Friendship friend = null;

        try {
            friend = em.createQuery(query, Friendship.class).setParameter("fsID", ID).getSingleResult();
        } catch(NoResultException e) {
            friend = null;
        } finally {
            em.close();
        }
        return friend;
    }
}