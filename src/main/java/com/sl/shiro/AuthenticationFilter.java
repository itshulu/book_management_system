package com.sl.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author itning
 * @date 2019/4/15 9:15
 */
public class AuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (request instanceof HttpServletRequest) {
            System.out.println(HttpMethod.OPTIONS.name());
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals(HttpMethod.OPTIONS.name())) {
                return true;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
