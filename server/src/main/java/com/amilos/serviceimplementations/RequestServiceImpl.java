package com.amilos.serviceimplementations;

import com.amilos.kerberos.Request;
import com.amilos.kerberos.TGT;
import com.amilos.services.CryptoService;
import com.amilos.services.RequestService;
import com.amilos.services.SerializationService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

/**
 * Created by Milos on 15.06.2017..
 */
@Service
public class RequestServiceImpl implements RequestService {

    private SerializationService serializationService;

    private CryptoService cryptoService;

    public RequestServiceImpl(SerializationService serializationService, CryptoService cryptoService) {
        this.serializationService = serializationService;
        this.cryptoService = cryptoService;
    }

    @Override
    public Request convert(Request request,TGT tgt) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            request.setID(new String(cryptoService.decrypt(decoder.decodeBuffer(request.getID()),tgt.getSessionKey(),tgt.getIv())));
            if(request.getData() != null) {
                request.setData(new String(cryptoService.decrypt(decoder.decodeBuffer(request.getData()), tgt.getSessionKey(), tgt.getIv())));
            }
            if((tgt.getID()) != Long.parseLong(request.getID())){
                return  null;
            }
        }catch (Exception e){
            return null;
        }
        return  request;
    }

    @Override
    public TGT getTGT(Request request) {
        try {
            return serializationService.deserializeTGT(cryptoService.decryptTicket(request.getTgt()));
        }catch (Exception e) {
            return null;
        }
    }


}
