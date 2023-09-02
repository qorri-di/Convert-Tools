package com.qodev.tech.common.helpers.logging;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ddms/api/logging")
@RegisterRestClient(configKey = "eksad-api-blLog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface LogServiceApi {

    @POST
    @Path("/bussiness/save")
    String bussinessSave(LoggingRequestDto request);

}

