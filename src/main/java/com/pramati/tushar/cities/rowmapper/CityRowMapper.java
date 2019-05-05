package com.pramati.tushar.cities.rowmapper;

import com.pramati.tushar.cities.model.City;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CityRowMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        City city = new City();

        int idx = 1;

        city.setOfficeName(resultSet.getString(idx++));
        city.setPinCode(resultSet.getLong(idx++));
        city.setOfficeType(resultSet.getString(idx++));
        city.setDeliveryStatus(resultSet.getString(idx++));
        city.setDivisionName(resultSet.getString(idx++));
        city.setRegionName(resultSet.getString(idx++));
        city.setCircleName(resultSet.getString(idx++));
        city.setTaluk(resultSet.getString(idx++));
        city.setDistrictName(resultSet.getString(idx++));
        city.setStateName(resultSet.getString(idx));

        return city;
    }

    @Getter
    public enum CityColumns {



        OFFICE_NAME("OFFICENAME"),
        PIN_CODE("PINCODE"),
        OFFICE_TYPE("OFFICETYPE"),
        DELIVERY_STATUS("DELIVERYSTATUS"),
        DIVISION_NAME("DIVISIONNAME"),
        REGION_NAME("REGIONNAME"),
        CIRCLE_NAME("CIRCLENAME"),
        TALUK("TALUK"),
        DISTRICT_NAME("DISTRICTNAME"),
        STATE_NAME("STATENAME");

        private String name;

        CityColumns(String name) {
            this.name = name;
        }

        public static String getProjectionColumnNames() {
            return Arrays.stream(values()).map(CityColumns::getName).collect(Collectors.joining(","));
        }
    }
}
