package model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pokersite.model.entity.Friendship;
import java.sql.Timestamp;
import java.time.Instant;

public class FriendshipTest {
    @Test public void testEmptyFriendship() {
        Friendship fs = new Friendship();
        assertAll(
                ()-> assertNull(fs.getID()),
                ()-> assertNull(fs.getId_user1()),
                ()-> assertNull(fs.getId_user2()),
                ()-> assertNull(fs.getDt_accepted())
        );
    }
    @Test public void testConstructor() {
        Timestamp ts = Timestamp.from(Instant.now());
        Friendship fs = new Friendship(10, 1, 2, ts);
        assertAll(
                ()-> assertEquals(10, fs.getID()),
                ()-> assertEquals(1, fs.getId_user1()),
                ()-> assertEquals(2, fs.getId_user2()),
                ()-> assertEquals(ts, fs.getDt_accepted())
        );
    }
    @Test public void testSetters() {
        Timestamp ts = Timestamp.from(Instant.now());
        Friendship fs = new Friendship();
        fs.setID(10);
        fs.setId_user1(1);
        fs.setId_user2(2);
        fs.setDt_accepted(ts);
        assertAll(
                ()-> assertEquals(10, fs.getID()),
                ()-> assertEquals(1, fs.getId_user1()),
                ()-> assertEquals(2, fs.getId_user2()),
                ()-> assertEquals(ts, fs.getDt_accepted())
        );
    }
}