package com.amilos.services;

import com.amilos.kerberos.Response;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by Milos on 12.06.2017..
 */
@Service
public class SerializationServiceImpl {


    public byte[] serialize(Response response) throws IOException {
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutput.writeObject(response);
            return byteArrayOutputStream.toByteArray();
        }
    }


    public Response deserializeResponse(byte[] tgt) throws Exception {
        try(ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(tgt);
            ObjectInput input = new ObjectInputStream(byteArrayInputStream)) {
            return (Response) input.readObject();
        }
    }

}
