package day2;

import java.sql.*;

public class DisplayingAllDateFromAllColumns {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.80.207.221:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

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

    }
}
