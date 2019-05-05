package com.pramati.tushar.cities.service;

import com.pramati.tushar.cities.model.City;
import com.pramati.tushar.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {


    @Autowired
    private CityRepository cityRepository;


    @Override
    public List<City> getCitiesList(String searchText, int size) {
        return cityRepository.findCitiesByOfficeName(searchText, size);
    }
}
