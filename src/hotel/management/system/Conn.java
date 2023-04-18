package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

   protected Connection c;
   protected  Statement s;

    public Conn() {

        try {
            //register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating the connection...
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem?autoReconnect=true&useSSL=false", "root", "Koustav@2019");

            //creating statement
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
