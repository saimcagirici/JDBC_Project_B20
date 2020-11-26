package day2;

import jdk.nashorn.internal.ir.WhileNode;
import utility.DB_Utility;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS");

        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        System.out.println("colCount = " + colCount);

        System.out.println("First Column Name is "+ rsmd.getColumnLabel(1));
        System.out.println("2nd Column Name is "+ rsmd.getColumnName(2));

        for (int i = 1; i <=rsmd.getColumnCount(); i++) {
            String columnName = rsmd.getColumnName(i);
            System.out.println(i+"ColumnName = "+columnName);
        }

        DB_Utility.destroy();



    }

}
