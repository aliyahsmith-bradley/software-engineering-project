package controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import pokersite.controller.service.UserService;
import pokersite.controller.servlet.RegisterUser;
import pokersite.model.entity.User;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterUserTest {
    @Test public void testDoPostSuccessfulRegister() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        when(request.getParameter("username")).thenReturn("testusername");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("email")).thenReturn("testemail@gmail.com");
        when(request.getParameter("first_name")).thenReturn("testFirstName");
        when(request.getParameter("last_lane")).thenReturn("testLastName");
        when(request.getParameter("phone_number")).thenReturn("1234567891");
        when(request.getSession()).thenReturn(sessionMock);

        try(MockedStatic<UserService> service = mockStatic(UserService.class)) {
            service.when(()-> UserService.registerUser(any()) ).thenReturn(new User());

            RegisterUser servlet = new RegisterUser();
            servlet.doPost(request,response);

            assertAll("Register User Successfully assertions",
                    ()-> assertDoesNotThrow(
                            () -> verify(response).sendRedirect("index.jsp")
                    )
            );
        }
    }
}