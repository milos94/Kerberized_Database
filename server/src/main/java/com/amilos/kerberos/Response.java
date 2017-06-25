package com.amilos.kerberos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Milos on 12.06.2017..
 */
public abstract class Response implements Serializable {

    public enum Status{LOGINSUCC,LOGINFAIL,LOGINBLOCKED,DATA,UPDATESUCC,UPDATEFAIL,DELETESUCC,DELETEFAIL,OTHER}

    private Status status;

    public Response(){

    }

    public Response(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
