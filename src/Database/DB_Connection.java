package Database;

import java.sql.*;

public class DB_Connection {

    private static Connection conn;
    private static Statement stmt;
    //    private static final String USER = "sql7313897";
//    private static final String PASS = "vAC2v1qeAK";

    private static final String USER = "sql7315453";
    private static final String PASS = "DDaLktyD5U";

//    private static final String USER = "mohaabdev_ozan";
//    private static final String PASS = "sifrebiletozan44";


    public DB_Connection() throws SQLException {

        String url = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7315453";
//        String url = "jdbc:mysql://mohaabdev.com:3306/mohaabdev_bilet";


        conn = DriverManager.getConnection(url, USER, PASS);
        System.out.println("Database connection established");


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
