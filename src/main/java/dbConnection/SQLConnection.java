package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLConnection {

    public static void main(String args[]) {
    selectQuery();
}

//Select from table
        public static void selectQuery ()
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/Library_System", "root", "");

                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("select * from Books");
                if (rs.next()) {
                    System.out.println
                            (rs.getInt(1) + "  "
                                    + rs.getString(2) + "  " + rs.getString(3));
                    con.close();
                }
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
