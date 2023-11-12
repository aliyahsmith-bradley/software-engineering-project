package model.entity;

import org.junit.jupiter.api.Test;
import pokersite.model.entity.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test public void testEmptyUser(){
        User u = new User();
        assertAll(
                ()-> assertNull(u.getID()),
                ()-> assertNull(u.getUsername()),
                ()-> assertNull(u.getPassword()),
                ()-> assertNull(u.getFirst_name()),
                ()-> assertNull(u.getLast_name()),
                ()-> assertNull(u.getPhone_number())
        );
    }

    @Test public void testConstructor() {
        User u = new User(10, "Bill", "billthebest", "bill@gmail.com", "bill", "guy", "8564738561");
        assertAll(
                ()-> assertEquals(u.getID(), 10),
                ()-> assertEquals(u.getUsername(), "Bill"),
                ()-> assertEquals(u.getPassword(), "billthebest"),
                ()-> assertEquals(u.getEmail(), "bill@gmail.com"),
                ()-> assertEquals(u.getFirst_name(), "bill"),
                ()-> assertEquals(u.getLast_name(), "guy"),
                ()-> assertEquals(u.getPhone_number(), "8564738561")
        );
    }
}