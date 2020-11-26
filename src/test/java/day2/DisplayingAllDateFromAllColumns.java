package day2;

import utility.DB_Utility;

import java.sql.*;

public class DisplayingAllDateFromAllColumns {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS");

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int colNum = 1; colNum <= columnCount; colNum++) {
            System.out.print(rsmd.getColumnLabel(colNum)+"\t");

        }
        System.out.println("_______________________________");
        rs.next();

        for (int colNum = 1; colNum <= columnCount; colNum++) {
            System.out.print(rs.getString(colNum)+"\t");


        }

        rs.beforeFirst();

        while(rs.next()){

            for (int colNum = 1; colNum <= columnCount; colNum++) {
                System.out.print(rs.getString(colNum)+"\t");

            }
            System.out.println();
        }

        DB_Utility.destroy();
    }

}
