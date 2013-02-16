package com.popsugar.shopping.api;

import com.popsugar.shopping.bo.Brand;

public class BrandListResponse
{
    private Brand[] brands;

    public Brand[] getBrands()
    {
        return brands;
    }

    public void setBrands(Brand[] brands)
    {
        this.brands = brands;
    }

}
