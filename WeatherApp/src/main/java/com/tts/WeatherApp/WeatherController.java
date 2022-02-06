package com.tts.WeatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
@Autowired

private WeatherService weatherService;

@GetMapping
public String getIndex (Model model) {
	Response response = weatherService.getForecast("43210");
	model.addAttribute("request", new Request());
	return "index";
}

public String postIndex(Request request, Model model) {
	Response data =  weatherService.getForecast(request.getIndex());
	model.addAttribute("data", data);
	return "index";
}

}
