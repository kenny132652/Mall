package util;

import  java.sql.*;



public class ConnUtil {

    static String url="jdbc:sqlserver://localhost:1433;encrypt=false;databasename=";
    static String user="sa";
    static String password="kenny5308";
    static String defaultDatabase = "TableTop";


    public static  Connection getconnection() throws SQLException{
        return DriverManager.getConnection(url+defaultDatabase, user, password);
    }
    public static  Connection getconnection(String databasename) throws SQLException{
        return DriverManager.getConnection(url+databasename, user, password);
    }

}
