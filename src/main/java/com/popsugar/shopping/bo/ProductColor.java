package com.popsugar.shopping.bo;

public class ProductColor
{
    private String name;
    private Image[] images;
    private String swatchUrl;
    private Color[] canonicalColors;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Image[] getImages()
    {
        return images;
    }

    public void setImages(Image[] images)
    {
        this.images = images;
    }
    
    public String getSwatchUrl()
    {
        return swatchUrl;
    }
    
    public void setSwatchUrl(String swatchUrl)
    {
        this.swatchUrl = swatchUrl;
    }

    public Color[] getCanonicalColors()
    {
        return canonicalColors;
    }

    public void setCanonicalColors(Color[] canonicalColors)
    {
        this.canonicalColors = canonicalColors;
    }    
}
