package com.popsugar.shopping.bo;


public class Brand implements SearchFilter
{
    private long id;
    private String name;
    private String url;

    @Override
    public String getFilterId()
    {
        return "b" + getId();
    }
    
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
