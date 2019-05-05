package com.pramati.tushar.cities.controller.rest;

import com.pramati.tushar.cities.model.City;
import com.pramati.tushar.cities.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<City> getSuggestCities(@RequestParam("start") String start,
                                       @RequestParam("size") int size) {
        log.info("querying cities with search string {}", start);

        List<City> citiesList = cityService.getCitiesList(start, size);
        CityResponse serviceResponse = new CityResponse();

        log.info("found {} number of cities", citiesList.size());

        if (citiesList.isEmpty()) {
            serviceResponse.setMessage("no city found");
            throw new CityNotFoundException(start);
        }

        return citiesList;
    }
}
