package com.duffiye.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.duffiye.core.common.ProcResult;
import com.duffiye.core.utils.ResponseUtils;


public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	private static final Logger logger = LoggerFactory.getLogger(AccessDeniedHandlerImpl.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
    	logger.info("AccessDeniedHandlerImpl is exce...........");
        ProcResult result = new ProcResult();
        result.setStatusCode(300);
        result.setCallbackType("closeCurrent");
        result.setMessage("请添加以下权限:" + accessDeniedException.getMessage());
        ResponseUtils.write(response, result);
    }

}
