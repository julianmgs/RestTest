package com.julian.resttest.json;

import java.util.ArrayList;
import java.util.List;

public class MtgMintJson {

    private List<MtgMintCardJson> cards = new ArrayList<MtgMintCardJson>();

    public List<MtgMintCardJson> getCards() {
        return cards;
    }

    public void setCards(List<MtgMintCardJson> cards) {
        this.cards = cards;
    }
    
}
