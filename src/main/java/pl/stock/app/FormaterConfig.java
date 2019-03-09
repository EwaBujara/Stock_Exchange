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
import pl.stock.converter.WalletItemConverter;
import pl.stock.entity.WalletItem;

@Configuration
@ComponentScan("pl.stock")
@EnableWebMvc
@EnableTransactionManagement
public class FormaterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getUserConverter());
        registry.addConverter(getStockConverter());
        registry.addConverter(getWalletConverter());
        registry.addConverter(getWalletItemConverter());
    }

    @Bean
    public UserConverter getUserConverter(){return  new UserConverter();}

    @Bean
    public StockConverter getStockConverter(){return new StockConverter();}

    @Bean
    public WalletConverter getWalletConverter(){return new WalletConverter();}

    @Bean
    public WalletItemConverter getWalletItemConverter(){return new WalletItemConverter();}
}

