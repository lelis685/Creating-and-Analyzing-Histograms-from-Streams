package br.com.poc;

import br.com.poc.model.City;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ComputeStatistics {

    public static void main(String[] args) throws URISyntaxException {

        Function<String, City> lineToCity =
                line -> {
                    String[] split = line.split(";");

                    String cityName = split[1].trim();

                    String state = split[2].trim();

                    String populationAsString = split[3];
                    populationAsString = populationAsString.replace(" ", "");
                    int population = Integer.parseInt(populationAsString);

                    String landAreaAsString = split[4];
                    landAreaAsString = landAreaAsString.replace(" ", "").replace(',', '.');
                    double landArea = Double.parseDouble(landAreaAsString);

                    return new City(cityName, state, population, landArea);
                };

        // https://en.wikipedia.org/wiki/List_of_United_States_cities_by_population
        Path path = Paths.get(ComputeStatistics.class.getResource("/cities.csv").toURI());
        Set<City> cities = null;
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1);) {

            cities = lines.skip(2)
                    .map(lineToCity)
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("# cities = " + cities.size());


		Map<String, List<City>> citiesPerState = cities.stream()
                .collect(
                        Collectors.groupingBy(
                                city -> city.getState()
                        )
                );

		System.out.println("Map size = " + citiesPerState.size());

        List<City> cityOfUtah = citiesPerState.get("Utah");
        System.out.println(cityOfUtah);


        Map<String, Long> numberOfCitiesPerState = cities.stream()
                .collect(
                        Collectors.groupingBy(
                                city -> city.getState(), Collectors.counting()
                        )
                );

        System.out.println("cities in Utah" + numberOfCitiesPerState.get("Utah"));

        Map.Entry<String, Long> stateMostCities = numberOfCitiesPerState.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow();

        System.out.println("stateMostCities " + stateMostCities);

        Integer populationUtah = citiesPerState.get("Utah").stream()
                .collect(Collectors.summingInt(City::getPopulation));

        System.out.println("population of Utah " + populationUtah);

        Map<String, Integer> populationOfCitiesPerState = cities.stream()
                .collect(
                        Collectors.groupingBy(
                                City::getState, Collectors.summingInt(City::getPopulation)
                        )
                );

        System.out.println(populationOfCitiesPerState);

    }
}






