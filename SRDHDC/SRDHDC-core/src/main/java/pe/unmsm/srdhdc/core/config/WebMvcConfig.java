package pe.unmsm.srdhdc.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import pe.unmsm.srdhdc.domain.constantes.ConstantesApp;

@Configuration
@ComponentScan(basePackages = { ConstantesApp.PAQUETE_DOMINIO })
@PropertySources(value = { @PropertySource(ConstantesApp.PROPERTY_SOURCE_SPRINGSRV), @PropertySource(ConstantesApp.PROPERTY_SOURCE_SPRINGSRV_ACTIVE) })
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(ConstantesApp.RESOURCE_HANDLER).addResourceLocations(ConstantesApp.RESOURCE_LOCATION);
	}
	
	@Bean
	public UrlBasedViewResolver getViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(1);
		return viewResolver;
	}

	@Bean
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(ConstantesApp.WEB_INF_TILES_XML);
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}
}
