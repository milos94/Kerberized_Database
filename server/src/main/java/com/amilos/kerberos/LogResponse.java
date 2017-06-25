package com.amilos.kerberos;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Milos on 13.06.2017..
 */
public class LogResponse extends Response implements Serializable {

    private byte[] tgt;
    private SecretKey key;
    private byte[] iv;

    public LogResponse(){

    }

    public LogResponse(byte[] tgt, SecretKey key) {
        this.tgt = tgt;
        this.key = key;
    }

    public LogResponse(Status status, byte[] tgt, SecretKey key) {
        super(status);
        this.tgt = tgt;
        this.key = key;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }

    public byte[] getTgt() {
        return tgt;
    }

    public void setTgt(byte[] tgt) {
        this.tgt = tgt;
    }

    public SecretKey getKey() {
        return key;
    }

    public void setKey(SecretKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "LogResponse{" +
                "tgt=" + Arrays.toString(tgt) +
                ", key=" + key +
                ", iv=" + Arrays.toString(iv) +
                '}';
    }
}
