package com.erixian.weatherApp.controller;

import com.erixian.weatherApp.model.Coordinates;
import com.erixian.weatherApp.service.GeoCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class GeocodingController {

    private final GeoCodingService geoCodingService;

    @Autowired
    public GeocodingController(GeoCodingService geoCodingService) {
        this.geoCodingService = geoCodingService;
    }

   /*@GetMapping("/coordTest")
    public String showCoordTest() {
        return "coordTest";
    }*/

    @GetMapping("/coordTest")
    public String getCoordByCity(@RequestParam(required = false) String city,
                                 @RequestParam(required = false) String stateCode,
                                 @RequestParam(required = false) String countryCode,
                                 Model model) {
        if (city == null || city.trim().isEmpty()) {
           model.addAttribute("error, please provide a city name");
           return "coordTest";
        }

        Coordinates coordResponse = this.geoCodingService.getCoordinates(city.trim(), stateCode.trim(), countryCode.trim());
        model.addAttribute("coordinates", coordResponse);
        model.addAttribute("city", city);

        return  "coordTest";
    }
}
