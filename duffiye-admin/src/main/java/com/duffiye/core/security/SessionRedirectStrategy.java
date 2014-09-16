package com.duffiye.core.security;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.DefaultRedirectStrategy;

import com.duffiye.core.common.ProcResult;
import com.duffiye.core.utils.ResponseUtils;



public class SessionRedirectStrategy extends DefaultRedirectStrategy {

    @Override
    public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        String str = request.getRequestURI();
        if (logger.isDebugEnabled()) {
            logger.debug("From  '" + str + "'");
        }
        String[] arr = StringUtils.split(str, "/");
        String ctx = request.getContextPath();
        if (StringUtils.isNotBlank(ctx)) {
            arr = Arrays.copyOfRange(arr, 1, arr.length);
        }
        if (arr.length <= 1) {
            super.sendRedirect(request, response, url);
        } else {
            ProcResult result = new ProcResult();
            result.setMessage("会话超时,请重新登陆!");
            result.setStatusCode(301);
            ResponseUtils.write(response, result);
        }
    }

}
