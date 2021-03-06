package com.flodeus.spring.zipCode.dao;

import com.flodeus.spring.zipCode.model.PinCode;
import com.flodeus.spring.zipCode.service.ConnectionManager;
import com.flodeus.spring.zipCode.src.FieldType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StateDaoService {
    private static boolean AUTO_COMMIT_STATUS = false;
    private static int FETCH_SIZE = 1000;
    private static final String LABEL_STATE = "state_name";
    private static final String LABEL_DISTRICT = "district_name";

    private static final String QUERY_ALL_PIN_CODE_BY_STATE = "select * from all_india_po_list where lower(stateName) LIKE ? order by id limit ? offset ?;";
    private static final String QUERY_ALL_PIN_CODE_BY_STATE_AND_FIELD = "select * from all_india_po_list where lower(stateName) LIKE ? AND lower(?) LIKE ? order by id limit ? offset ?;";

    private ConnectionManager connectionManager;

    public List<PinCode> getAllPinCodesByState(Integer stateId, int limit, int offset) throws SQLException {
        List<PinCode> pinCodes = new ArrayList<>();
        Connection connection= null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            String name = new DaoService().getStateNameById(stateId);
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

    public List<PinCode> getAllPinCodesByStateAndField(Integer stateId, FieldType fieldType, String fieldValue, int limit, int offset) throws SQLException {
        List<PinCode> pinCodes = new ArrayList<>();
        Connection connection= null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String stateName = new DaoService().getStateNameById(stateId);
            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            connection.setAutoCommit(AUTO_COMMIT_STATUS);

            statement = connection.prepareStatement(QUERY_ALL_PIN_CODE_BY_STATE_AND_FIELD);
            statement.setString(1, "%"+stateName+"%");
            statement.setString(2, fieldType.getFieldName());
            statement.setString(3, "%"+fieldValue+"%");
            statement.setInt(4, limit);
            statement.setInt(5, offset);

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
