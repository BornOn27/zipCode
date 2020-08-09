package com.flodeus.spring.zipCode.controller.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.flodeus.spring.zipCode.dao.StateDaoService;
import com.flodeus.spring.zipCode.model.PinCode;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class FilterController {
    private static final int DEFAULT_LIMIT = 500;
    private static final int DEFAULT_OFFSET = 0;

    @GetMapping(path = "/states/name/{name}/filters/{type}")
    public MappingJacksonValue getFilteredPinCodes(@PathVariable String name, @PathVariable Integer type){
        List<PinCode> response = null;
        SimpleBeanPropertyFilter filter = null;
        FilterProvider filterProvider = null;
        MappingJacksonValue mapping = null;

        //TODO Add Enum for storing filter-type and return response accordingly
        try {
            response = new StateDaoService().getAllPinCodesByState(name.toLowerCase(), DEFAULT_LIMIT, DEFAULT_OFFSET);

            filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "pinCode", "stateName");
            filterProvider = new SimpleFilterProvider().addFilter("RefinedPinCodes", filter);

            mapping = new MappingJacksonValue(response);
            mapping.setFilters(filterProvider);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapping;
    }
}
