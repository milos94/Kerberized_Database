package com.amilos.kerberos;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Milos on 12.06.2017..
 */
public class Request implements Serializable {

    private byte[] tgt;
    private String ID;
    private String data;

    public Request(){

    }

    public Request(String data, String ID, byte[] tgt) {
        this.data = data;
        this.ID = ID;
        this.tgt = tgt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public byte[] getTgt() {
        return tgt;
    }

    public void setTgt(byte[] tgt) {
        this.tgt = tgt;
    }

    @Override
    public String toString() {
        return "Request{" +
                "tgt=" + Arrays.toString(tgt) +
                ", ID='" + ID + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
