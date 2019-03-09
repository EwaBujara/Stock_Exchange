package pl.stock.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.stock.converter.StockConverter;
import pl.stock.converter.UserConverter;
import pl.stock.converter.WalletConverter;

@Configuration
@ComponentScan("pl.stock")
@EnableWebMvc
@EnableTransactionManagement
public class FormaterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getUserConverter());
        registry.addConverter(getStockConverter());
        registry.addConverter(getWalletonverte());
    }

    @Bean
    public UserConverter getUserConverter(){return  new UserConverter();}

    @Bean
    public StockConverter getStockConverter(){return new StockConverter();}

    @Bean
    public WalletConverter getWalletonverte(){return new WalletConverter();}
}

