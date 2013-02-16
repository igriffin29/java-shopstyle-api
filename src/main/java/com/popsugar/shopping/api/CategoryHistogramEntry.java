package com.popsugar.shopping.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.popsugar.shopping.bo.Category;

public class CategoryHistogramEntry extends HistogramEntry
{
    @JsonUnwrapped
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
