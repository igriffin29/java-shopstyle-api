package com.popsugar.shopping.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.popsugar.shopping.bo.Color;

public class ColorHistogramEntry extends HistogramEntry
{
    @JsonUnwrapped
    private Color color;
    
    public Color getColor()
    {
        return color;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
    }

}
