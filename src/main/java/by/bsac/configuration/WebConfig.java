package by.bsac.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //Servlet context
    private ServletContext servlet_context;

    /**
     * Create a Thymeleaf template resolver engine. Resolve template names.
     * @return - SpringResourceTemplateResolver - common template resolver.
     */
    @Bean
    public ServletContextTemplateResolver contextTemplateResolver() {
        ServletContextTemplateResolver tr = new ServletContextTemplateResolver(servlet_context);
        tr.setPrefix("/WEB-INF/");
        tr.setSuffix(".html");
        tr.setTemplateMode(TemplateMode.HTML);
        tr.setCacheable(false);
        return tr;
    }

    /**
     * Create a Thymeleaf template resolver by using template engine.
     * @return - Spring template engine.
     */
    @Bean
    @Description("Thymeleaf template engine.")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(this.contextTemplateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    /**
     * Main view resolver. WebApp uses Thymeleaf Java template engine.
     * @return - Thymeleaf view resolver.
     */
    @Bean
    @Description("Main view resolver")
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver view_resolver = new ThymeleafViewResolver();
        view_resolver.setTemplateEngine(this.templateEngine());
        return view_resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //Add view controller to "root" path. Redirect to login page.
        registry.addRedirectViewController("/", "/login");
    }

    //Spring autowiring
    @Autowired
    public void autowire(ServletContext a_servlet_context) {
        //Mapping
        this.servlet_context = a_servlet_context;
    }
}
