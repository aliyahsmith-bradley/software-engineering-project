// SPDX-License-Identifier: MIT
package pokersite.model.dao;

import pokersite.model.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

/***
 * UserDAO is a subclass of GenericDAO
 * It is a good practice to extend GenericDAO for each specific entity
 * Then we can add custom methods for this DAO (mostly, custom list operations)
 */
public class UserDAO extends GenericDAO<User> {

    public UserDAO(){
        super(User.class);
    }

    /***
     * Method used for login, finds the user tied to a specific login
     * @param email The email which is unique in the DB
     * @return User entity
     */
    public User findUserByLogin(String email){
        EntityManager em = getEntityManager();

        String query = "SELECT u FROM "+getTableName()+" u WHERE u.email = :email"; // :email is a parameter, to avoid SQL Injection
        User found = null;

        try {
            found = em.createQuery(query, User.class).setParameter("email", email).getSingleResult();
        } catch(NoResultException ex){
            found = null;
        } finally{
            em.close();
        }
        return found;
    }

    public List<User> findUserByUsername(String username) {
        EntityManager em = getEntityManager();

        //language=SQL
        String query = "SELECT u FROM " + getTableName() + " u WHERE u.username LIKE :username";
        List<User> found = null;

        try {
            found = em.createQuery(query, User.class).setParameter("username", username + "%").getResultList();
        } catch(NoResultException e) {
            found = null;
        } finally {
            em.close();
        }
        return found;
    }

}