package com.marcosoft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransferData {

    public void transfer(){

        DatabaseConfig dbConfig = new DatabaseConfig();

        Connection originData = dbConfig.createPeopleConnection();
        Connection destData = dbConfig.createActivityConnection();

        String tableName = "cateogry";

        String selectQuery = "select * from " + tableName;

        String insertQuery;

        try(PreparedStatement statement = originData.prepareStatement(selectQuery)){

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                insertQuery = "insert into " + tableName + " (id,name) values (";

                insertQuery = insertQuery + resultSet.getInt(1) + ",'" + resultSet.getString(2) + "')";

                Statement insertStatement =  destData.createStatement();
                insertStatement.execute(insertQuery);
            }

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
