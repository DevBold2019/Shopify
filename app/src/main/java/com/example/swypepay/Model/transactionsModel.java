package com.example.swypepay.Model;

public class transactionsModel {

    String amount;
    String description;
    String transaction_status;
    String date;
    String title;
    String color;


    public transactionsModel(String amount, String description, String transaction_status, String date, String title, String color) {
        this.amount = amount;
        this.description = description;
        this.transaction_status = transaction_status;
        this.date = date;
        this.title = title;
        this.color = color;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransaction_status() {
        return transaction_status;
    }

    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}