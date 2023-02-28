package com.kodilla.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {

    private final Set<Continent> setOfContinents = new HashSet<>();


    public void addContinent(Continent continent) {
        setOfContinents.add(continent);
    }

    public BigDecimal getPeopleQuantity(){

        return setOfContinents.stream()
                .flatMap(continent -> continent.getSetOfCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
