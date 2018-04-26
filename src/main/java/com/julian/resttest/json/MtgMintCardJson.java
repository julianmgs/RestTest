package com.julian.resttest.json;

public class MtgMintCardJson {

    private String cardName;
    private String setName;
    private double price;
    private String imgUrl;
    
    public MtgMintCardJson() {
        super();
    }
    
    public MtgMintCardJson(String cardName, String setName, double price, String imgUrl) {
        super();
        this.cardName = cardName;
        this.setName = setName;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getCardName() {
        return cardName;
    }
    
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    
    public String getSetName() {
        return setName;
    }
    
    public void setSetName(String setName) {
        this.setName = setName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
}
