package com.sl.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpHeaders.*;

/**
 * @author itning
 * @date 2019/4/15 9:15
 */
public class AuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (request instanceof HttpServletRequest) {
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpServletRequest req = (HttpServletRequest) request;
            allowCors(resp, req);
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals(HttpMethod.OPTIONS.name())) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    private void allowCors(HttpServletResponse resp, HttpServletRequest req) {
        String origin = req.getHeader(ORIGIN);
        resp.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        resp.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
        resp.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "POST,GET,OPTIONS,DELETE,PUT,PATCH");
        resp.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, req.getHeader(ACCESS_CONTROL_REQUEST_HEADERS));
        resp.setIntHeader(ACCESS_CONTROL_MAX_AGE, 2592000);
    }
}
