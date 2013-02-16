package com.popsugar.shopping.api;

import com.popsugar.shopping.bo.Retailer;

public class RetailerListResponse
{
    private Retailer[] retailers;
    
    public Retailer[] getRetailers()
    {
        return retailers;
    }
    
    public void setRetailers(Retailer[] retailers)
    {
        this.retailers = retailers;
    }
}
