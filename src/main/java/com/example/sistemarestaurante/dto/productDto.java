package com.example.sistemarestaurante.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class productDto {

    @NotBlank
    private String productName;
    @NotNull
    private int productCode;
    @NotNull
    private float productPrice;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
