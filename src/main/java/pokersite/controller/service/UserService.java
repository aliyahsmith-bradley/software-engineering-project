package pokersite.controller.service;

import pokersite.model.dao.FriendRequestDAO;
import pokersite.model.dao.FriendshipDAO;
import pokersite.model.dao.UserDAO;
import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.Friendship;
import pokersite.model.entity.User;
import pokersite.util.PasswordUtil;

import java.util.List;

public class UserService {
    public static UserDAO dao = new UserDAO();
    public static FriendRequestDAO frdao = new FriendRequestDAO();
    public static FriendshipDAO fsdao = new FriendshipDAO();

    public static void setDAO(UserDAO dao){
        UserService.dao = dao;
    }

    public static void setDAO(FriendRequestDAO frdao) {
        UserService.frdao = frdao;
    }

    public static void setDAO(FriendshipDAO fsdao) {
        UserService.fsdao = fsdao;
    }

    /***
     * Registers new user in the DB by calling the DAO.
     * Although you could put this method inside the Servlet,
     *  by separating into another class, it is easier to test and mock
     * @param newUser User entity to save (without ID)
     * @return Saved User Entity (with ID) or null if Login already exists
     */
    public static User registerUser(User newUser) {
        try {
            String hashed = PasswordUtil.hash(newUser.getPassword());
            newUser.setPassword(hashed);
            newUser = dao.create(newUser);
        } catch (javax.persistence.PersistenceException ex) {
            //Repeated login
            newUser = null;
            System.out.println(ex);
        }
        finally {
            return newUser;
        }
    }

    public static User loginUser(String email, String unhashedPassword) {
        User found = dao.findUserByLogin(email);
        if(found!=null){
            if(PasswordUtil.compare(unhashedPassword,found.getPassword())){
                return found;
            }
        }
        return found;
    }

    public static List<User> searchForUsersByUserName(String username) {
        List<User> Users = dao.searchForUsersByUserName(username);
        return Users;
    }

    public static User findUserByUserID(Integer ID) {
        return dao.findUserByID(ID);
    }


    // Friendship request services
    public static List<Friend_Request> findFriendRequestsByUser(User user) {
        List friendRequests = frdao.findFriendRequestsByUserID(user.getID());
        return friendRequests;
    }
    public static Friend_Request findFrByUserIDSenderAndUserIDReceiver(Integer IDSender, Integer IDReceiver) {
        return frdao.findFrByUserIDSenderAndUserIDReceiver(IDSender, IDReceiver);
    }

    public static Friend_Request findFriendRequestByFrID(Integer ID) {
        return frdao.findFriendRequestByFrID(ID);
    }

    public static Friend_Request sendFriendRequest(Friend_Request fr) {
        Friend_Request newfr = frdao.create(fr);
        return newfr;
    }

    // Friendship services
    public static Friendship acceptFriendRequest(Friendship fs, Friend_Request fr) {
        Friendship newfs = fsdao.create(fs);
        frdao.update(fr);
        return newfs;
    }

    public static List<Friendship> findFriendsByUser(User user) {
        List friends = fsdao.findFriendsByUserID(user.getID());
        return friends;
    }

    public static Friendship findFriendByFriendshipID(Integer ID) {
        return fsdao.findFriendByFriendshipID(ID);
    }

    public static void removeFriend(Friendship fs, Friend_Request fr) {
        fsdao.delete(fs);
        frdao.update(fr);
        frdao.delete(fr);
    }
}