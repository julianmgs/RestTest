package com.julian.resttest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julian.resttest.json.InfoJson;

@RestController
public class InfoController {

	@RequestMapping("/info")
    public InfoJson greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
		InfoJson info = new InfoJson();
		info.setNombre("Julian");
		info.setMensaje("Hello World!");
		
		return info;
    }
}
