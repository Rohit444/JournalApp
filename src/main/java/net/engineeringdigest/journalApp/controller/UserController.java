package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.City;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import net.engineeringdigest.journalApp.service.UserService;
import net.engineeringdigest.journalApp.service.WeatherService;
import net.engineeringdigest.journalApp.weather.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @Value("${city}")
    private String city;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User userInDb = userService.findByUserName(name);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewEntry(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        userRepository.deleteByUserName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse response = weatherService.getWeather(city);
        String greeting = "";
        if (response != null) {
            greeting = " Today's " + city + "'s temperature feels like " + response.getCurrent().getTemperature();
        }
        return new ResponseEntity<>(" Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }

    @PostMapping("city")
    public ResponseEntity<?> greetingAppByCity(@RequestBody City city) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse response = weatherService.getWeather(city.getCityName());
        String greeting = "";
        if (response != null) {
            greeting = " Today's " + city.getCityName() + " temperature feels like " + response.getCurrent().getTemperature();
        }
        return new ResponseEntity<>(" Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }

}
