package com.flodeus.spring.zipCode.controller.states;

import com.flodeus.spring.zipCode.dao.StateDaoService;
import com.flodeus.spring.zipCode.model.City;
import com.flodeus.spring.zipCode.model.District;
import com.flodeus.spring.zipCode.model.PinCode;
import com.flodeus.spring.zipCode.model.State;
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
    public List<State> getAllStates() throws SQLException {
        return new StateDaoService().all();
    }

    //Api List for PinCode with State
    @GetMapping(path = "/states/name/{name}")
    public List<PinCode> getAllForState(@PathVariable String name){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByState(name.toLowerCase(), DEFAULT_LIMIT, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/name/{name}", params = {"offset"})
    public List<PinCode> getAllForStateWithOffset(@PathVariable String name,  @RequestParam int offset) {
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByState(name.toLowerCase(), DEFAULT_LIMIT, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/name/{name}", params = {"limit"})
    public List<PinCode> getAllForStateWithLimit(@PathVariable String name, @RequestParam int limit){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByState(name.toLowerCase(), limit, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/name/{name}", params = {"limit", "offset"})
    public List<PinCode> getAllForStateWithParams(@PathVariable String name, @RequestParam int limit,  @RequestParam int offset) {
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByState(name.toLowerCase(), limit, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    //Api List for District with State
    @GetMapping(path = "/states/{name}/districts")
    public List<District> getAllDistrictsForState(@PathVariable String name){
        List<District> response = null;
        try {
            response = new StateDaoService().getAllDistrictsByState(name, DEFAULT_LIMIT, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{name}/districts", params = {"limit"})
    public List<District> getAllDistrictsForStateWithOffset(@PathVariable String name, @RequestParam int limit, @RequestParam int offset){
        List<District> response = null;
        try {
            response = new StateDaoService().getAllDistrictsByState(name, limit, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{name}/districts", params = {"offset"})
    public List<District> getAllDistrictsForStateWithOffset(@PathVariable String name, @RequestParam int offset){
        List<District> response = null;
        try {
            response = new StateDaoService().getAllDistrictsByState(name, DEFAULT_LIMIT, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{name}/districts", params = {"limit", "offset"})
    public List<District> getAllDistrictsForStateWithParams(@PathVariable String name, @RequestParam int limit, @RequestParam int offset){
        List<District> response = null;
        try {
            response = new StateDaoService().getAllDistrictsByState(name, limit, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    //Api List for PinCode with State & District
    @GetMapping(path = "/states/{name}/districts/{dName}")
    public List<PinCode> getAllPinCodeForStateAndDistrict(@PathVariable String name, @PathVariable String dName){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndDistrict(name, dName, DEFAULT_LIMIT, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{name}/districts/{dName}", params = {"limit"})
    public List<PinCode> getAllPinCodeForStateAndDistrictWithOffset(@PathVariable String name, @PathVariable String dName, @RequestParam int limit, @RequestParam int offset){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndDistrict(name, dName, limit, DEFAULT_OFFSET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{name}/districts/{dName}", params = {"offset"})
    public List<PinCode> getAllPinCodeForStateAndDistrictWithOffset(@PathVariable String name, @PathVariable String dName, @RequestParam int offset){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndDistrict(name, dName, DEFAULT_LIMIT, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    @GetMapping(path = "/states/{name}/districts/{dName}", params = {"limit", "offset"})
    public List<PinCode> getAllPinCodeForStateAndDistrictWithParams(@PathVariable String name, @PathVariable String dName, @RequestParam int limit, @RequestParam int offset){
        List<PinCode> response = null;
        try {
            response = new StateDaoService().getAllPinCodesByStateAndDistrict(name, dName, limit, offset);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

}
