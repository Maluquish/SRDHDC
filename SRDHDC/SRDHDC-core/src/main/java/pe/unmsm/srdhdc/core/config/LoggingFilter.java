package pe.unmsm.srdhdc.core.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import pe.unmsm.srdhdc.domain.constantes.ConstantesApp;

public class LoggingFilter implements Filter {

	@Override
	public void destroy() {
		return;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		HttpSession session = request.getSession();
		String loginURI = request.getContextPath() + "/login";
		String resourcesURI = request.getContextPath() + "/resources/";
		
		boolean loggedIn = session != null && session.getAttribute(ConstantesApp.USUARIO_SESSION) != null;
        boolean loginRequest = request.getRequestURI().contains(loginURI);
        boolean resourcesRequest = request.getRequestURI().contains(resourcesURI);
        
        if (loggedIn || loginRequest || resourcesRequest) {
        	MDC.put(ConstantesApp.SESSION_ID, session.getId());
        	filterChain.doFilter(servletRequest, servletResponse);
        } else {
        	if (request.getContentType() != null && request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
        		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        		response.setStatus(HttpStatus.UNAUTHORIZED.value());
        	} else {
        		response.sendRedirect(loginURI + "/inicio");
        	}
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		return;
	}
}