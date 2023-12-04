package controller.service;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import pokersite.controller.service.UserService;
import pokersite.model.dao.*;
import pokersite.model.entity.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    @Test public void testRegisterUser() {
        User registered = new User(50, "Bob The Builder", "123", "bobbuilder@gmail.com", "Bob", "Builder", "505050505");
        User newuser = new User(null, "testman", "123", "test@test.com", "test", "man", "123123123");

        UserDAO mockDAO = mock(UserDAO.class);
        when(mockDAO.create(any(User.class))).thenReturn(registered);
        UserService.setDAO(mockDAO);

        User returned = UserService.registerUser(newuser);

        assertAll(
                ()-> assertEquals(returned.getID(), registered.getID())
        );
    }

    @Test public void testLoginUser() {
        User user = new User(50, "Bob The Builder", "123", "bobbuilder@gmail.com", "Bob", "Builder", "505050505");

        UserDAO mockDAO = mock(UserDAO.class);

        when(mockDAO.findUserByLogin(anyString())).thenReturn(user);
        UserService.setDAO(mockDAO);

        User logged = UserService.loginUser("bobuilder@gmail.com", "123");

        assertAll(
                ()-> assertNotNull(logged),
                ()-> assertEquals(user.getID(), logged.getID())
        );
    }

    @Test public void testFindByUserName() {
        List<User> userToFind = new ArrayList<>();
        userToFind.add(new User(50, "Bob The Builder", "123", "bobbuilder@gmail.com", "Bob", "Builder", "505050505"));

        UserDAO mockDAO = mock(UserDAO.class);

        when(mockDAO.searchForUsersByUserName(anyString())).thenReturn(userToFind);
        UserService.setDAO(mockDAO);

        List<User> findUserByUsername = UserService.searchForUsersByUserName("Bob The Builder");

        assertAll(
                ()-> assertNotNull(findUserByUsername),
                ()-> assertEquals(userToFind.get(0), findUserByUsername.get(0))
        );
    }

    @Test public void testFindByID() {
        User userToFind = new User(50, "Bob The Builder", "123", "bobbuilder@gmail.com", "Bob", "Builder", "505050505");

        UserDAO mockDAO = mock(UserDAO.class);

        when(mockDAO.findUserByID(anyInt())).thenReturn(userToFind);
        UserService.setDAO(mockDAO);

        User findByUserID = UserService.findUserByUserID(50);

        assertAll(
                ()-> assertNotNull(findByUserID),
                ()-> assertEquals(userToFind.getID(), findByUserID.getID())
        );
    }

    @Test public void testFindFriendRequests() {
        Timestamp ts = Timestamp.from(Instant.now());

        User findUsersFrs = new User(50, "Bob The Builder", "123", "bobbuilder@gmail.com", "Bob", "Builder", "505050505");

        List<Friend_Request> frToFind = new ArrayList<>();
        frToFind.add(new Friend_Request(10, 1, 50, (byte) 0, ts));

        FriendRequestDAO mockDAO = mock(FriendRequestDAO.class);

        when(mockDAO.findFriendRequestsByUserID(anyInt())).thenReturn(frToFind);
        UserService.setDAO(mockDAO);

        List<Friend_Request> findFriendRequests = UserService.findFriendRequestsByUser(findUsersFrs);

        assertAll(
                ()-> assertNotNull(findFriendRequests),
                ()-> assertEquals(frToFind.get(0).getID(), findFriendRequests.get(0).getID())
        );
    }

    @Test public void testFindFriendRequestByID() {
        Timestamp ts = Timestamp.from(Instant.now());

        User findUsersFrs = new User(50, "Bob The Builder", "123", "bobbuilder@gmail.com", "Bob", "Builder", "505050505");
        Friend_Request fr = new Friend_Request(10, 1, 50, (byte) 0, ts);

        FriendRequestDAO mockDAO = mock(FriendRequestDAO.class);

        when(mockDAO.findFriendRequestByFrID(anyInt())).thenReturn(fr);
        UserService.setDAO(mockDAO);

        Friend_Request findFriendRequest = UserService.findFriendRequestByFrID(fr.getID());

        assertAll(
                ()-> assertNotNull(findFriendRequest),
                ()-> assertEquals(fr, findFriendRequest)
        );
    }

    @Test public void testFindFrByUserIDSenderAndUserIDReceiver() {
        Timestamp ts = Timestamp.from(Instant.now());

        Friend_Request fr = new Friend_Request(10, 1, 50, (byte) 0, ts);
        User findUserfr = new User(50, "Bob The Builder", "123", "bobbuilder@gmail.com", "Bob", "Builder", "505050505");

        FriendRequestDAO mockDAO = mock(FriendRequestDAO.class);

        when(mockDAO.findFrByUserIDSenderAndUserIDReceiver(anyInt(), anyInt())).thenReturn(fr);
        UserService.setDAO(mockDAO);

        Friend_Request findFriendRequest = UserService.findFrByUserIDSenderAndUserIDReceiver(1,findUserfr.getID());

        assertAll(
                ()-> assertNotNull(findFriendRequest),
                ()-> assertEquals(fr, findFriendRequest)
        );
    }

    @Test public void testSendFriendRequest() {
        Timestamp ts = Timestamp.from(Instant.now());

        Friend_Request fr = new Friend_Request(10, 1, 50, (byte) 0, ts);

        FriendRequestDAO mockDAO = mock(FriendRequestDAO.class);

        when(mockDAO.create(any())).thenReturn(fr);
        UserService.setDAO(mockDAO);

        Friend_Request createdfr = UserService.sendFriendRequest(fr);

        assertAll(
                ()-> assertNotNull(createdfr),
                ()-> assertEquals(fr.getID(), createdfr.getID())
        );
    }

    @Test public void testAcceptFriendRequest() {
        User user1 = new User(1, "bob", "bob", "bob@gmail.com", "bob", "bob", "1111111111");
        User user2 = new User(2,"bill","bill","bill@gmail.com","bill","bill","2222222222");

        Timestamp ts = Timestamp.from(Instant.now());
        Friend_Request fr = new Friend_Request(1, 1, 2, (byte) 0, ts);
        Friendship fs = new Friendship(1, 1, 2, ts);

        UserDAO userMockDAO = mock(UserDAO.class);
        FriendRequestDAO frMockDAO = mock(FriendRequestDAO.class);
        FriendshipDAO fsMockDAO = mock(FriendshipDAO.class);

        UserService.setDAO(userMockDAO);
        UserService.registerUser(user1);
        UserService.registerUser(user2);

        UserService.setDAO(frMockDAO);
        UserService.sendFriendRequest(fr);

        when(fsMockDAO.create(fs)).thenReturn(fs);
        UserService.setDAO(fsMockDAO);

        Friendship newfs = UserService.acceptFriendRequest(fs, fr);

        assertAll(
                ()-> assertNotNull(newfs),
                ()-> assertEquals(fs, newfs)
        );
    }

    @Test public void testFindFriendsByUser() {
        User user1 = new User(1, "bob", "bob", "bob@gmail.com", "bob", "bob", "1111111111");
        User user2 = new User(2,"bill","bill","bill@gmail.com","bill","bill","2222222222");

        Timestamp ts = Timestamp.from(Instant.now());
        Friend_Request fr = new Friend_Request(1, user1.getID(), user2.getID(), (byte) 0, ts);
        Friendship fs = new Friendship(1, user1.getID(), user2.getID(), ts);

        UserDAO userMockDAO = mock(UserDAO.class);
        FriendRequestDAO frMockDAO = mock(FriendRequestDAO.class);
        FriendshipDAO fsMockDAO = mock(FriendshipDAO.class);

        UserService.setDAO(userMockDAO);
        UserService.registerUser(user1);
        UserService.registerUser(user2);

        UserService.setDAO(frMockDAO);
        UserService.sendFriendRequest(fr);

        List<Friendship> friends = new ArrayList<>();
        friends.add(fs);

        when(fsMockDAO.findFriendsByUserID(anyInt())).thenReturn(friends);
        UserService.setDAO(fsMockDAO);

        List<Friendship> foundFriends = UserService.findFriendsByUser(user1);

        assertAll(
                ()-> assertEquals(fs.getID(), foundFriends.get(0).getID())
        );
    }

    @Test public void testFindFriendByFriendshipID() {
        User user1 = new User(1, "bob", "bob", "bob@gmail.com", "bob", "bob", "1111111111");
        User user2 = new User(2,"bill","bill","bill@gmail.com","bill","bill","2222222222");

        Timestamp ts = Timestamp.from(Instant.now());
        Friend_Request fr = new Friend_Request(1, 1, 2, (byte) 0, ts);
        Friendship fs = new Friendship(1, 1, 2, ts);

        UserDAO userMockDAO = mock(UserDAO.class);
        FriendRequestDAO frMockDAO = mock(FriendRequestDAO.class);
        FriendshipDAO fsMockDAO = mock(FriendshipDAO.class);

        UserService.setDAO(userMockDAO);
        UserService.registerUser(user1);
        UserService.registerUser(user2);

        UserService.setDAO(frMockDAO);
        UserService.sendFriendRequest(fr);

        when(fsMockDAO.findFriendByFriendshipID(anyInt())).thenReturn(fs);
        UserService.setDAO(fsMockDAO);

        Friendship newfs = UserService.findFriendByFriendshipID(fs.getID());

        assertAll(
                ()-> assertNotNull(newfs),
                ()-> assertEquals(fs, newfs)
        );
    }

    @Test public void testRemoveFriend() {
        User user1 = new User(1, "bob", "bob", "bob@gmail.com", "bob", "bob", "1111111111");
        User user2 = new User(2,"bill","bill","bill@gmail.com","bill","bill","2222222222");

        Timestamp ts = Timestamp.from(Instant.now());
        Friend_Request fr = new Friend_Request(1, user1.getID(), user2.getID(), (byte) 0, ts);
        Friendship fs = new Friendship(1, user1.getID(), user2.getID(), ts);

        UserDAO userMockDAO = mock(UserDAO.class);
        FriendRequestDAO frMockDAO = mock(FriendRequestDAO.class);
        FriendshipDAO fsMockDAO = mock(FriendshipDAO.class);

        UserService.setDAO(userMockDAO);
        UserService.registerUser(user1);
        UserService.registerUser(user2);

        UserService.setDAO(frMockDAO);
        UserService.sendFriendRequest(fr);

        UserService.setDAO(fsMockDAO);
        UserService.acceptFriendRequest(fs, fr);

        UserService.removeFriend(fs,fr);

        Friendship foundFriendship = UserService.findFriendByFriendshipID(fs.getID());

        assertAll(
                ()-> assertNull(foundFriendship)
        );
    }
    @Test public void testSubmitIssue() {
        Timestamp ts = Timestamp.from(Instant.now());
        Issue issue = new Issue(1, "Problem", "Website doesnt work", ts);
        Issue newissue = new Issue(null, "Problem", "Website doesnt work", ts);

        IssueDAO issueMockDAO = mock(IssueDAO.class);
        when(issueMockDAO.create(any(Issue.class))).thenReturn(issue);
        UserService.setDAO(issueMockDAO);

        Issue createdIssue = UserService.submitIssue(newissue);

        assertAll(
                ()-> assertNotNull(createdIssue)
        );
    }

    @Test public void testSendMessage() {
        Timestamp ts = Timestamp.from(Instant.now());
        Message message = new Message(1, 1, 2, "Hello There", ts);
        Message newMessage = new Message(null, 1, 2, "Hello There", ts);

        MessageDAO messageDAO = mock(MessageDAO.class);
        when(messageDAO.create(any(Message.class))).thenReturn(message);
        Message createdMessage = UserService.sendMessage(newMessage);


        assertAll(
                ()-> assertNotNull(createdMessage)
        );
    }

    @Test public void testGetMessage() {
        Timestamp ts = Timestamp.from(Instant.now());
        User user1 = new User(1, "bob", "bob", "bob@gmail.com", "bob", "bob", "1111111111");
        User user2 = new User(2,"bill","bill","bill@gmail.com","bill","bill","2222222222");

        Message message = new Message(1, 1, 2, "Hello There", ts);

        UserDAO userDAO = mock(UserDAO.class);
        MessageDAO messageDAO = mock(MessageDAO.class);

        UserService.setDAO(userDAO);
        UserService.registerUser(user1);
        UserService.registerUser(user2);

        UserService.setDAO(messageDAO);
        UserService.sendMessage(message);
        UserService.getMessages(user2);

        List<Message> messages = new ArrayList<>();
        messages.add(message);
        when(messageDAO.getMessages(any(User.class))).thenReturn(messages);

        List<Message> foundMessages = UserService.getMessages(user2);

        assertAll(
                ()-> assertNotNull(foundMessages),
                ()-> assertEquals(message.getID(), foundMessages.get(0).getID())
        );
    }
}