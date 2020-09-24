package com.flodeus.spring.zipCode.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.ResultSet;
import java.sql.SQLException;

//@JsonFilter("RefinedPinCode")
public class PinCode {
    @JsonIgnore
    private int id;
    private String LABEL_ID = "id";
    private String officeName;
    private String LABEL_OFFICE_NAME = "officeName";
    private int pinCode;
    private String LABEL_PIN_CODE = "pincode";
    private String officeType;
    private String LABEL_OFFICE_TYPE = "officeType";
    private String deliveryStatus;
    private String LABEL_DELIVERY_STATUS = "deliveryStatus";
    private String divisionName;
    private String LABEL_DIVISION_NAME = "divisionName";
    private String regionName;
    private String LABEL_REGION_NAME = "regionName";
    private String circleName;
    private String LABEL_CIRCLE_NAME = "circleName";
    private String taluk;
    private String LABEL_TALUK = "taluk";
    private String districtName;
    private String LABEL_DISTRICT_NAME = "districtName";
    private String stateName;
    private String LABEL_STATE_NAME = "stateName";
    private String telephone;
    private String LABEL_TELEPHONE = "telephone";
    private String relatedSubOffice;
    private String LABEL_RELATED_SUB_OFFICE = "relatedSubOffice";
    private String relatedHeadOffice;
    private String LABEL_RELATED_HEAD_OFFICE = "relatedHeadOffice";
    @JsonIgnore
    private String longitude;
    private String LABEL_LONGITUDE = "longitude";
    @JsonIgnore
    private String latitude;
    private String LABEL_LATITUDE = "latitude";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRelatedSubOffice() {
        return relatedSubOffice;
    }

    public void setRelatedSubOffice(String relatedSubOffice) {
        this.relatedSubOffice = relatedSubOffice;
    }

    public String getRelatedHeadOffice() {
        return relatedHeadOffice;
    }

    public void setRelatedHeadOffice(String relatedHeadOffice) {
        this.relatedHeadOffice = relatedHeadOffice;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public PinCode setFields(PinCode pinCode, ResultSet resultSet) throws SQLException {
        pinCode.setId(resultSet.getInt(LABEL_ID));
        pinCode.setOfficeName(resultSet.getString(LABEL_OFFICE_NAME));
        pinCode.setPinCode(resultSet.getInt(LABEL_PIN_CODE));
        pinCode.setOfficeType(resultSet.getString(LABEL_OFFICE_TYPE));
        pinCode.setDeliveryStatus(resultSet.getString(LABEL_DELIVERY_STATUS));
        pinCode.setDivisionName(resultSet.getString(LABEL_DIVISION_NAME));
        pinCode.setRegionName(resultSet.getString(LABEL_REGION_NAME));
        pinCode.setCircleName(resultSet.getString(LABEL_CIRCLE_NAME));
        pinCode.setTaluk(resultSet.getString(LABEL_TALUK));
        pinCode.setDistrictName(resultSet.getString(LABEL_DISTRICT_NAME));
        pinCode.setStateName(resultSet.getString(LABEL_STATE_NAME));
        pinCode.setTelephone(resultSet.getString(LABEL_TELEPHONE));
        pinCode.setRelatedSubOffice(resultSet.getString(LABEL_RELATED_SUB_OFFICE));
        pinCode.setRelatedHeadOffice(resultSet.getString(LABEL_RELATED_HEAD_OFFICE));
        pinCode.setLongitude(resultSet.getString(LABEL_LONGITUDE));
        pinCode.setLatitude(resultSet.getString(LABEL_LATITUDE));
        return pinCode;
    }

    @Override
    public String toString() {
        return "PinCode{" +
                "id='" + id + '\'' +
                ", officeName='" + officeName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", officeType='" + officeType + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", divisionName='" + divisionName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", circleName='" + circleName + '\'' +
                ", taluk='" + taluk + '\'' +
                ", districtName='" + districtName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", related_SubOffice='" + relatedSubOffice + '\'' +
                ", relatedHeadOffice='" + relatedHeadOffice + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
