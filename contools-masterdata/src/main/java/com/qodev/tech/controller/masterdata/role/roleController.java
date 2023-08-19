package com.qodev.tech.controller.masterdata.role;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.dto.request.role.roleRequest;
import com.qodev.tech.dto.request.searchRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contools/v1-api/role")
public class roleController {

    @POST
    @Path("/save")
    public GenRespDTO saveController(roleRequest req){
        return null;
    }

    @POST
    @Path("/delete")
    public GenRespDTO deleteController(roleRequest req){
        return null;
    }
    @GET
    @Path("/read")
    public GenRespDTO readController(searchRequest req){
        return null;
    }
}
