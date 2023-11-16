package model.dao;

import org.junit.jupiter.api.*;
import pokersite.model.dao.FriendRequestDAO;
import pokersite.model.dao.FriendshipDAO;
import pokersite.model.dao.GenericDAO;
import pokersite.model.dao.UserDAO;
import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.Friendship;
import pokersite.model.entity.User;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FriendshipDAOTest {
    public static FriendshipDAO fsdao = null;
    public static FriendRequestDAO frdao= null;
    public static UserDAO userDAO = null;
    public static Friendship createFriendship() {
        Friendship fs = new Friendship();
        Timestamp ts = Timestamp.from(Instant.now());
        fs.setId_user1(1);
        fs.setId_user2(2);
        fs.setDt_accepted(ts);
        return fs;
    }
    public static Friend_Request createNewFriendRequest() {
        Friend_Request fr = new Friend_Request();
        Timestamp ts = Timestamp.from(Instant.now());
        fr.setId_user_sender(1);
        fr.setId_user_receiver(2);
        fr.setStatus((byte) 0);
        fr.setDt_sent(ts);
        return fr;
    }
    public static User createNewUserEntity() {
        User u = new User();
        u.setPassword("123");
        u.setUsername("Bob The Builder");
        u.setEmail("bobbuilder@gmail.com");
        u.setFirst_name("Bob");
        u.setLast_name("Builder");
        u.setPhone_number("3241647385");
        return u;
    }
    @BeforeAll public static void createDAO() {
        frdao = new FriendRequestDAO();
        frdao.setDbTypeOutput(GenericDAO.DbType.TEST);
        userDAO = new UserDAO();
        userDAO.setDbTypeOutput(GenericDAO.DbType.TEST);
        fsdao = new FriendshipDAO();
        fsdao.setDbTypeOutput(GenericDAO.DbType.TEST);
    }
    @BeforeEach public void deleteAllBeforeEach() {
        fsdao.deleteAll();
        frdao.deleteAll();
        userDAO.deleteAll();
    }
    @AfterAll public static void deleteAllAfter() {
        fsdao.deleteAll();
        frdao.deleteAll();
        userDAO.deleteAll();
    }
    @Test public void testFindFriendsByUserID() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);
        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());
        frdao.create(newfr);

        Friendship newfs = createFriendship();
        newfs.setId_user1(user1.getID());
        newfs.setId_user2(user2.getID());

        Friendship fs = fsdao.create(newfs);
        List<Friendship> foundFriends = fsdao.findFriendsByUserID(user2.getID());

        assertAll(
                ()-> assertNotNull(fs),
                ()-> assertEquals(fs.getID(), foundFriends.get(0).getID())
        );
    }
    @Test public void testFindFriendByFriendshipID() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);
        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());
        frdao.create(newfr);

        Friendship newfs = createFriendship();
        newfs.setId_user1(user1.getID());
        newfs.setId_user2(user2.getID());

        Friendship fs = fsdao.create(newfs);
        Friendship found = fsdao.findFriendByFriendshipID(fs.getID());
        assertAll(
                ()-> assertEquals(fs.getID(), found.getID())
        );
    }
    @Test public void smokeTestFindFriendByFriendshipID() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);
        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());
        frdao.create(newfr);

        Friendship newfs = createFriendship();
        newfs.setId_user1(user1.getID());
        newfs.setId_user2(user2.getID());
        assertDoesNotThrow(()-> fsdao.findFriendByFriendshipID(newfs.getID()));

    }
}