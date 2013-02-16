package com.popsugar.shopping.bo;

import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Product
{
    private long id;
    private String name;
    private Currency currency;
    private double price;
    private String priceLabel;
    private double salePrice;
    private String salePriceLabel;
    private boolean inStock;
    private Retailer retailer;
    private Locale locale;
    private String description;
    private Brand brand;
    private String clickUrl;
    private Image[] images;
    private ProductColor[] colors;
    private ProductSize[] sizes;
    private Category[] categories;
    private String seeMoreLabel;
    private String seeMoreUrl;
    private Date extractDate;

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

    public Currency getCurrency()
    {
        return currency;
    }

    public void setCurrency(Currency currency)
    {
        this.currency = currency;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getPriceLabel()
    {
        return priceLabel;
    }

    public void setPriceLabel(String priceLabel)
    {
        this.priceLabel = priceLabel;
    }

    public double getSalePrice()
    {
        return salePrice;
    }

    public void setSalePrice(double salePrice)
    {
        this.salePrice = salePrice;
    }

    public String getSalePriceLabel()
    {
        return salePriceLabel;
    }

    public void setSalePriceLabel(String salePriceLabel)
    {
        this.salePriceLabel = salePriceLabel;
    }

    public boolean isInStock()
    {
        return inStock;
    }

    public void setInStock(boolean inStock)
    {
        this.inStock = inStock;
    }

    public Retailer getRetailer()
    {
        return retailer;
    }

    public void setRetailer(Retailer retailer)
    {
        this.retailer = retailer;
    }

    public Locale getLocale()
    {
        return locale;
    }

    public void setLocale(Locale locale)
    {
        this.locale = locale;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public void setBrand(Brand brand)
    {
        this.brand = brand;
    }

    public String getClickUrl()
    {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl)
    {
        this.clickUrl = clickUrl;
    }

    public Image[] getImages()
    {
        return images;
    }

    public void setImages(Image[] images)
    {
        this.images = images;
    }

    public ProductColor[] getColors()
    {
        return colors;
    }

    public void setColors(ProductColor[] colors)
    {
        this.colors = colors;
    }

    public ProductSize[] getSizes()
    {
        return sizes;
    }

    public void setSizes(ProductSize[] sizes)
    {
        this.sizes = sizes;
    }

    public Category[] getCategories()
    {
        return categories;
    }

    public void setCategories(Category[] categories)
    {
        this.categories = categories;
    }

    public String getSeeMoreLabel()
    {
        return seeMoreLabel;
    }

    public void setSeeMoreLabel(String seeMoreLabel)
    {
        this.seeMoreLabel = seeMoreLabel;
    }

    public String getSeeMoreUrl()
    {
        return seeMoreUrl;
    }

    public void setSeeMoreUrl(String seeMoreUrl)
    {
        this.seeMoreUrl = seeMoreUrl;
    }

    public Date getExtractDate()
    {
        return extractDate;
    }

    public void setExtractDate(Date extractDate)
    {
        this.extractDate = extractDate;
    }    
}
