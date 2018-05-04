package com.upms.server;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.upms.server")
@EnableTransactionManagement
public class UpmsServerApplication extends SpringBootServletInitializer {

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				// Due to CONFIDENTIAL and /*, this will cause Tomcat to redirect every request
				// to HTTPS.
				// You can configure multiple patterns and multiple constraints if you need more
				// control over what is and is not redirected.

				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;

	}



	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");

		// Set the scheme that will be assigned to requests received through this
		// connector
		// @param scheme The new scheme
		connector.setScheme("http");

		// Set the port number on which we listen for requests.
		// @param port The new port number
		connector.setPort(7080);

		// Set the secure connection flag that will be assigned to requests received
		// through this connector.
		// @param secure The new secure connection flag
		// if connector.setSecure(true),the http use the http and https use the
		// https;else if connector.setSecure(false),the http redirect to https;
		connector.setSecure(false);

		// redirectPort The redirect port number (non-SSL to SSL)
		connector.setRedirectPort(7443);
		return connector;
	}



	public static void main(String[] args) {

		SpringApplication.run(UpmsServerApplication.class, args);

	}



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(UpmsServerApplication.class);
	}
}
