package com.julian.resttest.service.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.julian.resttest.json.DistanciaJson;
import com.julian.resttest.service.GoogleMapsService;

@Service
public class GoogleMapsServiceImpl implements GoogleMapsService {

    @Autowired
    GeoApiContext geoApiContext;
    
    @Override
    public String getMapsJson() {
        
        try {
        
            GeocodingResult[] results;
            
            results = GeocodingApi.geocode(geoApiContext, "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(results[0]));
            
            return gson.toJson(results[0]);
        
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DistanciaJson getDistancia(double latFrom, double lonFrom, double latTo, double lonTo) {

        try {
        
            DirectionsResult result = DirectionsApi.newRequest(geoApiContext)
                    .origin(new LatLng(latFrom, lonFrom))
                    .destination(new LatLng(latTo, lonTo))
                    .await();
            
            //Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            DistanciaJson json = new DistanciaJson();
            
            json.setStartAddress(result.routes[0].legs[0].startAddress);
            json.setEndAddress(result.routes[0].legs[0].endAddress);
            json.setInMeters(result.routes[0].legs[0].distance.inMeters);
              
            return json;
            //return gson.toJson(result);
        
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
