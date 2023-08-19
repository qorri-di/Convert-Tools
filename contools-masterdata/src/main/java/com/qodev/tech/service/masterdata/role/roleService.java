package com.qodev.tech.service.masterdata.role;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.common.helpers.GlobalFunction;
import com.qodev.tech.domain.masterdata.mailTemp;
import com.qodev.tech.domain.masterdata.role;
import com.qodev.tech.dto.request.role.roleRequest;
import com.qodev.tech.dto.request.searchRequest;
import com.qodev.tech.dto.response.mail.mailTempSearchResponse;
import com.qodev.tech.dto.response.role.roleSearchResponse;
import io.quarkus.panache.common.Sort;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
@Transactional
public class roleService extends GlobalFunction {

    public GenRespDTO save(roleRequest req){
        if (req.getIdRole() == null) {
            return create(req);
        } else {
            return update(req);
        }
    }

    private GenRespDTO create(roleRequest req){
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
        if (req == null || (req.getId() == null && req.getCategory() == null && req.getSearch() == null && req.getSize() == null && req.getPage() == null)) {
            return response.errorResponse(204,"Please page and size cannot be empty");
        } else if (req.getId() == null && req.getSearch() == null && req.getCategory() == null) {
            return getAll(req);
        } else if ((req.getSearch() == null && req.getCategory() == null)
                || (req.getId() != null && req.getSize() != null && req.getPage() != null)) {
            return getById(req);
        } else if ((req.getId() == null && req.getSearch() == null )
                || ((req.getCategory() != null || !isSymbol(req.getCategory())) && req.getSize() != null && req.getPage() != null)) {            req.setCategory(null);
            return getAll(req);
        }else if ((req.getId() == null && req.getCategory() == null)
                || (req.getSearch() != null && req.getSize() != null && req.getPage() != null)) {
            if (!isSymbol(req.getSearch())){
                req.setSearch(null);
                return getAll(req);
            }
            return getBySearch(req);
        }
        return response.errorResponse(204,"Data not found in search");
    }

    private GenRespDTO getAll(searchRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ getAll ]]-------------------- getAllRole: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        List<role> roleList = role.find("statusRole=1", Sort.ascending("roleId")).page(req.getPage(), req.getSize()).list();
        int totalPage = role.find("statusRole=1",Sort.ascending("roleId")).page(req.getPage(), req.getSize()).pageCount();
        int totalData = (int) role.find("statusRole=1").count();

        roleSearchResponse respons = new roleSearchResponse();
        respons.setSearch(roleList);
        respons.setPage(req.getPage());
        respons.setSize(req.getSize());
        respons.setTotalPage(totalPage);
        respons.setTotalData(totalData);

        long stop = System.currentTimeMillis();
        System.out.println(String.format("[[ getAll ]]-------------------- getAllRole: RESULT [[ page %s : %s, size %s, data %s ]] --------------------",req.getPage(),totalPage,req.getSize(),totalData));
        System.out.println(String.format("[[ getAll ]]-------------------- getAllRole: END %s ms --------------------", (stop - start)));
        return response.successResponse(respons,"Data successfully get all");
    }

    private GenRespDTO getById(searchRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ getById ]]-------------------- getByIdRole: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        Optional<role> rolData = role.find("roleId=?1",req.getId()).singleResultOptional();

        if (rolData.isPresent()) {
            role roleData = role.findById(req.getId());

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ getById ]]-------------------- getByIdRole: RESULT [[ %s ]] --------------------", JsonObject.mapFrom(rolData).encodePrettily()));
            System.out.println(String.format("[[ getById ]]-------------------- getByIdRole: END %s ms --------------------", (stop - start)));
            return response.successResponse(roleData, "Data successfully get by id");
        } else {
            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ getById ]]-------------------- getByIdRole: ERROR [[ %s ]] --------------------",req.getId()));
            System.out.println(String.format("[[ getById ]]-------------------- getByIdRole: END %s ms --------------------", (stop - start)));
            return response.errorResponse(204, "Data not Found");
        }
    }

    private GenRespDTO getBySearch(searchRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ getBySearch ]]-------------------- getBySearch: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        List<role> roleList = role.find("lower(nameRole) like ?1", Sort.ascending("roleId"),"%"+req.getSearch().toLowerCase()+"%").page(req.getPage(),req.getSize()).list();
        int totalPage = role.find("lower(nameRole) like ?1", Sort.ascending("roleId"),"%"+req.getSearch().toLowerCase()+"%").page(req.getPage(),req.getSize()).pageCount();
        int totalData = (int) role.find("lower(nameRole) like ?1", Sort.ascending("roleId"),"%"+req.getSearch().toLowerCase()+"%").count();

        roleSearchResponse respons = new roleSearchResponse();
        respons.setSearch(roleList);
        respons.setPage(req.getPage());
        respons.setSize(req.getSize());
        respons.setTotalPage(totalPage);
        respons.setTotalData(totalData);

        long stop = System.currentTimeMillis();
        System.out.println(String.format("[[ getBySearch ]]-------------------- getBySearch: RESULT [[ page %s : %s, size %s, data %s ]] --------------------",req.getPage(),totalPage,req.getSize(),totalData));
        System.out.println(String.format("[[ getBySearch ]]-------------------- getBySearch: END %s ms --------------------", (stop - start)));
        return response.successResponse(respons,"Data successfully get by search");    }

    private GenRespDTO update(roleRequest req) {
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ update ]]-------------------- updateRole: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        role rol = role.findById(req.getIdRole());
        if (rol.isPersistent()){

            rol.setRoleId(rol.getRoleId());

            if (req.getNameRole() == null) {
                rol.setNameRole(rol.getNameRole());
            } else {
                rol.setNameRole(req.getNameRole());
            }

            rol.setStatusRole(rol.getStatusRole());
            rol.setCreatedAt(rol.getCreatedAt());
            rol.setCreatedBy(rol.getCreatedBy());
            rol.setUpdatedAt(new Date());
            rol.setUpdatedBy(1);

            rol.persist();

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ update ]]-------------------- updateRole: RESULT [[ %s ]] --------------------","Temporary mail data updated successfully"));
            System.out.println(String.format("[[ update ]]-------------------- updateRole: END %s ms --------------------", (stop - start)));
            return response.successResponse("Role data updated successfully");
        } else {

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ update ]]-------------------- updateRole: ERROR [[ %s ]] --------------------","Data cannot updated"));
            System.out.println(String.format("[[ update ]]-------------------- updateRole: END %s ms --------------------", (stop - start)));
            return response.errorResponse(204,"Data cannot updated");
        }
    }

    public GenRespDTO delete(roleRequest req) {
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ delete ]]-------------------- deleteRole: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        role rol = role.findById(req.getIdRole());
        if (rol.isPersistent()) {
            rol.setRoleId(rol.getRoleId());

            if (req.getNameRole() != null) {
                rol.setNameRole(req.getNameRole());
            } else {
                rol.setNameRole(rol.getNameRole());
            }

            rol.setStatusRole(0);
            rol.setCreatedAt(rol.getCreatedAt());
            rol.setCreatedBy(rol.getCreatedBy());
            rol.setUpdatedAt(new Date());
            rol.setUpdatedBy(1);

            rol.persist();

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ delete ]]-------------------- deleteRole: RESULT [[ %s ]] --------------------", req.getIdRole()));
            System.out.println(String.format("[[ delete ]]-------------------- deleteRole: END %s ms --------------------", (stop - start)));
            return response.successResponse("Temporary mail data deleted successfully");
        } else {

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ delete ]]-------------------- deleteRole: ERROR [[ %s ]] --------------------", "Data cannot deleted"));
            System.out.println(String.format("[[ delete ]]-------------------- deleteRole: END %s ms --------------------", (stop - start)));
            return response.errorResponse(204, "Data cannot deleted");
        }
    }
}
