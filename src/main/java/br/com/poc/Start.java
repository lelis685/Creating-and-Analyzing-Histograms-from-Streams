package br.com.poc;

import br.com.poc.service.ConversorAlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class Start {

    private static ConversorAlimentoService conversorAlimentoService;

    @Autowired
    private void setConversorAlimentoService(ConversorAlimentoService conversorAlimentoService){
        this.conversorAlimentoService = conversorAlimentoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);

        String alimento = conversorAlimentoService.getAlimento("1");

        System.out.println(alimento);

    }

}
