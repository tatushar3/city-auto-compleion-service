package com.pramati.tushar.cities.controller.rest;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String search) {
        super("could not find city with search criteria " + search);
    }
}
