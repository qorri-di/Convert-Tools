package com.qodev.tech.controller.masterdata.user;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.dto.request.searchRequest;
import com.qodev.tech.dto.request.user.registerRequest;
import com.qodev.tech.service.masterdata.user.userService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contools/v1-api/user")
public class userController {
    @Inject
    userService usr;

    @POST
    @Path("/save")
    public GenRespDTO saveController(registerRequest req){
        return usr.save(req);
    }

    @POST
    @Path("/delete")
    public GenRespDTO deleteController(registerRequest req){
        return usr.delete(req);
    }
    @GET
    @Path("/read")
    public GenRespDTO readController(searchRequest req){
        return usr.read(req);
    }
}
