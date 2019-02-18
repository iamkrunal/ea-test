package com.ea.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.ea.model.CarShow;


public class CarServiceTest extends AbstractTest {
	@TestConfiguration
    static class CaServiceImplTestContextConfiguration {
  
        @Bean
        public CarService carService() {
            return new CarServiceImpl();
        }
    }

	
	
	@Autowired
	private CarService carService;
	
	@Test
	public void TestGetCarShows() {
		try {
			CarShow[] shows = carService.getCarShowsFromEAService();
			if(shows != null)
				assertThat(shows.length, greaterThan(0));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void TestCarMap() {
		try {
			carService.getCarShows();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
