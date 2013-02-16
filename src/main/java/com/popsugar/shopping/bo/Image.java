package com.popsugar.shopping.bo;

public class Image
{
    public enum SizeName {
        Small, Medium, Large, XLarge, Original, IPhoneSmall, IPhone
    }

    private SizeName sizeName;
    private int width;
    private int height;
    private String url;

    public SizeName getSizeName()
    {
        return sizeName;
    }

    public void setSizeName(SizeName sizeName)
    {
        this.sizeName = sizeName;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

}
