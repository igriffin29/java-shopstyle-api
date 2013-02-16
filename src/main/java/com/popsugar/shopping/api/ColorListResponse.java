package com.popsugar.shopping.api;

import com.popsugar.shopping.bo.Color;

public class ColorListResponse
{
    private Color[] colors;
    
    public Color[] getColors()
    {
        return colors;
    }

    public void setColors(Color[] colors)
    {
        this.colors = colors;
    }
}
