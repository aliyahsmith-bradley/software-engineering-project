package model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import pokersite.model.entity.User;

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
        User u = new User(10, "Bill", "billthebest", "bill@gmail.com", "bill", "guy", "8564738561", 0);
        assertAll(
                ()-> assertEquals(10, u.getID()),
                ()-> assertEquals("Bill", u.getUsername()),
                ()-> assertEquals("billthebest", u.getPassword()),
                ()-> assertEquals("bill@gmail.com", u.getEmail()),
                ()-> assertEquals("bill", u.getFirst_name()),
                ()-> assertEquals("guy", u.getLast_name()),
                ()-> assertEquals("8564738561", u.getPhone_number())
        );
    }
    @Test public void testSetters() {
        User u = new User();
        u.setID(10);
        u.setUsername("Bill");
        u.setPassword("billthebest");
        u.setEmail("bill@gmail.com");
        u.setFirst_name("bill");
        u.setLast_name("guy");
        u.setPhone_number("8564738561");

        assertAll(
                ()-> assertEquals(10, u.getID()),
                ()-> assertEquals("Bill", u.getUsername()),
                ()-> assertEquals("billthebest", u.getPassword()),
                ()-> assertEquals("bill@gmail.com", u.getEmail()),
                ()-> assertEquals("bill", u.getFirst_name()),
                ()-> assertEquals("guy", u.getLast_name()),
                ()-> assertEquals("8564738561", u.getPhone_number())
        );
    }
}