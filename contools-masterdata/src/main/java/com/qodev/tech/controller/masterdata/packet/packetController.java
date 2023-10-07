package com.qodev.tech.controller.masterdata.packet;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.dto.request.defaultRequest;
import com.qodev.tech.dto.request.searchRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contools/v1-api/packet")
public class packetController {

    @POST
    @Path("/save")
    public GenRespDTO saveController(defaultRequest req) {
        return null;
    }

    @POST
    @Path("/delete")
    public GenRespDTO deleteController(defaultRequest req){
        return null;
    }

    @GET
    @Path("/read")
    public GenRespDTO readController(searchRequest req){
        return null;
    }
}
