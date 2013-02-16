package com.popsugar.shopping.bo;

public class Size implements SearchFilter
{
    private String id;
    private String name;
    private String url;

    @Override
    public String getFilterId()
    {
        return "s" + getId();
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
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
