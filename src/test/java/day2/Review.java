package day2;

import utility.DB_Utility;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT * FROM JOBS");


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

        DB_Utility.destroy();



    }
}
