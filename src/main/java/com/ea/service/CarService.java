package com.ea.service;

import java.util.List;
import java.util.Map;

import com.ea.model.CarShow;

public interface CarService {

	public Map<String, Map<String, List<String>>> getCarShows()  throws Exception;
	
	public CarShow[] getCarShowsFromEAService() throws Exception;
}
