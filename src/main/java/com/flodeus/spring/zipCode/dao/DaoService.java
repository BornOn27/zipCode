package com.flodeus.spring.zipCode.dao;

import com.flodeus.spring.zipCode.model.Field;
import com.flodeus.spring.zipCode.model.PinCode;
import com.flodeus.spring.zipCode.service.ConnectionManager;
import com.flodeus.spring.zipCode.src.FieldType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaoService {
    private static boolean AUTO_COMMIT_STATUS = false;
    private static int FETCH_SIZE = 100000;
    private static final String QUERY_DISTRICT_LIST_BY_STATE = "select distinct districtName from all_india_po_list where stateName like ? order by 1 limit ? offset ?";
    private static final String QUERY_OFFICE_LIST_BY_STATE = "select distinct officeName from all_india_po_list where stateName like ? order by 1 limit ? offset ?";
    private HashMap<Integer, String> stateMapping = new HashMap<>();
    private ConnectionManager connectionManager;



    void init(){
        if(stateMapping == null){
            stateMapping = new HashMap<>();
        }
        if(stateMapping.size() == 0){
            stateMapping.put(1, "ANDAMAN & NICOBAR ISLANDS");
            stateMapping.put(2, "ANDHRA PRADESH");
            stateMapping.put(3, "ARUNACHAL PRADESH");
            stateMapping.put(4, "ASSAM");
            stateMapping.put(5, "BIHAR");
            stateMapping.put(6, "CHANDIGARH");
            stateMapping.put(7, "CHATTISGARH");
            stateMapping.put(8, "DADRA & NAGAR HAVELI");
            stateMapping.put(9, "DAMAN & DIU");
            stateMapping.put(10, "DELHI");
            stateMapping.put(11, "GOA");
            stateMapping.put(12, "GUJARAT");
            stateMapping.put(13, "HARYANA");
            stateMapping.put(14, "HIMACHAL PRADESH");
            stateMapping.put(15, "JAMMU & KASHMIR");
            stateMapping.put(16, "JHARKHAND");
            stateMapping.put(17, "KARNATAKA");
            stateMapping.put(18, "KERALA");
            stateMapping.put(19, "LAKSHADWEEP");
            stateMapping.put(20, "MADHYA PRADESH");
            stateMapping.put(21, "MAHARASHTRA");
            stateMapping.put(22, "MANIPUR");
            stateMapping.put(23, "MEGHALAYA");
            stateMapping.put(24, "MIZORAM");
            stateMapping.put(25, "NAGALAND");
            stateMapping.put(26, "ODISHA");
            stateMapping.put(27, "PONDICHERRY");
            stateMapping.put(28, "PUNJAB");
            stateMapping.put(29, "RAJASTHAN");
            stateMapping.put(30, "SIKKIM");
            stateMapping.put(31, "TAMIL NADU");
            stateMapping.put(32, "TELANGANA");
            stateMapping.put(33, "TRIPURA");
            stateMapping.put(34, "UTTAR PRADESH");
            stateMapping.put(35, "UTTARAKHAND");
            stateMapping.put(36, "WEST BENGAL");
        }
    }

    String getStateNameById(Integer stateId){
        if(stateMapping.size() == 0)
            init();
        return stateMapping.get(stateId);
    }

    String getQueryByFieldType(FieldType fieldType){
        switch (fieldType){
            case OFFICE_NAME:
                return QUERY_OFFICE_LIST_BY_STATE;
            case DISTRICT_NAME:
                return QUERY_DISTRICT_LIST_BY_STATE;
        }

        return null;
    }

    public List<Field> allStates() throws SQLException {
        if(stateMapping.size() == 0)
            init();

        List<Field> list = new ArrayList<>();
        for(Integer key : stateMapping.keySet()){
            Field field = new Field();
            field.setName(stateMapping.get(key));
            list.add(field);
        }
        return list;
    }

    public List<Field> findByState(Integer stateId, int limit, int offset, FieldType fieldType) throws SQLException {
        List<Field> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            String stateName = getStateNameById(stateId);
            String query = getQueryByFieldType(fieldType);

            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            connection.setAutoCommit(AUTO_COMMIT_STATUS);

            statement = connection.prepareStatement(query);
            statement.setString(1, "%"+stateName+"%");
            statement.setInt(2, limit);
            statement.setInt(3, offset);

            resultSet = statement.executeQuery();
            resultSet.setFetchSize(FETCH_SIZE);

            while (resultSet.next()){
                Field field = new Field();
                field.setName(resultSet.getString(fieldType.getFieldName()));
                list.add(field);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return list;
    }

}
