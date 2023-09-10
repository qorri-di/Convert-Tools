package com.qodev.tech.service.masterdata.mail;

import com.qodev.tech.common.GenRespDTO;
import com.qodev.tech.common.helpers.GlobalFunction;
import com.qodev.tech.domain.masterdata.mailTemp;
import com.qodev.tech.dto.request.mail.*;
import com.qodev.tech.dto.request.searchRequest;
import com.qodev.tech.dto.response.mail.mailTempSearchResponse;
import io.quarkus.panache.common.Sort;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
@Transactional
public class mailTempService extends GlobalFunction {

    public GenRespDTO save(mailTempRequest req){
        if (req.getMailTempId() == null) {
            return create(req);
        } else {
            return update(req);
        }
    }

    private GenRespDTO create(mailTempRequest req) {
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ create ]]-------------------- MailTempList: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        Optional<mailTemp> check = mailTemp.find("mailTempName = ?1 and mailTempDomain = ?2", req.getMailTempName(), req.getMailTempDomain()).firstResultOptional();
        if (!check.isPresent()) {
            mailTemp data = new mailTemp();
            data.setMailTempId(genMailTempId());
            data.setMailTempName(req.getMailTempName());
            data.setMailTempDomain(req.getMailTempDomain());
            data.setMailTempStatus(1);
            data.setCreatedAt(new Date());
            data.setCreatedBy("1");

            data.persist();

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ create ]]-------------------- MailTempList: RESULT [[ %s ]] --------------------", JsonObject.mapFrom(data).encodePrettily()));
            System.out.println(String.format("[[ create ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.successResponse("Temporary mail data saved successfully");
        } else {
            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ create ]]-------------------- MailTempList: ERROR [[ %s ]] --------------------", JsonObject.mapFrom(req).encodePrettily()));
            System.out.println(String.format("[[ create ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.successResponse("Data already exits in database");
        }
    }

    public GenRespDTO read(searchRequest req){
        GenRespDTO response = new GenRespDTO();
        if (req == null || (req.getId() == null && req.getCategory() == null
                && req.getSearch() == null && req.getSize() == null && req.getPage() == null)) {
            return response.errorResponse(204,"Please page and size cannot be empty");
        } else if (req.getId() == null && req.getSearch() == null && req.getCategory() == null) {
            return getAll(req);
        } else if ((req.getSearch() == null && req.getCategory() == null)
                || (req.getId() != null && req.getSize() != null && req.getPage() != null)) {
            return getById(req);
        } else if ((req.getId() == null && req.getSearch() == null )
                || (req.getCategory() != null && req.getSize() != null && req.getPage() != null)) {
            if (req.getCategory().equalsIgnoreCase("all category") || !isSymbol(req.getCategory())) {
                req.setCategory(null);
                return getAll(req);
            }
            return getByKategory(req);
        } else if ((req.getId() == null && req.getCategory() == null)
                || (req.getSearch() != null && req.getSize() != null && req.getPage() != null)) {
            if (!isSymbol(req.getSearch())){
                req.setSearch(null);
                return getAll(req);
            }
            return getBySearch(req);
        }
        return response.noDataFoundResponse("Data not found in search");
    }

    private GenRespDTO getAll(searchRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ getAll ]]-------------------- MailTempList: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        List<mailTemp> tempList = mailTemp.find("mailTempStatus=1",Sort.ascending("mailTempId")).page(req.getPage(), req.getSize()).list();
        int totalPage = mailTemp.find("mailTempStatus=1",Sort.ascending("mailTempId")).page(req.getPage(), req.getSize()).pageCount();
        int totalData = (int) mailTemp.find("mailTempStatus=1").count();

        mailTempSearchResponse respons = new mailTempSearchResponse();
        respons.setSearch(tempList);
        respons.setPage(req.getPage());
        respons.setSize(req.getSize());
        respons.setTotalPage(totalPage);
        respons.setTotalData(totalData);

        long stop = System.currentTimeMillis();
        System.out.println(String.format("[[ getAll ]]-------------------- MailTempList: RESULT [[ page %s : %s, size %s, data %s ]] --------------------",req.getPage(),totalPage,req.getSize(),totalData));
        System.out.println(String.format("[[ getAll ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
        return response.successResponse(respons,"Data successfully get all");
    }

    private GenRespDTO getById(searchRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ getById ]]-------------------- MailTempList: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        Optional<mailTemp> tempList = mailTemp.find("mailTempId =?1",req.getId()).singleResultOptional();

        if (tempList.isPresent()) {
            mailTemp temp = mailTemp.find("mailTempId =?1",req.getId()).singleResult();

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ getById ]]-------------------- MailTempList: RESULT [[ %s ]] --------------------", JsonObject.mapFrom(tempList).encodePrettily()));
            System.out.println(String.format("[[ getById ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.successResponse(temp, "Data successfully get by id");
        } else {
            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ getById ]]-------------------- MailTempList: ERROR [[ %s ]] --------------------",req.getId()));
            System.out.println(String.format("[[ getById ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.errorResponse(204, "Data Not Found");
        }
    }

    private GenRespDTO getByKategory(searchRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ getByKategory ]]-------------------- MailTempList: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        List<mailTemp> tempList = mailTemp.find("mailTempDomain in (?1)", Sort.ascending("mailTempId"),req.getCategory()).page(req.getPage(), req.getSize()).list();
        int totalPage = mailTemp.find("mailTempDomain in (?1)", Sort.ascending("mailTempId"),req.getCategory()).page(req.getPage(), req.getSize()).pageCount();
        int totalData = (int) mailTemp.find("mailTempDomain in (?1)", Sort.ascending("mailTempId"),req.getCategory()).count();

        mailTempSearchResponse respons = new mailTempSearchResponse();
        respons.setSearch(tempList);
        respons.setPage(req.getPage());
        respons.setSize(req.getSize());
        respons.setTotalPage(totalPage);
        respons.setTotalData(totalData);

        long stop = System.currentTimeMillis();
        System.out.println(String.format("[[ getByKategory ]]-------------------- MailTempList: RESULT [[ page %s : %s, size %s, data %s ]] --------------------",req.getPage(),totalPage,req.getSize(),totalData));
        System.out.println(String.format("[[ getByKategory ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
        return response.successResponse(respons,"Data successfully get by category");
    }

    private GenRespDTO getBySearch(searchRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ getBySearch ]]-------------------- MailTempList: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        List<mailTemp> tempList = mailTemp.find("lower(mailTempName) like ?1", Sort.ascending("mailTempId"),"%"+req.getSearch().toLowerCase()+"%").page(req.getPage(),req.getSize()).list();
        int totalPage = mailTemp.find("lower(mailTempName) like ?1", Sort.ascending("mailTempId"),"%"+req.getSearch().toLowerCase()+"%").page(req.getPage(),req.getSize()).pageCount();
        int totalData = (int) mailTemp.find("lower(mailTempName) like ?1", Sort.ascending("mailTempId"),"%"+req.getSearch().toLowerCase()+"%").count();

        mailTempSearchResponse respons = new mailTempSearchResponse();
        respons.setSearch(tempList);
        respons.setPage(req.getPage());
        respons.setSize(req.getSize());
        respons.setTotalPage(totalPage);
        respons.setTotalData(totalData);

        long stop = System.currentTimeMillis();
        System.out.println(String.format("[[ getBySearch ]]-------------------- MailTempList: RESULT [[ page %s : %s, size %s, data %s ]] --------------------",req.getPage(),totalPage,req.getSize(),totalData));
        System.out.println(String.format("[[ getBySearch ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
        return response.successResponse(respons,"Data successfully get by search");
    }

    private GenRespDTO update(mailTempRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ update ]]-------------------- MailTempList: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        mailTemp tempList = mailTemp.findById(req.getMailTempId());
        if (tempList.isPersistent()){

            tempList.setMailTempId(tempList.getMailTempId());

            if (req.getMailTempName() != null) {
                tempList.setMailTempName(req.getMailTempName());
            } else {
                tempList.setMailTempName(tempList.getMailTempName());
            }

            if (req.getMailTempName() != null) {
                tempList.setMailTempDomain(req.getMailTempDomain());
            } else {
                tempList.setMailTempDomain(tempList.getMailTempDomain());
            }

            tempList.setCreatedAt(tempList.getCreatedAt());
            tempList.setCreatedBy(tempList.getCreatedBy());

            if (tempList.getMailTempStatus().equals(0)){
                tempList.setMailTempStatus(1);
            }

            tempList.setMailTempStatus(tempList.getMailTempStatus());
            tempList.setUpdatedAt(new Date());
            tempList.setUpdatedBy("1");

            tempList.persist();


            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ update ]]-------------------- MailTempList: RESULT [[ %s ]] --------------------","Temporary mail data updated successfully"));
            System.out.println(String.format("[[ update ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.successResponse("Temporary mail data updated successfully");
        } else {

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ update ]]-------------------- MailTempList: ERROR [[ %s ]] --------------------","Data cannot updated"));
            System.out.println(String.format("[[ update ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.errorResponse(204,"Data cannot updated");
        }
    }

    public GenRespDTO delete(mailTempRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ delete ]]-------------------- MailTempList: START --------------------"));

        GenRespDTO response = new GenRespDTO();
        mailTemp tempList = mailTemp.findById(req.getMailTempId());
        if (tempList.isPersistent()){
            tempList.setMailTempId(tempList.getMailTempId());

            if (req.getMailTempName() != null) {
                tempList.setMailTempName(req.getMailTempName());
            } else {
                tempList.setMailTempName(tempList.getMailTempName());
            }

            if (req.getMailTempDomain() != null) {
                tempList.setMailTempDomain(req.getMailTempDomain());
            } else {
                tempList.setMailTempDomain(tempList.getMailTempDomain());
            }

            tempList.setCreatedAt(tempList.getCreatedAt());
            tempList.setCreatedBy(tempList.getCreatedBy());
            tempList.setMailTempStatus(0);

            tempList.persist();


            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ delete ]]-------------------- MailTempList: RESULT [[ %s ]] --------------------",req.getMailTempId()));
            System.out.println(String.format("[[ delete ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.successResponse("Temporary mail data deleted successfully");
        } else {

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ delete ]]-------------------- MailTempList: ERROR [[ %s ]] --------------------","Data cannot deleted"));
            System.out.println(String.format("[[ delete ]]-------------------- MailTempList: END %s ms --------------------", (stop - start)));
            return response.errorResponse(204,"Data cannot deleted");
        }
    }
}
