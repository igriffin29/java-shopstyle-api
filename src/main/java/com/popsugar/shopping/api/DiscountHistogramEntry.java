package com.popsugar.shopping.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.popsugar.shopping.bo.Discount;

public class DiscountHistogramEntry extends HistogramEntry
{
    @JsonUnwrapped
    private Discount discount;
    
    public Discount getDiscount()
    {
        return discount;
    }
    
    public void setDiscount(Discount discount)
    {
        this.discount = discount;
    }
}
