package br.com.poc.util;

import lombok.Getter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ConversorAlimentoUtil {

    @Getter
    private final Map<String, String> mapAlimento;

    public ConversorAlimentoUtil() throws URISyntaxException {
        Path path = Path.of("src/main/resources/alimentos.csv");
        Map<String, String> map = new HashMap<>();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1);) {
            lines.forEach(line ->{
                String[] split = line.split(";");
                String id = split[0].trim();
                String nome = split[1].trim();
                map.put(id, nome);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(map);
        this.mapAlimento = map;
    }

}
