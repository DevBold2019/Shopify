package com.example.swypepay.Model;

public class outOfStockModel {

    int picture;
    String item_name;
    String stock_status;

    public outOfStockModel(int picture, String item_name, String stock_status) {
        this.picture = picture;
        this.item_name = item_name;
        this.stock_status = stock_status;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }
}
