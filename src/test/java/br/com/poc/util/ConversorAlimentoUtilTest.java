package br.com.poc.util;


import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class ConversorAlimentoUtilTest {


    @Test
    public void deve_ler_csv() throws URISyntaxException {
        ConversorAlimentoUtil conversorAlimentoUtil = new ConversorAlimentoUtil();
        assertNotNull(conversorAlimentoUtil.getMapAlimento());
    }

}