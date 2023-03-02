package br.com.poc.service;

import br.com.poc.util.ConversorAlimentoUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ConversorAlimentoServiceTest {

    @Autowired
    private ConversorAlimentoService conversorAlimentoService;

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "90"})
    public void deve_converter_nome(String argument) throws URISyntaxException {
        System.out.println(argument);
        ConversorAlimentoUtil conversorAlimentoUtil = new ConversorAlimentoUtil();
        assertNotNull(conversorAlimentoService.getAlimento(argument));
    }


    @Test
    public void deve_retorna_banana() throws URISyntaxException {
        ConversorAlimentoUtil conversorAlimentoUtil = new ConversorAlimentoUtil();
        String id = "1";
        String nomeAlimento = conversorAlimentoService.getAlimento(id);

        assertEquals("banana", nomeAlimento);
    }


    @Test
    public void deve_retorna_Id_quando_nao_encontrato() throws URISyntaxException {
        ConversorAlimentoUtil conversorAlimentoUtil = new ConversorAlimentoUtil();
        String id = "100";
        String nomeAlimento = conversorAlimentoService.getAlimento(id);

        assertEquals("100", nomeAlimento);
    }



}