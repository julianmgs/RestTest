package com.julian.resttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julian.resttest.json.MtgMintJson;
import com.julian.resttest.service.MtgMintScrapper;

@RestController
public class MtgMintController {

    @Autowired
    MtgMintScrapper mtgMintScrapper;
    
    @RequestMapping("/scrap")
    public MtgMintJson info() {
        
        return mtgMintScrapper.findByKeyword("avatar of woe");
    }
}
