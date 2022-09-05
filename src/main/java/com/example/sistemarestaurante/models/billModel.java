package com.example.sistemarestaurante.models;

import javax.persistence.Entity;
import javax.persistence.Table;

public class billModel {
    private int n = 0;
    private int k = 0;
    private int code;
    private double totalPrice;
    private final String[] productsName = new String[n];
    private final int[] productsCode = new int[k];
    private waiterModel MyWaiter;

    public billModel(double newTotalPrice, int NewCode, waiterModel newWaiter, String NewProductsName, int NewProductCode) {
        this.productsCode[n] = NewProductCode;
        this.productsName[n] = NewProductsName;
        this.MyWaiter = newWaiter;
        this.totalPrice = newTotalPrice;
        this.code = NewCode;
    }

    public billModel() {

    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setProductPrice(double newProductPrice) {
        this.totalPrice = newProductPrice;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int NewCode) {
        this.code = NewCode;
    }

    public waiterModel getWaiter(){
        return this.MyWaiter;
    }

    public void setWaiter(waiterModel newWaiter ){
        this.MyWaiter = newWaiter;
    }

    public String getProductName(int x){
        if(x<=n)
            return this.productsName[x];
        return null;
    }

    public void setProductName(String newProductName){
        this.productsName[n] = newProductName;
        n++;
    }

    public int getProductCode(int x){
        if(x<=k)
            return this.productsCode[x];
        return 0;
    }

    public void setProductCode(int NewCode){
        this.productsCode[k] = NewCode;
        k++;
    }




}
