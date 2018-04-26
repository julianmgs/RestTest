package com.julian.resttest.service;

import com.julian.resttest.json.DistanciaJson;

public interface GoogleMapsService {

    String getMapsJson();
    
    DistanciaJson getDistancia(double latFrom, double lonFrom, double latTo, double lonTo);
}
