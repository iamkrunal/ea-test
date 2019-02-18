package com.ea.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ea.service.CarService;

@RestController
@RequestMapping(value = "/")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping(value = "/test")
	public String getMessage() {
		return "Hellow World!!";
	}
	
	@GetMapping(value = "/cars")
	public ModelAndView getCars(Map<String, Object> model) throws Exception{
		//carService.getCarShowList();
		model.put("makeMap", carService.getCarShows());
		return new ModelAndView("cars");
	}
	
}
