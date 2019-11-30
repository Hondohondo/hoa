package hoa.api.services;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Adds Cross-Origins mappings (for Angular)
 * @author nealk
 *
 */
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

}
