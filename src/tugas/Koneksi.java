/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vika
 */
public class Koneksi {
    private static final String uname = "root";
    private static final String passwd = "";
    private static final String url = "jdbc:mysql://localhost:3306/students";

   
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, uname, passwd);
    }
}
