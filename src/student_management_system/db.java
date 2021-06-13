package student_management_system;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Buddhi Rangana
 */
public class db {

    Connection conn = null;

    public static Connection java_db() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sms_database?"
                    + "autoReconnect=true&useSSL=false", "root", "");
            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Conncetion Problem.", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }

    }
}
