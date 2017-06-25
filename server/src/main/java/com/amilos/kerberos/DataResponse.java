package com.amilos.kerberos;

import com.amilos.models.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Milos on 13.06.2017..
 */
public class DataResponse extends Response implements Serializable {

    List<Transaction> transactions;

    public DataResponse(){

    }

    public DataResponse(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "transactions=" + transactions +
                '}';
    }
}
