package com.popsugar.shopping.api;

import com.popsugar.shopping.bo.Category;

public class CategoryHistogramEntry extends HistogramEntry
{
    private Category category;
    
    public Category getCategory()
    {
        return category;
    }
    
    public void setCategory(Category category)
    {
        this.category = category;
    }
}
