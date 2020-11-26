package utility;

import java.sql.*;

public class DB_Utility {

    static Connection conn;
    static Statement stmnt;
    static ResultSet rs;

    public static void createConnection() {

        String connectionStr = "jdbc:oracle:thin:@3.80.207.221:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            conn = DriverManager.getConnection(connectionStr, username, password);
            System.out.println("CONNECTION SUCCESSFUL !! ");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!!!!! " + e.getMessage());
            ;
        }

    }

    public static ResultSet runQuery(String query) {

        ResultSet rs = null;

        try {
            stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error while getting resultset " + e.getMessage());
        }

        return rs;

    }

    public static void destroy() {
        try {
            rs.close();
            stmnt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static int getRowCount() {
        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();

            rs.beforeFirst();

        } catch (SQLException e) {

            System.out.println("ERROR WHILE GETTING ROW COUNt " + e.getMessage());
        }
        return rowCount;

    }

    public static int getColumnCount(){

        int columnCount  = 0;


        try {

            ResultSetMetaData rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS "+ e.getMessage());
        }
        return columnCount;
    }

}
