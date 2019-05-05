package com.pramati.tushar.cities.controller.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pramati.tushar.cities.model.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CityResponse {

    @JsonProperty
    private String message = null;

    @JsonProperty
    private Integer status = HttpStatus.OK.value();

    @JsonProperty
    private List<City> cities = new ArrayList<>();

    public void setResult(List<City> result) {
        this.cities = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
