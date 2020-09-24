package com.flodeus.spring.zipCode.controller.states;

import com.flodeus.spring.zipCode.dao.DaoService;
import com.flodeus.spring.zipCode.dao.StateDaoService;
import com.flodeus.spring.zipCode.model.Field;
import com.flodeus.spring.zipCode.model.PinCode;
import com.flodeus.spring.zipCode.src.FieldType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StateController {
    private static final int DEFAULT_LIMIT = 500;
    private static final int DEFAULT_OFFSET = 0;

    @GetMapping(path = "/states")
    public List<Field> getAllStates() throws SQLException {
        return new DaoService().allStates();
    }

    //Api List for PinCode with State
    @GetMapping(path = "/states/{id}")
    public List<PinCode> getAllForState(@PathVariable Integer id){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByState(id, DEFAULT_LIMIT, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    //Api List for District with State
    @GetMapping(path = "/states/{id}/districts")
    public List<Field> getAllDistrictsForState(@PathVariable Integer id){
        List<Field> response = null;
        try {
            response = new DaoService().findByState(id, DEFAULT_LIMIT, DEFAULT_OFFSET, FieldType.DISTRICT_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    //Api List for PinCode with State & District
    @GetMapping(path = "/states/{id}/districts/{name}")
    public List<PinCode> getAllPinCodeForStateAndDistrict(@PathVariable Integer id, @PathVariable String name){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndField(id, FieldType.DISTRICT_NAME, name, DEFAULT_LIMIT, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{id}/districts/{name}", params = {"limit", "offset"})
    public List<PinCode> getAllPinCodeForStateAndDistrictWithPaging(@PathVariable Integer id, @PathVariable String name, @RequestParam int limit, @RequestParam int offset){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndField(id, FieldType.DISTRICT_NAME, name, limit, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    //Api List for Offices with State
    @GetMapping(path = "/states/{id}/offices")
    public List<Field> getAllOfficeNameForState(@PathVariable Integer id){
        List<Field> response = null;
        try {
            response = new DaoService().findByState(id, DEFAULT_LIMIT, DEFAULT_OFFSET, FieldType.OFFICE_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    //Api List for PinCode with State & OfficeName
    @GetMapping(path = "/states/{id}/offices/{name}")
    public List<PinCode> getAllPinCodeForStateAndOfficeName(@PathVariable Integer id, @PathVariable String name){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndField(id, FieldType.OFFICE_NAME, name, DEFAULT_LIMIT, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{id}/offices/{name}", params = {"limit", "offset"})
    public List<PinCode> getAllPinCodeForStateAndOfficeNameWithPaging(@PathVariable Integer id, @PathVariable String name, @RequestParam int limit, @RequestParam int offset){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndField(id, FieldType.OFFICE_NAME, name, limit, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }


}
