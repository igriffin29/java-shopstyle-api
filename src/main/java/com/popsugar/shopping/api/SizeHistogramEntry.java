package com.popsugar.shopping.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.popsugar.shopping.bo.Size;

public class SizeHistogramEntry extends HistogramEntry
{
    @JsonUnwrapped
    private Size size;
    
    public Size getSize()
    {
        return size;
    }
    public void setSize(Size size)
    {
        this.size = size;
    }
}
