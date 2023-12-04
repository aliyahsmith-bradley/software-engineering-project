package model.entity;

import org.junit.jupiter.api.Test;
import pokersite.model.entity.Message;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.Instant;

public class MessageTest {
    @Test public void testConstructor() {
        Timestamp ts = Timestamp.from(Instant.now());
        Message ms = new Message(10, 1, 2, "Hello There", ts);
        assertAll(
                ()-> assertEquals(10, ms.getID()),
                ()-> assertEquals(1, ms.getId_user_sender()),
                ()-> assertEquals(2, ms.getId_user_receiver()),
                ()-> assertEquals("Hello There", ms.getMessage()),
                ()-> assertEquals(ts, ms.getDt_sent())
        );
    }
    @Test public void testSetter() {
        Message ms = new Message();
        Timestamp ts = Timestamp.from(Instant.now());

        ms.setID(10);
        ms.setId_user_sender(1);
        ms.setId_user_receiver(2);
        ms.setMessage("Hello There");
        ms.setDt_sent(ts);
        assertAll(
                ()-> assertEquals(10, ms.getID()),
                ()-> assertEquals(1, ms.getId_user_sender()),
                ()-> assertEquals(2, ms.getId_user_receiver()),
                ()-> assertEquals("Hello There", ms.getMessage()),
                ()-> assertEquals(ts, ms.getDt_sent())
        );
    }
}
