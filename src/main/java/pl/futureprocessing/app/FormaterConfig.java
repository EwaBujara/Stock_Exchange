package pl.futureprocessing.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.futureprocessing.converter.UserConverter;

@Configuration
@ComponentScan("pl.futureprocessing")
@EnableWebMvc
@EnableTransactionManagement
public class FormaterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getUserConverter());
    }

    @Bean
    public UserConverter getUserConverter(){return  new UserConverter();}
}

