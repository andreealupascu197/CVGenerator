package com.cv.generator.platform;

import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories
public class CvGeneratorApplication {

	private static final Logger log = LoggerFactory.getLogger(CvGeneratorApplication.class);

	private static final String CONTEXT_PATH = "server.servlet.context-path";

	private static final String PORT = "server.port";

	private static final String KEY_STORE = "server.ssl.key-store";

	private static final String APPLICATION_NAME = "spring.application.name";

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CvGeneratorApplication.class);
		setDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		logApplicationStartup(env);
	}

	private static void logApplicationStartup(Environment env) {
		String protocol = "http";
		if (env.getProperty(KEY_STORE) != null) {
			protocol = "https";
		}
		String serverPort = env.getProperty(PORT);

		String contextPath = env.getProperty(CONTEXT_PATH);
		if (StringUtils.isBlank(contextPath)) {
			contextPath = "/";
		}
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info("""

                ----------------------------------------------------------
                \tApplication '{}' is running! Access URLs:
                \tLocal: \t\t{}://localhost:{}{}
                \tExternal: \t{}://{}:{}{}
                \tProfile(s): \t{}
                ----------------------------------------------------------""",
				env.getProperty(APPLICATION_NAME),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath,
				env.getActiveProfiles().length == 0 ? env.getDefaultProfiles() : env.getActiveProfiles());
	}

	private static void setDefaultProfile(SpringApplication app) {
		final Map<String, Object> properties = new HashMap<>();
		app.setDefaultProperties(properties);
	}

}
