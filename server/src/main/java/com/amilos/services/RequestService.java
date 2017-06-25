package com.amilos.services;

import com.amilos.kerberos.Request;
import com.amilos.kerberos.TGT;
import org.springframework.stereotype.Service;

/**
 * Created by Milos on 15.06.2017..
 */
@Service
public interface RequestService {

    public Request convert(Request request,TGT tgt);
    public TGT getTGT(Request request);

}
