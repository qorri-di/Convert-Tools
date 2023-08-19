package com.qodev.tech.service.masterdata.role;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.common.helpers.GlobalFunction;
import com.qodev.tech.domain.masterdata.role;
import com.qodev.tech.dto.request.role.roleRequest;
import com.qodev.tech.dto.request.searchRequest;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.*;

@ApplicationScoped
@Transactional
public class roleService extends GlobalFunction {

    public GenRespDTO save(roleRequest req) throws ParseException {
        if (req.getIdRole() == null) {
            return create(req);
        } else {
            return update(req);
        }
    }

    private GenRespDTO create(roleRequest req) throws ParseException {
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ create ]]-------------------- createRole: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        Optional<role> roleData = role.find("nameRole=?1",req.getNameRole()).firstResultOptional();
        if (!roleData.isPresent()){

            role data = new role();
            data.setRoleId(genRoleId());
            data.setNameRole(req.getNameRole());
            data.setCreatedAt(new Date());
            data.setCreatedBy(1);
            data.setStatusRole(1);

            data.persist();

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ create ]]-------------------- createRole: RESULT [[ %s ]] --------------------", JsonObject.mapFrom(data).encodePrettily()));
            System.out.println(String.format("[[ create ]]-------------------- createRole: END %s ms --------------------", (stop - start)));
            return response.successResponse("Role data saved successfully");
        } else {
            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ create ]]-------------------- createRole: ERROR [[ %s ]] --------------------",req.getNameRole()));
            System.out.println(String.format("[[ create ]]-------------------- createRole: END %s ms --------------------", (stop - start)));
            return response.successResponse("Data already exits in database");
        }
    }

    public GenRespDTO read(searchRequest req){
        GenRespDTO response = new GenRespDTO();
        if (req == null) {
            return response.noDataFoundResponse("Please page and size cannot be empty");
        } else if (req.getId() == null && req.getSearch() == null && req.getCategory() == null) {
            return getAll(req);
        } else if (req.getId() != null) {
            return getById(req);
        }else if (req.getSearch() != null) {
            return getBySearch(req);
        }
        return response.noDataFoundResponse("Data not found in search");
    }

    private GenRespDTO getAll(searchRequest req){
        return null;
    }

    private GenRespDTO getById(searchRequest req){
        return null;
    }

    private GenRespDTO getBySearch(searchRequest req){
        return null;
    }

    private GenRespDTO update(roleRequest req) {
        return null;
    }

    public GenRespDTO delete(roleRequest req){
        return null;
    }
}
