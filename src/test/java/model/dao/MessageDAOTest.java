package model.dao;
import org.junit.jupiter.api.*;
import pokersite.model.dao.GenericDAO;
import pokersite.model.dao.MessageDAO;
import pokersite.model.dao.UserDAO;
import pokersite.model.entity.Message;
import pokersite.model.entity.User;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessageDAOTest {
    public static MessageDAO msdao = null;
    public static UserDAO userdao = null;
    public static Message createNewMessage() {
        Message ms = new Message();
        Timestamp ts = Timestamp.from(Instant.now());
        ms.setId_user_sender(1);
        ms.setId_user_receiver(2);
        ms.setMessage("Hello There");
        ms.setDt_sent(ts);
        return ms;
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
        msdao = new MessageDAO();
        msdao.setDbTypeOutput(GenericDAO.DbType.TEST);

        userdao = new UserDAO();
        userdao.setDbTypeOutput(GenericDAO.DbType.TEST);
    }
    @BeforeEach public void deleteAllBeforeEach() {
        msdao.deleteAll();
        userdao.deleteAll();
    }
    @AfterAll public static void deleteAllAfter() {
        msdao.deleteAll();
        userdao.deleteAll();
    }

    @Test public void testGetMessages() {
        Message m1 = createNewMessage();
        User u1 = createNewUserEntity();
        User u2 = createNewUserEntity();
        userdao.create(u1);
        userdao.create(u2);

        m1.setId_user_sender(u1.getID());
        m1.setId_user_receiver(u2.getID());

        msdao.create(m1);
        List<Message> messages = msdao.getMessages(u2);

        assertAll(
                ()-> assertNotNull(messages),
                ()-> assertEquals(m1.getID(), messages.get(0).getID())
        );
    }
}