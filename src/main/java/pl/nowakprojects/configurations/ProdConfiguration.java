package pl.nowakprojects.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.nowakprojects.services.impl.InfoServiceProd;
import pl.nowakprojects.services.IInfoService;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Configuration
@Profile("prod")
public class ProdConfiguration {

    @Bean
    public IInfoService getInfoProd() {
        return new InfoServiceProd();
    }
}
