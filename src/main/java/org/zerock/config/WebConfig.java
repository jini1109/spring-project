package org.zerock.config;

import javax.servlet.ServletRegistration;

public class WebConfig extends 
	AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}
	
	protected String[] getServletMapping() {
		return new String[] {"/"};
	}
	
	protected void customizeRegistration(
	 ServletRegistration.Dynamic registration) {
		
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}
	

}
