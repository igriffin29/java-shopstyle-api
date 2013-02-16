package com.popsugar.shopping.api;

import com.popsugar.shopping.bo.Category;

public class CategoryListResponse
{
    private Category[] categories;

    public Category[] getCategories()
    {
        return categories;
    }

    public void setCategories(Category[] categories)
    {
        this.categories = categories;
    }
}
