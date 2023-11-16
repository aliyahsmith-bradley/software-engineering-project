package model.dao;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import pokersite.model.dao.FriendRequestDAO;
import pokersite.model.dao.GenericDAO;
import pokersite.model.dao.UserDAO;
import pokersite.model.entity.Friend_Request;
import pokersite.model.entity.User;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;


public class FriendRequestDAOTest {
    public static FriendRequestDAO frdao = null;
    public static UserDAO userDAO = null;
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
    }
    @BeforeEach public void deleteAllBeforeEach() {
        frdao.deleteAll();

        userDAO.deleteAll();
    }
    @AfterAll public static void deleteAllAfter() {
        frdao.deleteAll();

        userDAO.deleteAll();
    }
    @Test public void testFindFriendRequestByFrID() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);

        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());

        frdao.create(newfr);

        Friend_Request foundfr = frdao.findFriendRequestByFrID(newfr.getID());
        assertAll(
                ()-> assertNotNull(foundfr),
                ()-> assertEquals(newfr.getID(), foundfr.getID())
        );
    }
    @Test public void smokeTestFindFriendRequestByFrID() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);

        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());
        assertDoesNotThrow(()-> frdao.findFriendRequestByFrID(newfr.getID()));
    }
    @Test public void testFindFrByUserIdSenderAndUserIdReceiver() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);

        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());
        frdao.create(newfr);

        Friend_Request foundfr = frdao.findFrByUserIDSenderAndUserIDReceiver(user1.getID(), user2.getID());

        assertAll(
                ()-> assertNotNull(foundfr),
                ()-> assertEquals(newfr.getID(), foundfr.getID())
        );
    }
    @Test public void smokeTestFrByUserIDSenderAndUserIDReceiver() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);

        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());
        assertDoesNotThrow(()-> frdao.findFrByUserIDSenderAndUserIDReceiver(user1.getID(), user2.getID()));
    }
    @Test public void testFindFriendRequestsByUserID() {
        Friend_Request newfr = createNewFriendRequest();
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        userDAO.create(user1);
        userDAO.create(user2);

        newfr.setId_user_sender(user1.getID());
        newfr.setId_user_receiver(user2.getID());
        frdao.create(newfr);

        List<Friend_Request> foundfrs = frdao.findFriendRequestsByUserID(user2.getID());

        assertAll(
                ()-> assertNotNull(foundfrs),
                ()-> assertEquals(newfr.getID(), foundfrs.get(0).getID())
        );
    }
}