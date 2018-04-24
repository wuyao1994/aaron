package com.upms.client.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.http.HttpStatus;

public class MyUserFilter extends UserFilter {
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (isLoginRequest(request, response) || isStaticResourceRequest(request)) {
			return true;
		} else {
			Subject subject = getSubject(request, response);
			return subject.getPrincipal() != null;
		}
	}



	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		return false;
	}

    /**
     * 静态资源请求都允许通过
     * @param request
     * @return
     */
    private boolean isStaticResourceRequest(ServletRequest request) {
        String url = ((ShiroHttpServletRequest) request).getRequestURI();
        if ("/".equals(url)) {
            return  true;
        }
        String[] staticResources = {".html", ".js", ".css",
                ".eot", ".svg", ".ttf", ".woff",
                ".png", ".jpg", ".ico"};
        if (StringUtils.endsWithAny(url, staticResources)) {
            return true;
        }
        return false;
    }
}
