package com.pramati.tushar.cities.repository;

import com.pramati.tushar.cities.model.City;
import com.pramati.tushar.cities.rowmapper.CityRowMapper;

import java.util.List;

public interface CityRepository {

    String SELECT_COLUMN_NAMES = CityRowMapper.CityColumns.getProjectionColumnNames();
    String TABLE_NAME= "CITIES";
    String FROM_TABLE= " FROM "+TABLE_NAME;

    public List<City> findCitiesByOfficeName(String officeName, long size);
}
