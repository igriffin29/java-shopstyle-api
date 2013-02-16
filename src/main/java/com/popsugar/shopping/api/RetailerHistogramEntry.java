package com.popsugar.shopping.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.popsugar.shopping.bo.Retailer;

public class RetailerHistogramEntry extends HistogramEntry
{
    @JsonUnwrapped
    private Retailer retailer;
    
    public Retailer getRetailer()
    {
        return retailer;
    }
    
    public void setRetailer(Retailer retailer)
    {
        this.retailer = retailer;
    }
}
