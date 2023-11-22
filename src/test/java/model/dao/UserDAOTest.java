package model.dao;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import pokersite.model.dao.GenericDAO;
import pokersite.model.dao.UserDAO;
import pokersite.model.entity.User;
import java.util.LinkedList;
import java.util.List;

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
        User createdUser = dao.create(newuser);
        User found = dao.read(newuser.getID());

        assertAll(
                ()-> assertNotNull(createdUser),
                ()-> assertNotNull(found),
                ()-> assertNotNull(createdUser.getID()),
                ()-> assertNotNull(found.getID())
        );
    }
    @Test public void testCreateUserFail() {
        User newuser = createNewUserEntity();
        User newuser2 = createNewUserEntity();
        newuser2.setID(1);

        dao.create(newuser);
        assertThrows(javax.persistence.PersistenceException.class, ()-> dao.create(newuser2));
    }
    @Test public void testUpdateUser() {
        User newuser = createNewUserEntity();
        dao.create(newuser);
        newuser.setUsername("Super Bob");
        dao.update(newuser);

        assertAll(
                ()-> assertEquals("Super Bob", newuser.getUsername())
        );
    }
    @Test public void testUpdateUserFail() {
        User newuser = createNewUserEntity();
        dao.create(newuser);
        User u = new User();
        assertThrows(javax.persistence.PersistenceException.class, ()-> dao.update(u));
    }
    @Test public void testDeleteUserByID() {
        User newuser = createNewUserEntity();
        dao.create(newuser);
        dao.delete(1);
        User found = dao.read(1);
        assertAll(
                ()-> assertNull(found)
        );
    }
    @Test public void testDeleteUserByUser() {
        User newuser = createNewUserEntity();
        dao.create(newuser);
        dao.delete(newuser);
        User found = dao.read(newuser.getID());

        assertAll(
                ()-> assertNull(found)
        );
    }
    @Test public void smokeTestDeleterUserDNE() {
        User notsaved = createNewUserEntity();
        assertDoesNotThrow(() -> dao.delete(notsaved));
    }
    @Test public void testListUsers() {
        User user1 = createNewUserEntity();
        User user2 = createNewUserEntity();
        User user3 = createNewUserEntity();
        user1.setEmail("Bob@gmail.com");
        user2.setEmail("BobBetter@gmail.com");
        user3.setEmail("BobBest@Gmail.com");
        dao.create(user1);
        dao.create(user2);
        dao.create(user3);
        List<User> users = dao.list("email");

        assertAll(
                ()-> assertEquals(3,users.size()),
                ()-> assertEquals(user1.getEmail(), users.get(0).getEmail()),
                ()-> assertEquals(user2.getEmail(), users.get(2).getEmail()),
                ()-> assertEquals(user3.getEmail(), users.get(1).getEmail())
        );
    }
    @Test public void testReadUser() {
        User newuser = createNewUserEntity();
        dao.create(newuser);
        User found = dao.read(newuser);

        assertAll(
                ()-> assertEquals(newuser.getID(), found.getID())
        );
    }
    @Test public void testFindUserByLogin() {
        User newuser = createNewUserEntity();
        User createdUser = dao.create(newuser);
        String email = createdUser.getEmail();
        User found = dao.findUserByLogin(email);

        assertAll(
                ()-> assertNotNull(found),
                ()-> assertEquals(createdUser.getID(), found.getID())
        );
    }
    @Test public void testFindUserByID() {
        User newuser = createNewUserEntity();
        dao.create(newuser);
        Integer id = newuser.getID();

        User found = dao.findUserByID(id);

        assertAll(
                ()-> assertNotNull(found),
                ()-> assertEquals(id, found.getID())
        );
    }
    @Test public void testSearchForUsersByUserName() {
        User newuser = createNewUserEntity();
        User newuser2 = createNewUserEntity();
        dao.create(newuser);
        dao.create(newuser2);

        List<User> userList = new LinkedList<>();
        userList.add(newuser);
        userList.add(newuser2);
        List<User> usersFound = dao.searchForUsersByUserName("B");

        assertAll(
                ()-> assertNotNull(usersFound),
                ()-> assertEquals(userList.get(0).getID(), usersFound.get(0).getID()),
                ()-> assertEquals(2, usersFound.size())
        );
    }
    @Test public void smokeTestFindUserByLoginDNE() {
        User user = createNewUserEntity();
        assertDoesNotThrow(()-> dao.findUserByLogin(user.getEmail()));
    }
    @Test public void smokeTestFindUserByID() {
        User user = createNewUserEntity();
        assertDoesNotThrow(()-> dao.findUserByID(user.getID()));
    }
    @Test public void smokeTestSearchForUsersByUserName() {
        User user = createNewUserEntity();
        assertDoesNotThrow(()-> dao.searchForUsersByUserName(user.getUsername()));
    }
}