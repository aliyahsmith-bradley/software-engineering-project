package model.entity;
import org.junit.jupiter.api.Test;
import pokersite.model.entity.Issue;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class IssueTest {
    @Test public void testConstructor() {
        Timestamp ts = Timestamp.from(Instant.now());
        Issue issue = new Issue(10, "Problem", "Website doesnt work", ts);
        assertAll(
                ()-> assertEquals(10, issue.getID()),
                ()-> assertEquals("Problem", issue.getTitle()),
                ()-> assertEquals("Website doesnt work", issue.getBody()),
                ()-> assertEquals(ts, issue.getDt_sent())
        );
    }
    @Test public void testSetters() {
        Timestamp ts = Timestamp.from(Instant.now());
        Issue issue = new Issue();

        issue.setId(10);
        issue.setTitle("Problem");
        issue.setBody("Website doesnt work");
        issue.setDt_sent(ts);
        assertAll(
                ()-> assertEquals(10, issue.getID()),
                ()-> assertEquals("Problem", issue.getTitle()),
                ()-> assertEquals("Website doesnt work", issue.getBody()),
                ()-> assertEquals(ts, issue.getDt_sent())
        );
    }
}