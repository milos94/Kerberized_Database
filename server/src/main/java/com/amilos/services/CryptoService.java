package com.amilos.services;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * Created by Milos on 12.06.2017..
 */
public interface CryptoService {

    public byte[] encryptTicket(byte[] data) throws Exception;
    public byte[] encryptDatabaseData(byte[] data) throws Exception;
    public byte[] encrypt(byte[] data, String key) throws Exception;
    public byte[] encrypt(byte[] data, SecretKey key, byte[] ivParameterSpec) throws Exception;
    public byte[] decryptTicket(byte[] data) throws Exception;
    public byte[] decryptDatabaseData(byte[] data) throws Exception;
    public byte[] decrypt(byte[] data, String key) throws Exception;
    public byte[] decrypt(byte[] data, SecretKey key, byte[] ivParameterSpec) throws Exception;
    public SecretKey generateKey() throws Exception;
    public byte[] generateIv();
}
