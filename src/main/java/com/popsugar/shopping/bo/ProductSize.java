package com.popsugar.shopping.bo;

public class ProductSize
{
    private String name;
    private Size canonicalSize;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Size getCanonicalSize()
    {
        return canonicalSize;
    }

    public void setCanonicalSize(Size canonicalSize)
    {
        this.canonicalSize = canonicalSize;
    }
}
