package model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pokersite.model.entity.Friend_Request;
import java.sql.Timestamp;
import java.time.Instant;


public class Friend_RequestTest {
    @Test public void testEmptyFriend_Request() {
        Friend_Request fr = new Friend_Request();
        assertAll(
                ()-> assertNull(fr.getID()),
                ()-> assertNull(fr.getId_user_sender()),
                ()-> assertNull(fr.getId_user_receiver()),
                ()-> assertEquals(fr.getStatus(), 0),
                ()-> assertNull(fr.getDt_sent())
        );
    }

    @Test public void testConstructor() {
        Timestamp ts = Timestamp.from(Instant.now());
        Friend_Request fr = new Friend_Request(10, 1, 2, (byte) 0, ts);
        assertAll(
                ()-> assertEquals(10, fr.getID()),
                ()-> assertEquals(1, fr.getId_user_sender()),
                ()-> assertEquals(2, fr.getId_user_receiver()),
                ()-> assertEquals(0, fr.getStatus()),
                ()-> assertEquals(ts, fr.getDt_sent())
        );
    }

    @Test public void testSetters() {
        Friend_Request fr = new Friend_Request();
        Timestamp ts = Timestamp.from(Instant.now());

        fr.setID(10);
        fr.setId_user_sender(1);
        fr.setId_user_receiver(2);
        fr.setStatus((byte)0);
        fr.setDt_sent(ts);
        assertAll(
                ()-> assertEquals(10, fr.getID()),
                ()-> assertEquals(1, fr.getId_user_sender()),
                ()-> assertEquals(2, fr.getId_user_receiver()),
                ()-> assertEquals(0, fr.getStatus()),
                ()-> assertEquals(ts, fr.getDt_sent())
        );
    }
}
