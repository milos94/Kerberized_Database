package com.amilos.kerberos;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Milos on 12.06.2017..
 */
public class TGT implements Serializable {

    private SecretKey sessionKey;
    private long ID;
    private Date timestamp;
    private byte[] iv;

    public TGT(){

    }

    public TGT(SecretKey sessionKey, long  ID, Date timestamp) {
        this.sessionKey = sessionKey;
        this.ID = ID;
        this.timestamp = timestamp;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }

    public SecretKey getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(SecretKey sessionKey) {
        this.sessionKey = sessionKey;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TGT{" +
                "sessionKey=" + sessionKey +
                ", ID=" + ID +
                ", timestamp=" + timestamp +
                ", iv=" + Arrays.toString(iv) +
                '}';
    }
}
