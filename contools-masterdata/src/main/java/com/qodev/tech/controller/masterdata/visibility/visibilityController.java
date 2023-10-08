package com.qodev.tech.controller.masterdata.visibility;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.dto.request.*;
import com.qodev.tech.service.masterdata.visibility.visibilityService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contools/v1-api/visibility")
public class visibilityController {

    @Inject
    visibilityService vs;

    @POST
    @Path("/save")
    public GenRespDTO saveController(defaultRequest req) {
        return vs.save(req);
    }

    @POST
    @Path("/delete")
    public GenRespDTO deleteController(defaultRequest req){
        return vs.delete(req);
    }

    @GET
    @Path("/read")
    public GenRespDTO readController(searchRequest req){
        return vs.read(req);
    }
}
