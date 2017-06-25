package com.amilos.models;


import java.io.Serializable;

/**
 * Created by Milos on 14.06.2017..
 */

public class Transaction implements Serializable {

    private Long transactionId;

    private Long userId;

    private String value;

    private String type;

    public Transaction(){

    }

    public Transaction(Long userId, String value, String type) {
        this.userId = userId;
        this.value = value;
        this.type = type;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String isType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return transactionId+" "+userId+" "+value+" "+type;
    }
}
