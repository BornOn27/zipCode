package com.flodeus.spring.zipCode.src;

public enum FieldType {
    OFFICE_NAME(10, "officeName"),
    PINCODE(20, "pincode"),
    DIVISION_NAME(30, "divisionName"),
    REGION_NAME(40, "regionName"),
    CIRCLE_NAME(50, "circleMame"),
    TALUK(60, "taluk"),
    DISTRICT_NAME(70,"districtName"),
    STATE_NAME(80, "stateName"),
    TELEPHONE(90, "telephone"),
    SUB_OFFICE(100, "relatedSubOffice"),
    HEAD_OFFICE(110, "relatedHeadOffice");

    private Integer id;
    private String fieldName;

    FieldType(Integer id, String fieldName) {
        this.id = id;
        this.fieldName = fieldName;
    }

    public Integer getId() {
        return id;
    }

    public String getFieldName() {
        return fieldName;
    }
}
