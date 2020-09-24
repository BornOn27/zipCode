package com.flodeus.spring.zipCode.dao;

import com.flodeus.spring.zipCode.model.PinCode;
import com.flodeus.spring.zipCode.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PinCodeDaoService {
    private static boolean AUTO_COMMIT_STATUS = false;
    private static int FETCH_SIZE = 1000;
    private static final String QUERY_PINCODE_LIST = "select * from all_india_po_list order by pincode limit ? offset ?";
    private static final String QUERY_SEARCH_PINCODE = "select * from all_india_po_list where pincode like ? order by pincode limit ? offset ?";

    private ConnectionManager connectionManager;

    public List<PinCode> all(int limit, int offset) throws SQLException {
        List<PinCode> pinCodes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            connection.setAutoCommit(AUTO_COMMIT_STATUS);

            statement = connection.prepareStatement(QUERY_PINCODE_LIST);
            statement.setInt(1, limit);
            statement.setInt(2, offset);

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

    public List<PinCode> find(int code, int limit, int offset) throws SQLException {
        List<PinCode> pinCodes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connectionManager = new ConnectionManager();
            connection = connectionManager.getApplicationSql();
            connection.setAutoCommit(AUTO_COMMIT_STATUS);

            statement = connection.prepareStatement(QUERY_SEARCH_PINCODE);
            statement.setString(1, "%"+code+"%");
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
}
