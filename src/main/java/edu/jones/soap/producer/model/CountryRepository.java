package edu.jones.soap.producer.model;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jones on 27/02/2017.
 */
@Component
public class CountryRepository {

    private static final List<Country> countries = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madri");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);
        countries.add(spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(46704314);
        countries.add(poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(46704314);
        countries.add(uk);

    }

    public Country findCountry(String name) {
        Assert.notNull(name);
        Country result = null;
        for (Country country: countries) {
            if (name.equals(country.getName())) {
                result = country;
            }
        }
        return result;
    }

}