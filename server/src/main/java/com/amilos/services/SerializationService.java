package com.amilos.services;

import com.amilos.kerberos.Request;
import com.amilos.kerberos.Response;
import com.amilos.kerberos.TGT;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Milos on 12.06.2017..
 */
public interface SerializationService {

    public byte[] serialize(Response response) throws IOException;
    public String deserialize(byte[] request) throws Exception;
    public byte[] serializeTGT(TGT tgt) throws IOException;
    public TGT deserializeTGT(byte[] tgt) throws Exception;
}
