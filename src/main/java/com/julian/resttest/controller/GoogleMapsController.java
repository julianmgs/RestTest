package com.julian.resttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.julian.resttest.json.DistanciaJson;
import com.julian.resttest.service.GoogleMapsService;

@RestController
public class GoogleMapsController {

    @Autowired
    GoogleMapsService gMapsService;
    
    @RequestMapping(value = "/gmaps", produces = "application/json; charset=utf-8")
    public String info() {
        
        return gMapsService.getMapsJson();
    }
    
    @RequestMapping(value = "/distancia", produces = "application/json; charset=utf-8", params = {"latLonFrom", "latLonTo"})
    public DistanciaJson distancia(@RequestParam("latLonFrom") String latLonFrom, @RequestParam("latLonTo") String latLonTo) {
        
        String[] from = latLonFrom.split(",");
        String[] to = latLonTo.split(",");
        
        return gMapsService.getDistancia(Double.parseDouble(from[0]), 
                                         Double.parseDouble(from[1]), 
                                         Double.parseDouble(to[0]), 
                                         Double.parseDouble(to[1]));
    }
    
    @RequestMapping(value = "/dmatrix", produces = "application/json; charset=utf-8")
    public String distanceMatrix() {
        
        return gMapsService.getDistanceMatrix();
    }
}
