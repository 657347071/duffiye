package com.duffiye.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.duffiye.core.common.ProcResult;
import com.duffiye.core.utils.ResponseUtils;



public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginUrlEntryPoint.class);

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
    	logger.info("LoginUrlEntryPoint is exec..........");
        String url = request.getRequestURI();
        final String contextPath = request.getContextPath();
        System.out.println(url + " " + contextPath);
        if (url.startsWith(contextPath + "/index")) {
            response.sendRedirect(contextPath + "/login");
            return;
        }
        ProcResult result = new ProcResult();
        result.setMessage(authException.getMessage());
        result.setStatusCode(301);
        ResponseUtils.write(response, result);
    }

}
