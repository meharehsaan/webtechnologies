
//Getting meta data

import java.sql.*;

class dbconn {
    final static String dbDriver = "com.mysql.cj.jdbc.Driver";
    final static String dbURL = "jdbc:mysql://localhost:3306/";

    static String dbName = "survletdata";
    static String dbUsername = "root";
    static String dbPassword = "Mehar@2762";

    static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (SQLException e) {
            conn = null;
        } finally {
            return conn;
        }

    }
}

public class personinfo {

    public static void myfunc() {

        try {
            Connection con = dbconn.getConnection();

            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println(dbmd.getTables(null, null, null, null));
            System.out.println(dbmd.getDatabaseMajorVersion());

            System.out.println("reocrds----------------");

            PreparedStatement pst = con.prepareStatement("Select * from persondetail", ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println(rs.getString("name"));

                rs.updateString("name", "Hassan ahmad");
                rs.updateRow();
                System.out.println(rs.getString("name")); // Hassan Khan


                rs.next();

                rs.next();
                rs.previous();
                String val = rs.getString("username");
                System.out.println(val);

                ResultSetMetaData rsmd = rs.getMetaData();
                
                System.out.println(rsmd.getColumnCount());
                System.out.println(rsmd.getColumnName(2));


                //adding new row
                // rs.moveToInsertRow();

                // rs.updateString("name", "ahmad");
                // rs.updateString("username", "ahmadssdkjf");
                // rs.updateString("password", "123456");

                // rs.insertRow();

                // System.out.println("New Record inserted");

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        personinfo.myfunc();
    }

}