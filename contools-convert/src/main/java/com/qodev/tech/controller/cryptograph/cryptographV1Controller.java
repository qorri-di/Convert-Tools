//package com.qodev.tech.controller.cryptograph;
//
//import com.qodev.tech.common.GenericResponseDTO;
//import com.qodev.tech.dto.request.encodeRequest;
//import com.qodev.tech.service.cryptograph.*;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//@Path("/contools/v1-api/cryptography/encode")
//public class cryptographV1Controller {
//
//    @Inject
//    baseService baseService;
//
//    @Inject
//    mdService mdService;
//
//    @Inject
//    ntlmService ntlmService;
//
//    @Inject
//    shaService shaService;
//
//    @POST
//    @Path("/base")
//    public GenericResponseDTO encodeBase(encodeRequest req){
//        return null;
//    }
//
//    @POST
//    @Path("/md")
//    public GenericResponseDTO encodeMd(encodeRequest req){
//        return null;
//    }
//
//    @POST
//    @Path("/ntlm")
//    public GenericResponseDTO encodeNtlm(encodeRequest req){
//        return null;
//    }
//
//    @POST
//    @Path("/sha")
//    public GenericResponseDTO encodeSha(encodeRequest req){
//        return null;
//    }
//
//}
