package com.example.DiffingAPI.dao.impl;

import com.example.DiffingAPI.dao.DiffingDao;
import com.example.DiffingAPI.model.DaoBaseOutValue;
import com.example.DiffingAPI.model.columnsDiffValue;
import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class DiffingDaoImpl implements DiffingDao {


    public static void main(String[] args) throws ClassNotFoundException {

        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
//            statement.executeUpdate("drop table if exists DiffingTable");
            statement.executeUpdate("create table DiffingTable (id string, valueRight string, valueLeft string)");
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

//
    @Override
    public columnsDiffValue getValue() throws ClassNotFoundException {

        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        columnsDiffValue outValueColumns = new columnsDiffValue();
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet resultSet = statement.executeQuery("select * from DiffingTable");
//            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String valueRight = resultSet.getString("valueRight");
                String valueLeft = resultSet.getString("valueLeft");
                    // read the result set
                System.out.println(" valueRight = " + valueRight);
                System.out.println(" valueLeft = " + valueLeft);
                outValueColumns.setId(id);
                outValueColumns.setRightValue(valueRight);
                outValueColumns.setLeftValue(valueLeft);
//            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return outValueColumns;
    }


    @Override
    public DaoBaseOutValue addRightAmnt(String inValue) throws ClassNotFoundException {

        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        DaoBaseOutValue daoOutValue= new DaoBaseOutValue();

        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate(" INSERT INTO DiffingTable(id, valueRight, valueLeft ) VALUES ( '1' , '" + inValue + " ' , (select valueLeft from DiffingTable where id = 1) )");
            statement.executeUpdate( " UPDATE DiffingTable SET valueRight = ' "+ inValue +" '");

            daoOutValue.setResponseCode("000");
        } catch (SQLException e) {    // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }

        return daoOutValue;
    }



    @Override
    public DaoBaseOutValue addLeftAmnt(String inValue) throws ClassNotFoundException {
        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        DaoBaseOutValue daoOutValue= new DaoBaseOutValue();
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("insert or replace into DiffingTable (id, valueRight, valueLeft ) values " +
                    "( '1' , " + "' (select valueRight from DiffingTable where id = 1)' , '" + inValue + " ' )" );
            statement.executeUpdate( " UPDATE DiffingTable SET valueLeft = ' "+ inValue +" '");

            daoOutValue.setResponseCode("000");
        } catch (SQLException e) {    // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return daoOutValue;
    }


}
