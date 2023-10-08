package com.qodev.tech.controller.masterdata.role;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.dto.request.*;
import com.qodev.tech.service.masterdata.role.roleService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contools/v1-api/role")
public class roleController {
    @Inject
    roleService rls;

    @POST
    @Path("/save")
    public GenRespDTO saveController(defaultRequest req) {
        return rls.save(req);
    }

    @POST
    @Path("/delete")
    public GenRespDTO deleteController(defaultRequest req){
        return rls.delete(req);
    }

    @GET
    @Path("/read")
    public GenRespDTO readController(searchRequest req){
        return rls.read(req);
    }
}
