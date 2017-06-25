package com.amilos.serviceimplementations;

import com.amilos.kerberos.Request;
import com.amilos.kerberos.Response;
import com.amilos.kerberos.TGT;
import com.amilos.services.SerializationService;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by Milos on 12.06.2017..
 */
@Service
public class SerializationServiceImpl implements SerializationService {

    @Override
    public byte[] serialize(Response response) throws IOException {
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutput.writeObject(response);
            return byteArrayOutputStream.toByteArray();
        }
    }

    @Override
    public String deserialize(byte[] request) throws Exception {
        try(ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(request);
            ObjectInput input = new ObjectInputStream(byteArrayInputStream)) {
            return (String) input.readObject();
        }
    }

    @Override
    public byte[] serializeTGT(TGT tgt) throws IOException {
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutput.writeObject(tgt);
            return byteArrayOutputStream.toByteArray();
        }
    }

    @Override
    public TGT deserializeTGT(byte[] tgt) throws Exception {
        try(ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(tgt);
            ObjectInput input = new ObjectInputStream(byteArrayInputStream)) {
            return (TGT) input.readObject();
        }
    }

}
