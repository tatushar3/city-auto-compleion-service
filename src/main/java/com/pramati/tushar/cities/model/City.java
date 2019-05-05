package com.pramati.tushar.cities.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class City {

    private String officeName;
    private Long pinCode;
    private String officeType;
    private String deliveryStatus;
    private String divisionName;
    private String regionName;
    private String circleName;
    private String taluk;
    private String districtName;
    private String stateName;

}
