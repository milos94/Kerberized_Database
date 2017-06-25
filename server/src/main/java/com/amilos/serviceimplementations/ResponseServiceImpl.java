package com.amilos.serviceimplementations;

import com.amilos.kerberos.*;
import com.amilos.models.Transaction;
import com.amilos.models.User;
import com.amilos.services.CryptoService;
import com.amilos.services.ResponseService;
import com.amilos.services.SerializationService;
import com.amilos.services.TransactionService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import java.util.Date;
import java.util.List;

/**
 * Created by Milos on 13.06.2017..
 */
@Service
public class ResponseServiceImpl implements ResponseService {

    private CryptoService cryptoService;

    private SerializationService serializationService;

    private TransactionService transactionService;

    public ResponseServiceImpl(CryptoService cryptoService, SerializationService serializationService,
                               TransactionService transactionService) {
        this.cryptoService = cryptoService;
        this.serializationService = serializationService;
        this.transactionService = transactionService;
    }

    @Override
    public byte[] generateLogInResponse(User user) throws Exception {

        LogResponse response = new LogResponse();

        if(user==null){
            response.setStatus(Response.Status.LOGINFAIL);
        }

        else {
            response.setStatus(Response.Status.LOGINSUCC);

            TGT tgt = new TGT();
            tgt.setID(user.getUserId());
            tgt.setSessionKey(cryptoService.generateKey());
            tgt.setIv(cryptoService.generateIv());
            tgt.setTimestamp(new Date());

            response.setKey(tgt.getSessionKey());
            response.setIv(tgt.getIv());
            response.setTgt(cryptoService.encryptTicket(serializationService.serializeTGT(tgt)));
        }

        return cryptoService.encrypt(serializationService.serialize(response),user.getPassword());
    }

    @Override
    public byte[] generateDataResponse(Request request, TGT tgt) throws Exception {

        DataResponse response = new DataResponse();
        response.setStatus(Response.Status.DATA);
        response.setTransactions(transactionService.findAllByUserId(Long.parseLong(request.getID(),10)));
        try {
            return cryptoService.encrypt(serializationService.serialize(response),tgt.getSessionKey(),tgt.getIv());
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public byte[] generateUpdateResponse(Request request, TGT tgt) throws Exception {
        UpdateResponse updateResponse = new UpdateResponse();
        updateResponse.setStatus(Response.Status.UPDATESUCC);
        try {
            String[] data = request.getData().split(" ");
            Transaction transaction = new Transaction(Long.parseLong(request.getID()), data[0], data[1]);
            transaction.setValue(new BASE64Encoder().encode(cryptoService.encryptDatabaseData(transaction.getValue().getBytes())));
            transactionService.insert(transaction);
        }catch (Exception e){
            updateResponse.setStatus(Response.Status.UPDATEFAIL);
        }

        try {
            return cryptoService.encrypt(serializationService.serialize(updateResponse),tgt.getSessionKey(),tgt.getIv());
        }catch (Exception e) {
            return null;
        }
    }
}
