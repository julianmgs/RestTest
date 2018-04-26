package com.julian.resttest.service;

import java.io.IOException;

import com.julian.resttest.json.MtgMintJson;

public interface MtgMintScrapper {

    MtgMintJson findByKeyword(String keyword);
}
