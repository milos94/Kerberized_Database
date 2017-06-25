package com.amilos.serviceimplementations;

import com.amilos.services.CryptoService;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.Security;

/**
 * Created by Milos on 12.06.2017..
 */
@Service
public class CryptoServiceImpl implements CryptoService {

    private SecretKeySpec databaseKey,ticketKey;
    private IvParameterSpec databaseIv, ticketIv;
    private Cipher cipher,databaseCipher,ticketCipher;
    private KeyGenerator keyGenerator;


    public CryptoServiceImpl(){
        try {
            Security.addProvider(new BouncyCastleProvider());
            databaseCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ticketCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            byte[] keyBytes = Files.readAllBytes(Paths.get("ticket.key"));
            ticketKey = new SecretKeySpec(keyBytes,"AES");

            keyBytes = Files.readAllBytes(Paths.get("database.key"));
            databaseKey = new SecretKeySpec(keyBytes,"AES");

            byte[] iv = Files.readAllBytes(Paths.get("database.iv"));
            databaseIv = new IvParameterSpec(iv);

            iv = Files.readAllBytes(Paths.get("ticket.iv"));
            ticketIv = new IvParameterSpec(iv);

            keyGenerator = KeyGenerator.getInstance("AES");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public byte[] encryptTicket(byte[] data) throws Exception {
        ticketCipher.init(Cipher.ENCRYPT_MODE,ticketKey,ticketIv);
        return ticketCipher.doFinal(data);
    }

    @Override
    public byte[] encryptDatabaseData(byte[] data) throws Exception {
        databaseCipher.init(Cipher.ENCRYPT_MODE,databaseKey,databaseIv);
        return databaseCipher.doFinal(data);
    }

    @Override
    public byte[] encrypt(byte[] data, String key) throws Exception {
        cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec= new SecretKeySpec(new BASE64Decoder().decodeBuffer(key),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        return cipher.doFinal(data);
    }

    @Override
    public byte[] encrypt(byte[] data, SecretKey key, byte[] ivParameterSpec) throws Exception {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key, new IvParameterSpec(ivParameterSpec));
        return cipher.doFinal(data);
    }

    @Override
    public byte[] decryptTicket(byte[] data) throws Exception {
        ticketCipher.init(Cipher.DECRYPT_MODE,ticketKey,ticketIv);
        return ticketCipher.doFinal(data);
    }

    @Override
    public byte[] decryptDatabaseData(byte[] data) throws Exception {
        databaseCipher.init(Cipher.DECRYPT_MODE,databaseKey,databaseIv);
        return databaseCipher.doFinal(data);
    }

    @Override
    public byte[] decrypt(byte[] data, String key) throws Exception {
        cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec= new SecretKeySpec(new BASE64Decoder().decodeBuffer(key),"AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        return cipher.doFinal(data);
    }

    @Override
    public byte[] decrypt(byte[] data, SecretKey key, byte[] ivParameterSpec) throws Exception {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,key,new IvParameterSpec(ivParameterSpec));
        return cipher.doFinal(data);
    }

    @Override
    public SecretKey generateKey() throws Exception {
        return keyGenerator.generateKey();
    }

    @Override
    public byte[] generateIv() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[16];
        secureRandom.nextBytes(iv);
        return iv;
    }

}
