package br.com.poc.config;

import br.com.poc.util.ConversorAlimentoUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;

@Configuration
public class ConversorAlimentoConfig {


    @Bean
    public ConversorAlimentoUtil conversorAlimentoUtil() throws URISyntaxException {
        return new ConversorAlimentoUtil();
    }

}
