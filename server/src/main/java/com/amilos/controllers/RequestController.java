package com.amilos.controllers;

import com.amilos.kerberos.Request;
import com.amilos.kerberos.TGT;
import com.amilos.services.RequestService;
import com.amilos.services.ResponseService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Milos on 15.06.2017..
 */
@Controller
public class RequestController {

    private ResponseService responseService;

    private RequestService requestService;

    public RequestController(ResponseService responseService, RequestService requestService) {
        this.responseService = responseService;
        this.requestService = requestService;
    }

    @RequestMapping(value = "/getData",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public byte[] getData(@RequestBody Request request){
        TGT tgt = requestService.getTGT(request);
        if(tgt.equals(null)){
            return null;
        }

        Request request1 = requestService.convert(request,tgt);
        if(request1.equals(null)){
            return null;
        }

        try {
            return responseService.generateDataResponse(request1,tgt);
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public byte[] insert(@RequestBody Request request){
        TGT tgt = requestService.getTGT(request);
        if(tgt.equals(null)){
            return null;
        }
        request = requestService.convert(request,tgt);
        if(request.equals(null)){
            return null;
        }
        try {
            return responseService.generateUpdateResponse(request,tgt);
        }catch (Exception e){
            return null;
        }
    }
}
