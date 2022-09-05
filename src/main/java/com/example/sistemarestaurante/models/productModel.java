package com.example.sistemarestaurante.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_PRODUCT")
@IdClass(productId.class)

public class productModel {

    @Id
    @NotNull

    private int productCode;

    @Id
    @NotNull

    private String productName;

    @Column(nullable = false, unique = false, length = 5)
    private float productPrice;

    productModel(int NewProductCode, String NewProductName, float NewProductPrice) {
        this.productCode = NewProductCode;
        this.productName = NewProductName;
        this.productPrice = NewProductPrice;
    }

    public productModel() {}

    public void setProductCode(int newProductCode) {
        this.productCode = newProductCode;
    }

    public void setProductName(String newProductName) {
        this.productName = newProductName;
    }

    public void setProductPrice(float newProductPrice) {
        this.productPrice = newProductPrice;
    }

    public int getProductCode() {
        return this.productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public float getProductPrice() {
        return this.productPrice;
    }
}

