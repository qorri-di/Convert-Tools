package com.qodev.tech.controller;

import com.qodev.tech.dto.GeneralResponse;
import com.qodev.tech.dto.hello.HelloRequestDto;
import com.qodev.tech.service.HelloService;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/minilab/sample")
public class Minilab1Controller {

    @Inject
    HelloService helloService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello EKSAD's Lovers ";
    }

    @POST
    @Path("/hello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloPost(HelloRequestDto request) {
        GeneralResponse response=helloService.helloService(request);
        JsonObject jsonResponse=JsonObject.mapFrom(response);
        return Response.ok(jsonResponse).build();
    }
}