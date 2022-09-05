package com.example.sistemarestaurante.models;

import java.io.Serializable;
import java.util.Objects;

public class productId implements Serializable {

    private int productCode;

    private String productName;

    productId(int NewProductCode, String NewProductName, float NewProductPrice) {
        this.productCode = NewProductCode;
        this.productName = NewProductName;
    }

    public productId() {}

    public void setProductCode(int newProductCode) {
        this.productCode = newProductCode;
    }

    public void setProductName(String newProductName) {
        this.productName = newProductName;
    }

    public int getProductCode() {
        return this.productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        productId ProductId = (productId) o;
        return Objects.equals(productCode, ProductId.productCode) && Objects.equals(productName, ProductId.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, productName);
    }

}
