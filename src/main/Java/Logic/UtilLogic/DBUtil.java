package Logic.UtilLogic;

import java.sql.*;

/**
 * Created by kodexx on 1/24/18.
 */
public class DBUtil {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/clinic";
    static final String user= "kodexx";
    static final String password = "";
    Connection conn = null;
    Statement stmt = null;



    public DBUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Connecting to the DB");
        this.conn = DriverManager.getConnection(URL, user, password);
        //conn.setAutoCommit(false);
        //System.out.println("Connected.");
    }

    public ResultSet read(String sql){
        ResultSet rs = null;
        try {

            System.out.println("Creating a statement");
            this.stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

        return rs;
    }

    public int write(String sql){
        int k=0;
        try {
            this.stmt = conn.createStatement();
            k = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }

        return k;
    }

    public void cleanUp(ResultSet rs) {
        try{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }

    }
    public void cleanUp()  {
        try{
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }

    }

}


