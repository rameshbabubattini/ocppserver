package com.ocpp.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/Ocpp/Cs/2015/10/*");
	}

	@Bean(name = "ocpp")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema ocppSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("OcppPort");
		wsdl11Definition.setLocationUri("/Ocpp/Cs/2015/10/");
		wsdl11Definition.setTargetNamespace("urn://Ocpp/Cs/2015/10/");
		wsdl11Definition.setSchema(ocppSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema ocppSchema() {
		return new SimpleXsdSchema(new ClassPathResource("ocpp.xsd"));
	}
	
}
