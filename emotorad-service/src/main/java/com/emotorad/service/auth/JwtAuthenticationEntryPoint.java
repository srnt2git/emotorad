package com.emotorad.service.auth;
import com.emotorad.service.exception.CustomErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        // Handle unauthorized access (e.g., send a 401 Unauthorized response)
        authException.printStackTrace();
        CustomErrorResponse customErrorResponse=new CustomErrorResponse();
        customErrorResponse.setMessage("Unauthorized");
        response.getWriter().write(objectMapper.writeValueAsString(customErrorResponse));
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        response.getWriter().flush();
    }
}
