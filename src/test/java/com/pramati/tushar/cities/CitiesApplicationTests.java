package com.pramati.tushar.cities;

import com.pramati.tushar.cities.model.City;
import com.pramati.tushar.cities.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CitiesApplication.class)
@AutoConfigureMockMvc
public class CitiesApplicationTests {

	@Autowired
	private CityService cityService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {

	}
	@Test
	public void testGetSuggestCities() throws Exception {
		MockHttpServletResponse response = mvc.perform(get("/cities?start=h&size=1")).andReturn().getResponse();
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		String s="[{\"officeName\":\"H A L Korwa S.O\",\"pinCode\":227412,\"officeType\":\"S.O\",\"deliveryStatus\":\"Delivery\",\"divisionName\":\"Sultanpur\",\"regionName\":\"Allahabad\",\"circleName\":\"Uttar Pradesh\",\"taluk\":\"Gauriganj\",\"districtName\":\"Sultanpur\",\"stateName\":\"UTTAR PRADESH\"}]";
		assertEquals(s,response.getContentAsString());
	}

}
