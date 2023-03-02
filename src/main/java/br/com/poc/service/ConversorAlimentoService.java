package br.com.poc.service;

import br.com.poc.util.ConversorAlimentoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class ConversorAlimentoService {

    private final ConversorAlimentoUtil conversorAlimentoUtil;

    public String getAlimento(String id){
        Map<String, String> mapAlimento = conversorAlimentoUtil.getMapAlimento();
        String nomeAlimento = mapAlimento.get(id);

        if(nomeAlimento == null){
            System.out.println("ID nao econtrado");
            return id;
        }
        return nomeAlimento;
    }



}
