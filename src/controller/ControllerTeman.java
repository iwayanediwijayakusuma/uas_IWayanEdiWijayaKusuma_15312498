/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelTeman;
import util.Koneksi;

/**
 *
 * @author m-tech comp
 */
public class ControllerTeman {

    Koneksi koneksi = new Koneksi();

    public void simpanTeman(ModelTeman mt) {
        koneksi.koneksiDatabase();
        String querySimpanTeman = "insert into tbl_teman(nama,nope,email)values('" + mt.getNama() + "','" + mt.getNope() + "','" + mt.getEmail() + "')";
        try {
            koneksi.state.executeUpdate(querySimpanTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil di simpam");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak tersimpan");
            System.err.println("Galat Controller Teman :" + e);
        }
    }

    public void hapusDataTeman(ModelTeman mp) {
        try {
            koneksi.koneksiDatabase();
            String queryHapusDataTeman = "delete from tbl_teman where id=('" + mp.getId() + "')";
            koneksi.state.executeUpdate(queryHapusDataTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Galat hapusDataTeman : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }

    public void ubahDataTeman(ModelTeman mp) {
        koneksi.koneksiDatabase();
        try {
            int id = mp.getId();
            String nama = mp.getNama();
            String nope = mp.getNope();
            String email = mp.getEmail();

            String queryUbahDataTeman = "update tbl_teman "
                    + "set nama=('" + nama + "'),"
                    + "nope=('" + nope + "'),"
                    + "email=('" + email + "')"
                    + "where id=('" + id + "')";
            koneksi.state.executeUpdate(queryUbahDataTeman);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
        } catch (SQLException e) {
            System.err.println("Galat ubahDataTeman : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
