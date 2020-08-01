package com.flodeus.spring.zipCode.dao;

import com.flodeus.spring.zipCode.model.City;
import com.flodeus.spring.zipCode.model.District;
import com.flodeus.spring.zipCode.model.PinCode;
import com.flodeus.spring.zipCode.model.State;
import com.flodeus.spring.zipCode.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StateDaoService {
    private static boolean AUTO_COMMIT_STATUS = false;
    private static int FETCH_SIZE = 1000;
    private static final String LABEL_STATE = "state_name";
    private static final String LABEL_DISTRICT = "district_name";

    private static final String QUERY_STATE = "select distinct state_name from all_india_po_list where state_name is not null order by 1;";
    private static final String QUERY_ALL_PIN_CODE_BY_STATE = "select * from all_india_po_list where lower(state_name) LIKE ? order by id limit ? offset ?;";
    private static final String QUERY_ALL_DISTRICTS_FOR_STATE = "select distinct district_name from all_india_po_list where lower(state_name) LIKE ? order by id limit ? offset ?;";
    private static final String QUERY_ALL_PIN_CODE_BY_STATE_AND_DISTRICT = "select * from all_india_po_list where lower(state_name) LIKE ? AND lower(district_name) LIKE ? order by id limit ? offset ?;";

    private ConnectionManager connectionManager;

    public List<State> all() throws SQLException {
        List<State> states = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(QUERY_STATE);

            while(resultSet.next()){
                State state = new State();
                state.setName(resultSet.getString(LABEL_STATE));
                states.add(state);
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

        return states;
    }

    public List<PinCode> getAllPinCodesByState(String name, int limit, int offset) throws SQLException {
        List<PinCode> pinCodes = new ArrayList<>();
        Connection connection= null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            connection.setAutoCommit(AUTO_COMMIT_STATUS);

            statement = connection.prepareStatement(QUERY_ALL_PIN_CODE_BY_STATE);
            statement.setString(1, "%"+name+"%");
            statement.setInt(2, limit);
            statement.setInt(3, offset);

            resultSet = statement.executeQuery();
            resultSet.setFetchSize(FETCH_SIZE);

            while (resultSet.next()){
                PinCode pinCode = new PinCode();
                pinCode = pinCode.setFields(pinCode, resultSet);
                pinCodes.add(pinCode);
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

        return pinCodes;
    }

    public List<District> getAllDistrictsByState(String name, int limit, int offset) throws SQLException{
        List<District> districts = new ArrayList<>();
        Connection connection= null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            connection.setAutoCommit(AUTO_COMMIT_STATUS);

            statement = connection.prepareStatement(QUERY_ALL_DISTRICTS_FOR_STATE);
            statement.setString(1, "%"+name+"%");
            statement.setInt(2, limit);
            statement.setInt(3, offset);

            resultSet = statement.executeQuery();
            resultSet.setFetchSize(FETCH_SIZE);

            while (resultSet.next()){
                District district = new District();
                district.setName(resultSet.getString(LABEL_DISTRICT));
                districts.add(district);
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

        return districts;
    }

    public List<PinCode> getAllPinCodesByStateAndDistrict(String stateName,String districtName,int limit, int offset) throws SQLException {
        List<PinCode> pinCodes = new ArrayList<>();
        Connection connection= null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            connection.setAutoCommit(AUTO_COMMIT_STATUS);

            statement = connection.prepareStatement(QUERY_ALL_PIN_CODE_BY_STATE_AND_DISTRICT);
            statement.setString(1, "%"+stateName+"%");
            statement.setString(2, "%"+districtName+"%");
            statement.setInt(3, limit);
            statement.setInt(4, offset);

            resultSet = statement.executeQuery();
            resultSet.setFetchSize(FETCH_SIZE);

            while (resultSet.next()){
                PinCode pinCode = new PinCode();
                pinCode = pinCode.setFields(pinCode, resultSet);
                pinCodes.add(pinCode);
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

        return pinCodes;
    }
}
