package com.amilos.services;

import com.amilos.kerberos.Request;
import com.amilos.kerberos.TGT;
import com.amilos.models.User;

/**
 * Created by Milos on 13.06.2017..
 */
public interface ResponseService {

    public byte[] generateLogInResponse(User user) throws Exception;
    public byte[] generateDataResponse(Request request, TGT tgt) throws Exception;
    public byte[] generateUpdateResponse(Request request, TGT tgt) throws Exception;
}
