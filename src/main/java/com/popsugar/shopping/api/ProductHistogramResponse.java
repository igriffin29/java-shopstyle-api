package com.popsugar.shopping.api;

public class ProductHistogramResponse
{
    private ProductHistogramMetadata metadata;
    private BrandHistogramEntry[] brandHistogram;
    private CategoryHistogramEntry[] categoryHistogram;
    private ColorHistogramEntry[] colorHistogram;
    private RetailerHistogramEntry[] retailerHistogram;
    private SizeHistogramEntry[] sizeHistogram;

    public ProductHistogramMetadata getMetadata()
    {
        return metadata;
    }
    
    public BrandHistogramEntry[] getBrandHistogram()
    {
        return brandHistogram;
    }
    
    public void setBrandHistogram(BrandHistogramEntry[] brandHistogram)
    {
        this.brandHistogram = brandHistogram;
    }
    
    public CategoryHistogramEntry[] getCategoryHistogram()
    {
        return categoryHistogram;
    }
    
    public void setCategoryHistogram(CategoryHistogramEntry[] categoryHistogram)
    {
        this.categoryHistogram = categoryHistogram;
    }
    
    public ColorHistogramEntry[] getColorHistogram()
    {
        return colorHistogram;
    }
    
    public void setColorHistogram(ColorHistogramEntry[] colorHistogram)
    {
        this.colorHistogram = colorHistogram;
    }
    
    public RetailerHistogramEntry[] getRetailerHistogram()
    {
        return retailerHistogram;
    }
    
    public void setRetailerHistogram(RetailerHistogramEntry[] retailerHistogram)
    {
        this.retailerHistogram = retailerHistogram;
    }
    
    public SizeHistogramEntry[] getSizeHistogram()
    {
        return sizeHistogram;
    }
    
    public void setSizeHistogram(SizeHistogramEntry[] sizeHistogram)
    {
        this.sizeHistogram = sizeHistogram;
    }
}
