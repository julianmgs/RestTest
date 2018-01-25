package com.julian.resttest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julian.resttest.json.InfoJson;

@RestController
public class InfoController {

	@RequestMapping("/info")
    public InfoJson info() {
        
		InfoJson info = new InfoJson();
		info.setNombre("Julian");
		info.setMensaje("Hello World!");
		
		return info;
    }
}
