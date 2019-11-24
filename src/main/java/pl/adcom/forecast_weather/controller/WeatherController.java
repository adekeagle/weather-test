package pl.adcom.forecast_weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.adcom.forecast_weather.model.Weather;
import pl.adcom.forecast_weather.service.WeatherService;

@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String showWeather(Model model, @RequestParam(value = "city", required = false, defaultValue = "Warszawa") String city){

        if (city == null)
            return "error";

        model.addAttribute("weather", weatherService.getParamiters(city));

        return "weather";
    }
}
