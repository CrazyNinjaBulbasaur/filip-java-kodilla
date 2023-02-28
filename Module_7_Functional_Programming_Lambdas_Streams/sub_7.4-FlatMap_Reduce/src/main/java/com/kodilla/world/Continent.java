package com.kodilla.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {

    private final String name;
    private final Set<Country> setOfCountries = new HashSet<>();

    public Continent(final String name) {
        this.name = name;
    }

    public void addCountry(Country country){
        setOfCountries.add(country);
    }

    public Set<Country> getSetOfCountries() {
        return new HashSet<>(setOfCountries);
    }
}
