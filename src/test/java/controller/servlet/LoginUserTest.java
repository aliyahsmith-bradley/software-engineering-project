package controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import pokersite.controller.service.UserService;
import pokersite.controller.servlet.LoginUser;
import pokersite.model.entity.User;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

public class LoginUserTest {

//    @Test public void testDoPostSuccessfulLogin() throws IOException, ServletException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        HttpSession sessionMock = mock(HttpSession.class);
//
//        when(request.getParameter("email")).thenReturn("test@gmail.com");
//        when(request.getParameter("password")).thenReturn("123");
//        when(request.getSession()).thenReturn(sessionMock);
//
//        User logged = new User(1, "bob", "bob", "bob@gmail.com", "bob", "bob", "1111111111");
//
//        try(MockedStatic<UserService> service = mockStatic(UserService.class)) {
//            service.when(()-> UserService.loginUser(anyString(), anyString())).thenReturn(logged);
//
//            LoginUser servlet = new LoginUser();
//            servlet.doPost(request,response);
//
//            assertAll(
//                    ()->
//            );
//        }
//    }
}
