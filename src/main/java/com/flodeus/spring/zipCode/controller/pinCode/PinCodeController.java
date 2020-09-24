package com.flodeus.spring.zipCode.controller.pinCode;

import com.flodeus.spring.zipCode.dao.PinCodeDaoService;
import com.flodeus.spring.zipCode.model.PinCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PinCodeController {
    private static final int DEFAULT_LIMIT = 500;
    private static final int DEFAULT_OFFSET = 0;

    @GetMapping(path = "pincode")
    public List<PinCode> getAllPinCode() throws SQLException {
        return new PinCodeDaoService().all(DEFAULT_LIMIT, DEFAULT_OFFSET);
    }

    @GetMapping(path = "pincode", params = {"offset"})
    public List<PinCode> getAllPinCodeByOffset(@RequestParam int offset) throws SQLException {
        return new PinCodeDaoService().all(DEFAULT_LIMIT, offset);
    }

    @GetMapping(path = "pincode",params = {"limit"})
    public List<PinCode> getAllPinCodeByLimit(@RequestParam int limit) throws SQLException {
        return new PinCodeDaoService().all(limit, DEFAULT_OFFSET);
    }

    @GetMapping(path = "pincode", params = {"limit", "offset"})
    public List<PinCode> getAllPinCode(@RequestParam int limit,  @RequestParam int offset) throws SQLException {
        return new PinCodeDaoService().all(limit, offset);
    }

    //Adding api for searching the pinCodes
    @GetMapping(path = "pincodes/{code}")
    public List<PinCode> searchPinCode(@PathVariable int code) throws SQLException {
        return new PinCodeDaoService().find(code, DEFAULT_LIMIT, DEFAULT_OFFSET);
    }

    @GetMapping(path = "pincodes/{code}", params = {"offset"})
    public List<PinCode> searchPinCodeByOffset(@PathVariable int code, @RequestParam int offset) throws SQLException {
        return new PinCodeDaoService().find(code, DEFAULT_LIMIT, offset);
    }

    @GetMapping(path = "pincodes/{code}",params = {"limit"})
    public List<PinCode> searchPinCodeByLimit(@PathVariable int code, @RequestParam int limit) throws SQLException {
        return new PinCodeDaoService().find(code, limit, DEFAULT_OFFSET);
    }

    @GetMapping(path = "pincodes/{code}", params = {"limit", "offset"})
    public List<PinCode> searchPinCode(@PathVariable int code, @RequestParam int limit,  @RequestParam int offset) throws SQLException {
        return new PinCodeDaoService().find(code, limit, offset);
    }


}
