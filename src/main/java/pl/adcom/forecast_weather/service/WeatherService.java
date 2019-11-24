package pl.adcom.forecast_weather.service;

import org.springframework.web.bind.annotation.RequestParam;
import pl.adcom.forecast_weather.model.Weather;

public interface WeatherService {
    Weather getParamiters(String city);
}
