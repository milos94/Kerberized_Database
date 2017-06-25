package com.amilos.services;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Milos on 12.06.2017..
 */
@Service
public class CryptoServiceImpl {


    private Cipher cipher;
    private SecretKey key;
    private IvParameterSpec iv;

    public CryptoServiceImpl(){

        try {
            cipher = Cipher.getInstance("AES");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public SecretKey getKey() {
        return key;
    }

    public void setKey(SecretKey key) {
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }catch (Exception e){
            e.printStackTrace();
        }
        this.key = key;
    }

    public IvParameterSpec getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = new IvParameterSpec(iv);
    }

    public byte[] encrypt(byte[] data, String key) throws Exception {
        SecretKeySpec secretKeySpec= new SecretKeySpec(new BASE64Decoder().decodeBuffer(key),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        return cipher.doFinal(data);
    }

    public byte[] decrypt(byte[] data, String key) throws Exception {
        SecretKeySpec secretKeySpec= new SecretKeySpec(new BASE64Decoder().decodeBuffer(key),"AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        return cipher.doFinal(data);
    }

    public byte[] encrypt(byte[] data){
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            return cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public byte[] decrypt(byte[] data){
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            return cipher.doFinal(data);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
