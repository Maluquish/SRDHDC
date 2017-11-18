package pe.unmsm.srdhdc.core.config;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import pe.unmsm.srdhdc.domain.constantes.ConstantesApp;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerDispatcherServlet(servletContext);
		registerFilter(servletContext);
	}

	private void registerDispatcherServlet(final ServletContext servletContext) {
		WebApplicationContext context = getContext();
		servletContext.addListener(new ContextLoaderListener(context));

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(ConstantesApp.DISPATCHER_SERVLET, new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(ConstantesApp.DISPATCHER_MAPPING);
	}
	
	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(ConstantesApp.PAQUETE_DOMINIO_CONFIGURACION);
		return context;
	}
	
	private void registerFilter(ServletContext servletContext) {
		final Dynamic filterRegistrationSesion = servletContext.addFilter(ConstantesApp.SESSION_FILTER, LoggingFilter.class);
		filterRegistrationSesion.addMappingForUrlPatterns(null, false, ConstantesApp.MAPPING_FOR_URL_PATTERNS);
	}

}
