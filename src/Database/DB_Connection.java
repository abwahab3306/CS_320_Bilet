package Database;

import java.sql.*;

public class DB_Connection {

    private static Connection conn;
    private static Statement stmt;
    static final String USER = "cs320";
    static final String PASS = "Yrj$bT}82^d)S2r";


    public DB_Connection() {

        String url = "jdbc:mysql://mohaabdev.com:3306/mohaabdev_cs320";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, USER, PASS);
            System.out.println("Connection Successful");
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error" + ex);


        }
    }
    public ResultSet send_query(String a, String... s) {

        ResultSet rs = null;
        stmt = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + a);

            while (rs.next()) {
                System.out.println(rs.getString(s[0]) + " - " + rs.getString(s[1]) + " " + rs.getString(s[2]) + " " + rs.getString(s[3])
                        + " " + rs.getString(s[4]));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {


            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }

                stmt = null;
            }
        }
        return rs;
    }

    public void insertData(String query) {

        try {
            stmt = conn.createStatement();

            conn.setAutoCommit(false);

            stmt.executeUpdate(query);

            conn.commit();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection terminated");
            } catch (SQLException e) {
            }
        }
    }

}
