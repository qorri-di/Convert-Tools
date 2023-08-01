package com.qodev.tech.controller;

import com.qodev.tech.dto.GeneralResponse;
import com.qodev.tech.dto.empSave.EmpSaveRequestDto;
import com.qodev.tech.service.EmployeeService;
import io.smallrye.common.annotation.Blocking;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/minilab/employee")
public class Minilab2Controller {

    @Inject
    EmployeeService employeeService;

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public Response helloPost(EmpSaveRequestDto request) {
        GeneralResponse response=employeeService.employeeSaveService(request);
        JsonObject jsonResponse=JsonObject.mapFrom(response);
        return Response.ok(jsonResponse).build();
    }
}