package com.verizon.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedTomcatConfiguration {

	@Value("${server.additionalPorts}")
	private String additionalPorts;

	@Bean
	public TomcatServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		Connector[] additionalConnectors = this.additionalConnector();
		if (additionalConnectors != null && additionalConnectors.length > 0) {
			tomcat.addAdditionalTomcatConnectors(additionalConnectors);
		}
		return tomcat;
	}

	private Connector[] additionalConnector() {
		List<Connector> result = new ArrayList<>();
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("https");
		connector.setPort(Integer.valueOf(this.additionalPorts));
		result.add(connector);

		return result.toArray(new Connector[] {});
	}
}
