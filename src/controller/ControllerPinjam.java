/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelPinjam;
import util.Koneksi;

/**
 *
 * @author m-tech comp
 */
public class ControllerPinjam {
      Koneksi koneksi = new Koneksi();

    public void simpanPinjaman(ModelPinjam mp) {
        koneksi.koneksiDatabase();
        String querySimpanPinjaman = "insert into tbl_pinjam(namaTeman,nope,barangpinjam) values('" + mp.getNamaTeman()+ "','"+mp.getNope()+"', '" + mp.getBarangDipinjam()+ "')";
        try {
            koneksi.state.executeUpdate(querySimpanPinjaman);
            JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
            System.err.println("Galat Controller Teman : " + e);
        }
    }
    
    public void hapusDataPinjam(ModelPinjam mp){
        try {
            koneksi.koneksiDatabase();
            String queryHapusDataPinjam = "delete from tbl_pinjam where id=('"+mp.getId()+"')";
            koneksi.state.executeUpdate(queryHapusDataPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus..");
            //koneksi.connect.close();
        } catch (SQLException e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terhapus");
        }
    }
    
    public void ubahDataPinjam(ModelPinjam mp){
        koneksi.koneksiDatabase();
         try {
            int id = mp.getId();
            String nama = mp.getNamaTeman();
            String barang = mp.getBarangDipinjam();

            String queryUbahDataPinjam = "update tbl_pinjam "
                    + "set barangpinjam=('"+ barang +"') where id=('" + id + "')";
            koneksi.state.executeUpdate(queryUbahDataPinjam);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate..");
        } catch (SQLException e) {
            System.err.println("Error : " + e);
            JOptionPane.showMessageDialog(null, "Data TIDAK terubah");
        }
    }
}
