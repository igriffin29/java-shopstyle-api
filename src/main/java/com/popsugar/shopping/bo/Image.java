package com.popsugar.shopping.bo;

/**
 * Wrapper around a specific image URL, providing metadata about the actual image. For a given
 * product, the same picture will be available in different sizes. Each size has its own Image
 * object
 */
public class Image
{
    public enum SizeName {
        Small, Medium, Large, XLarge, Original, IPhoneSmall, IPhone
    }

    private SizeName sizeName;
    private int width;
    private int height;
    private String url;

    /**
     * Returns the name of the size of this image.
     */
    public SizeName getSizeName()
    {
        return sizeName;
    }

    public void setSizeName(SizeName sizeName)
    {
        this.sizeName = sizeName;
    }

    /**
     * Returns the maximum width of the image. Currently this is NOT the actual width of the image
     */
    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Returns the maximum height of the image. Currently this is NOT the actual height of the image
     */
    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Returns the URL of the image file
     */
    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

}
