/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vika
 */
public class MuridKontroler {
     String sql = "insert into students(name, mobile, course) values (?,?,?)";

    public List<Murid> ambilseumaData() throws SQLException {
        List<Murid> daftarMurid = new ArrayList<>();
        Connection koneksi = Koneksi.getConnection();
        Statement st = koneksi.createStatement();
        ResultSet hasil = st.executeQuery("select * from students");

        while (hasil.next()) {
            Murid m = new Murid();
            m.setId(hasil.getInt(1));
            m.setName(hasil.getString(2));
            m.setMobile(hasil.getString(3));
            m.setCourse(hasil.getString(4));
            daftarMurid.add(m);
        }

        return daftarMurid;
    }

    public void simpanData(Murid m) throws SQLException {
        Connection koneksi = Koneksi.getConnection();
        PreparedStatement ps = koneksi.prepareStatement(sql);

        ps.setString(1, m.getName());
        ps.setString(2, m.getMobile());
        ps.setString(3, m.getCourse());
        ps.executeUpdate();
        ps.close();
        koneksi.close();
    }
}
