package model.dao;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import pokersite.model.dao.GenericDAO;
import pokersite.model.dao.UserDAO;
import pokersite.model.entity.User;


public class UserDAOTest {
    public static UserDAO dao = null;

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
        dao = new UserDAO();
        dao.setDbTypeOutput(GenericDAO.DbType.TEST);
    }

    @BeforeEach public void deleteAllBeforeEach() {
        dao.deleteAll();
    }

    @AfterAll public static void deleteAllAfter() {
        dao.deleteAll();
    }

    @Test public void testCreateUser() {
        User newuser = createNewUserEntity();

        dao.create(newuser);
        User found = dao.read(newuser.getID());
        assertAll("Grouped Assertions of Create User",
                () -> assertNotNull(newuser.getID(), "ID should not be null after creation"),
                () -> assertNotNull(found, "Found user after reading should not be null")
        );
    }
}
