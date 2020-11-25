package day2;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.80.207.221:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM JOBS");


        rs.next();
        System.out.println("First column value jobs "+rs.getString(1));
        System.out.println("Second column value jobs "+rs.getString(2));

        rs.absolute(7);
        System.out.println("First column value jobs row 7 "+rs.getString(1));
        System.out.println("Second column value jobs row 7 "+rs.getString(2));

        rs.last();
        System.out.println("First column value jobs in Last row "+rs.getString(1));
        System.out.println("Second column value jobs in last row  "+rs.getString(2));

        rs.previous();
        System.out.println("First column value jobs 2nd row from last "+rs.getString(1));
        System.out.println("Second column value jobs 2nd row from last "+rs.getString(2));


        System.out.println("_____________________Loop from top to bottom JOB_ID___________________________");

        rs.beforeFirst();

        while ( rs.next() ){
            System.out.println("Loop First Column " + rs.getString("JOB_ID"));
        }

        System.out.println("_____________________Get min Salary ___________________________");

        rs.afterLast();

        while ( rs.previous() ){
            System.out.println("Min Salary colum as number "+rs.getDouble("MIN_SALARY"));
        }

        rs.close();
        stmnt.close();
        conn.close();



    }
}
