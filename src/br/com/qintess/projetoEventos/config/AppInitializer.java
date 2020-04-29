package br.com.qintess.projetoEventos.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {//configura componentes externo (hibernnate)
		return new Class[] {
				WebMvcConfig.class,
				HibernateConfig.class,
				WebSecurityConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {//config spring mvc
		return new Class[] {
			
		};
	}

	@Override
	protected String[] getServletMappings() {// config mapping do servlet do spring
		return new String[] {
				"/"
		};
	}

	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8"); 
		return new Filter[] { characterEncodingFilter };
	}
}