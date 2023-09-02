package com.qodev.tech.controller.masterdata.mail;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.dto.request.mail.*;
import com.qodev.tech.dto.request.searchRequest;
import com.qodev.tech.service.masterdata.mail.mailTempService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contools/v1-api/mail-temp")
public class mailTempController {
    @Inject
    mailTempService mts;

    @POST
    @Path("/save")
    public GenRespDTO saveUpdate(mailTempRequest req){
        return mts.save(req);
    }

    @POST
    @Path("/delete")
    public GenRespDTO deleteById(mailTempRequest req){
        return mts.delete(req);
    }
    @GET
    @Path("/read")
    public GenRespDTO readAllMethode(searchRequest req){
        return mts.read(req);
    }
}
