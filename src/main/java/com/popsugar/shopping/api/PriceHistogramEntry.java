package com.popsugar.shopping.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.popsugar.shopping.bo.Price;

public class PriceHistogramEntry extends HistogramEntry
{
    @JsonUnwrapped
    private Price price;
    
    public Price getPrice()
    {
        return price;
    }
    
    public void setPrice(Price price)
    {
        this.price = price;
    }
}
