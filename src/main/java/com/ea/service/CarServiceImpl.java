package com.ea.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ea.model.Car;
import com.ea.model.CarShow;

@Service("carService")
public class CarServiceImpl implements CarService {
	private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	
	private static final String EA_URI = "http://eacodingtest.digital.energyaustralia.com.au/api/v1/cars";
	
	/* 
	 * This will return a Map cars make of a map of model and participating shows
	 */
	@Override
	public Map<String, Map<String, List<String>>> getCarShows()  throws Exception{
		CarShow[] shows = getCarShowsFromEAService();
		if(shows != null) {
			logger.info("No of Shows: " + shows.length + " | Type: " + shows.getClass().getTypeName());
			return groupCarListByMakeAndModelAndShow(shows);
		}
		else
			return null;
	}
	
	/* (non-Javadoc)
	 * This function consume the webservice provided by EA and retrives an array of car shows
	 */
	@Override
	public CarShow[] getCarShowsFromEAService() throws Exception{
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		
	    Response response = client.target(EA_URI).request().get();
	    int status = response.getStatus();
	    logger.info("Status code: " + status);
	    
	    //CarShowCollection shows = response.readEntity(CarShowCollection.class);
	 
	    CarShow[] shows = response.readEntity(CarShow[].class);
	    logger.info("Total car show: " + shows.length);
	    
	    client.close();
	    return shows;

	}
	
	private Map<String, Map<String, List<String>>> groupCarListByMakeAndModelAndShow(CarShow[] shows) {
		logger.debug("2.No of Shows: " + shows.length + " | Type: " + shows.getClass().getTypeName());
		Map<String, Map<String, List<String>>> carMakeMap = new HashMap<String, Map<String, List<String>>>();
		logger.debug("3.No of Shows: " + shows.length + " | Type: " + shows.getClass().getTypeName());
		
		
		for(int i=0; i<shows.length; i++) {
			logger.debug("4. Type: " + shows[i].getClass().getTypeName());
			
			CarShow show = shows[i];
			logger.debug("ShowName: " + show.getName());
			
			for(Car car : show.getCars()) {
				Map<String, List<String>> carModelMap = null;
				
				// Creating a Make Map which is unique 
				if(!carMakeMap.containsKey(car.getMake())) {
					carModelMap = new HashMap<String, List<String>>();
					carMakeMap.put(car.getMake(), carModelMap);
				}else {
					carModelMap = carMakeMap.get(car.getMake());
				}
				
				// Creating a Model Map which has list of Car Show attached to it
				List<String> carShows = null;
				if(!carModelMap.containsKey(car.getModel())) {
					carShows = new ArrayList<String>(); 
					carModelMap.put(car.getModel(), carShows);
				}else {
					carShows = carModelMap.get(car.getModel());
				}
				if(!carShows.contains(show.getName()))
					carShows.add(show.getName());
			}
			
		}
		
		
		return carMakeMap;
	}

}
