package com.qodev.tech.service;

import com.qodev.tech.domain.MasterEmployee;
import com.qodev.tech.dto.GeneralResponse;
import com.qodev.tech.dto.empSave.EmpSaveRequestDto;
import com.qodev.tech.dto.empSave.EmpSaveResponseDto;
import io.vertx.core.json.JsonObject;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class EmployeeService {

    @Inject
    Logger log;

    public GeneralResponse employeeSaveService(EmpSaveRequestDto request) {
        log.debug(JsonObject.mapFrom(request).encodePrettily());
        GeneralResponse response=new GeneralResponse();
        EmpSaveResponseDto dataResult=new EmpSaveResponseDto();

        Long empId=request.getEmpId();

        if (empId==null) {
            //insert
            MasterEmployee masterEmployee=new MasterEmployee();
            masterEmployee.setFullname(request.getFullname());
            masterEmployee.setBirthdate(new Date());
            masterEmployee.setDivisionCode(request.getDivisionCode());
            masterEmployee.setGender(request.getGender());
            masterEmployee.setLevelCode(request.getLevelCode());
            masterEmployee.setPositionCode(request.getPositionCode());
            masterEmployee.persist();
            empId=masterEmployee.getEmpId();
        } else {
            //update
            Optional<MasterEmployee> masterEmployeeOptional=MasterEmployee.findByIdOptional(empId);
            if (masterEmployeeOptional.isPresent()) {
                MasterEmployee masterEmployee=masterEmployeeOptional.get();
                masterEmployee.setFullname(request.getFullname());
                masterEmployee.setBirthdate(new Date());
                masterEmployee.setDivisionCode(request.getDivisionCode());
                masterEmployee.setGender(request.getGender());
                masterEmployee.setLevelCode(request.getLevelCode());
                masterEmployee.setPositionCode(request.getPositionCode());
                masterEmployee.persist();
            } else {
                dataResult.setResult(false);
                dataResult.setEmpId(null);
                response.setData(dataResult);
                response.setStatus("failed data not found");
                return response;
            }
        }

        dataResult.setResult(true);
        dataResult.setEmpId(empId);
        response.setData(dataResult);
        response.setStatus("success");
        log.debug(JsonObject.mapFrom(response).encodePrettily());
        return response;
    }
}
