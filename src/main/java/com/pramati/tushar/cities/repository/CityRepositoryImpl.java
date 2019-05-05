package com.pramati.tushar.cities.repository;

import com.pramati.tushar.cities.model.City;
import com.pramati.tushar.cities.rowmapper.CityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_BY_OFFICE_NAME = "SELECT " + SELECT_COLUMN_NAMES + FROM_TABLE
            + " WHERE LOWER(" + CityRowMapper.CityColumns.OFFICE_NAME.getName() + ") LIKE :officeName "
            + " ORDER BY "
            + CityRowMapper.CityColumns.OFFICE_NAME.getName() + " ASC"
            + " LIMIT :size";

    @Override
    public List<City> findCitiesByOfficeName(String officeName, long size) {
        Map<String, Object> params = new HashMap<>();
        params.put("officeName", officeName.toLowerCase() + "%");
        params.put("size", size);
        return jdbcTemplate.query(SELECT_BY_OFFICE_NAME, params, new CityRowMapper());
    }
}
