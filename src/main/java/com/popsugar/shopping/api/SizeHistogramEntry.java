package com.popsugar.shopping.api;

import com.popsugar.shopping.bo.Size;

public class SizeHistogramEntry extends HistogramEntry
{
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
