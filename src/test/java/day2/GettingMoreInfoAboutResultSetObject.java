package day2;

import jdk.nashorn.internal.ir.WhileNode;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.80.207.221:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM EMPLOYEES");

        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        System.out.println("colCount = " + colCount);

        System.out.println("First Column Name is "+ rsmd.getColumnLabel(1));
        System.out.println("2nd Column Name is "+ rsmd.getColumnName(2));

        for (int i = 1; i <=rsmd.getColumnCount(); i++) {
            String columnName = rsmd.getColumnName(i);
            System.out.println(i+"ColumnName = "+columnName);
        }

        rs.close();
        stmnt.close();
        conn.close();



    }

}
