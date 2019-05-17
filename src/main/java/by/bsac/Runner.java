package by.bsac;

import by.bsac.configuration.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *  Spring boot main class.
 */
@SpringBootApplication
public class Runner extends SpringBootServletInitializer {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger("Spring boot main class");

    /**
     * Configure the application. Normally all you would need to do is to add sources
     * (e.g. config classes) because other settings have sensible defaults. You might
     * choose (for instance) to add default command line arguments, or set an active
     * Spring profile.
     * @param builder a builder for the application context
     * @return the application builder
     * @see SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Runner.class, WebConfig.class);
    }

    /**
     * Main method.
     * @param args - program arguments.
     */
    public static void main(String[] args) {

        //Boot application
        SpringApplication.run(Runner.class, args);
    }
}

