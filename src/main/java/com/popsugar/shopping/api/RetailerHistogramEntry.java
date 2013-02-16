package com.popsugar.shopping.api;

import com.popsugar.shopping.bo.Retailer;

public class RetailerHistogramEntry extends HistogramEntry
{
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
