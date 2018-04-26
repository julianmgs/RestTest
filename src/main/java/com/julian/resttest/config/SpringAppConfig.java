package com.julian.resttest.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.maps.GeoApiContext;

@Configuration
@EnableWebMvc
@ComponentScan("com.julian.resttest")
public class SpringAppConfig {
	
    @Value("#{systemEnvironment['GMAPS_API_KEY']}")
    private String apiKey;
    
    @Bean
    @Scope("singleton")
    public GeoApiContext geoApiContext() {
        
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .proxy(new Proxy(Type.HTTP, new InetSocketAddress("sm-isa-01.rosariobus.com.ar", 8080)))
                .build();
        
        return context;
    }
}
