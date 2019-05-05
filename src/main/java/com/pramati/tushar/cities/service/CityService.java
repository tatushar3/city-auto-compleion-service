package com.pramati.tushar.cities.service;

import com.pramati.tushar.cities.model.City;

import java.util.List;

public interface CityService {
    public List<City> getCitiesList(String searchText, int size);
}
