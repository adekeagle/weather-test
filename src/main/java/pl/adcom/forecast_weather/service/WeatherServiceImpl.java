package pl.adcom.forecast_weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.adcom.forecast_weather.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Weather getParamiters(String city) {
        String weatherUrl = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=e4ca033fa0ee55203d5de8891c986cc8", city );
        Weather weather = restTemplate.getForObject(weatherUrl, Weather.class);
        String iconId = weather.getWeather().get(0).getIcon();
        String url = "http://openweathermap.org/img/w/" + iconId + ".png";
        weather.getWeather().get(0).setIcon(url);

        return weather;
    }
}
