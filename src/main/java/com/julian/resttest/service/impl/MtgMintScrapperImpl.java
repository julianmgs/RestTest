package com.julian.resttest.service.impl;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.julian.resttest.json.MtgMintCardJson;
import com.julian.resttest.json.MtgMintJson;
import com.julian.resttest.service.MtgMintScrapper;

@Service
public class MtgMintScrapperImpl implements MtgMintScrapper {

    @Override
    public MtgMintJson findByKeyword(String keyword) {
        
        keyword = keyword.replace(" ", "+");
        
        Document doc;
        
        try {
            
            //set HTTP proxy host to 127.0.0.1 (localhost)
            System.setProperty("http.proxyHost", "sm-isa-01.rosariobus.com.ar");
            
            //set HTTP proxy port to 3128
            System.setProperty("http.proxyPort", "8080");
            
            doc = Jsoup.connect("http://www.mtgmintcard.com/global-site-search?sitewide_keywords=" + keyword).timeout(15*1000).get();
        
            Elements newsHeadlines = doc.select("h5");
            
            MtgMintJson mtgMintJson = new MtgMintJson();
            for (Element e : newsHeadlines) {
                Elements linkElements = e.getElementsByTag("a");
                String cardName = linkElements.get(0).text();
                String setName = linkElements.get(1).text();
                
                /*
                Elements imgElements = e.getElementsByTag("img");
                String imgUrl = imgElements.get(0).attr("src");
                imgUrl = "http://www.mtgmintcard.com" + imgUrl;
                */
                
                /*
                Elements spanElements = e.getElementsByTag("span");
                String price = spanElements.get(0).text().replace("$", "");
                double numPrice = 0.00;
                if (NumberUtils.isNumber(price)) {
                    numPrice = Integer.parseInt(price);
                }
                */
                
                MtgMintCardJson card = new MtgMintCardJson(cardName, setName, 0, null);
                mtgMintJson.getCards().add(card);
            }
            
            return mtgMintJson;
        
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
