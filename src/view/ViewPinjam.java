/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerPinjam;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelPinjam;
import util.Koneksi;

/**
 *
 * @author m-tech comp
 */
public class ViewPinjam extends javax.swing.JPanel {

    Koneksi koneksi = new Koneksi();
    ModelPinjam mp = new ModelPinjam();
    ControllerPinjam cp = new ControllerPinjam();
    /**
     * Creates new form ViewPinjam
     */
    public ViewPinjam() {
        initComponents();
        tampilPinjam();
    }
    
    
     private void tampilPinjam() {
        koneksi.koneksiDatabase();

        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("ID");
        tabel.addColumn("Nama Teman");
        tabel.addColumn("Barang yang Dipinjam");

        jTablePinjam.setModel(tabel);
        try {
            String sql = "select * from tbl_pinjam";

            ResultSet res = koneksi.state.executeQuery(sql);
            while (res.next()) {
                tabel.addRow(new Object[]{
                    res.getString("id"),
                    res.getString("namaTeman"),
                    res.getString("barangpinjam")
                });
                jTablePinjam.setModel(tabel);

            }
        } catch (SQLException eer) {
            System.err.println("SQLException:" + eer.getMessage());
        }
    }

    private void tombolBaru() {
        jTextFieldNama.setEditable(true);
        jTextAreaBarang.setEditable(true);
        jTextFieldNama.requestFocus();
        jButtonCari.setEnabled(true);
        bersihJTextField();
    }

    private void tombolBatal() {
        jTextFieldNama.setEditable(false);
        jTextAreaBarang.setEditable(false);
        jButtonCari.setEnabled(false);
        bersihJTextField();
        jButtonSimpan.setEnabled(false);
        jButtonBaru.setText("Baru");
    }

    private void bersihJTextField() {
        jTextFieldId.setText("");
        jTextFieldNama.setText("");
        jTextAreaBarang.setText("");
        jComboBox1.removeAllItems();
    }

    private void tabelKlik() {
        jButtonHapus.setEnabled(true);
        jButtonUbah.setEnabled(true);
        jTextAreaBarang.setEditable(true);
    }

    private void tabelUnKlik() {
        jButtonHapus.setEnabled(false);
        jButtonUbah.setEnabled(false);
        jTextAreaBarang.setEditable(false);
        bersihJTextField();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldNama = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBarang = new javax.swing.JTextArea();
        jButtonBaru = new javax.swing.JButton();
        jButtonTutup = new javax.swing.JButton();
        jButtonUbah = new javax.swing.JButton();
        jButtonBersih = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jButtonSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePinjam = new javax.swing.JTable();
        jButtonCari = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("id :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 32, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nama :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, -1, -1));
        add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 11, 42, -1));
        add(jTextFieldNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 43, 268, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 76, 268, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Barang :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, -1, -1));

        jTextAreaBarang.setColumns(20);
        jTextAreaBarang.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBarang);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 126, 268, 46));

        jButtonBaru.setText("Baru");
        jButtonBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaruActionPerformed(evt);
            }
        });
        add(jButtonBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 201, -1, -1));

        jButtonTutup.setText("Tutup");
        jButtonTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTutupActionPerformed(evt);
            }
        });
        add(jButtonTutup, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 201, -1, -1));

        jButtonUbah.setText("Ubah");
        jButtonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUbahActionPerformed(evt);
            }
        });
        add(jButtonUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 201, -1, -1));

        jButtonBersih.setText("Bersih");
        jButtonBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBersihActionPerformed(evt);
            }
        });
        add(jButtonBersih, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 201, -1, -1));

        jButtonHapus.setText("Hapus");
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });
        add(jButtonHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 201, -1, -1));

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });
        add(jButtonSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 201, -1, -1));

        jTablePinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePinjamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePinjam);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 235, 395, 198));

        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });
        add(jButtonCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 42, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTutupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButtonTutupActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        // TODO add your handling code here:
         String ch = jTextFieldNama.getText().trim();
        
        if (ch.equals("")) {
//            jComboBox1.setVisible(false);
        } else {
            System.out.println(ch);
            jComboBox1.removeAllItems();
            try {
                koneksi.koneksiDatabase();
                String query = "select * from tbl_teman where nama like '%" + ch + "%'";
                ResultSet rs = koneksi.state.executeQuery(query);
                while (rs.next()) {
                    jComboBox1.addItem(rs.getString("nama"));
                }
                rs.last();
                int jumlahdata = rs.getRow();
                rs.first();
            } catch (SQLException e) {
                System.err.println("" + e);
            }
        }
    }//GEN-LAST:event_jButtonCariActionPerformed

    private void jButtonBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaruActionPerformed
        // TODO add your handling code here:
         String logic = jButtonBaru.getText();
        if (logic.equals("Baru")) {
            jButtonSimpan.setEnabled(true);
            jButtonBaru.setText("Batal");
            tombolBaru();
        } else {
            jButtonSimpan.setEnabled(false);
            jButtonBaru.setText("Baru");
            tombolBatal();
        }
    }//GEN-LAST:event_jButtonBaruActionPerformed

    private void jButtonBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBersihActionPerformed
        // TODO add your handling code here:
         bersihJTextField();
    }//GEN-LAST:event_jButtonBersihActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        // TODO add your handling code here:
        String nama = jComboBox1.getSelectedItem().toString();
        String barang = jTextAreaBarang.getText();
        if(nama.equals("") || barang.equals("")){
            JOptionPane.showMessageDialog(null, "Harap Isi Data Dengan Benar");
        }else{
            
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda ingin Menyimpan?", "PERHATIAN",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                mp.setNamaTeman(nama);
                mp.setBarangDipinjam(barang);
                
                cp.simpanPinjaman(mp);

                tampilPinjam();
                tombolBatal();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Harap Isi Data Dengan Benar");
            }
        } else {
        }
        }
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jButtonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUbahActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Apakah Kamu ingin Mengubah?", "PERHATIAN",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(jTextFieldId.getText());
                String nama = jTextFieldNama.getText();
                String barang = jTextAreaBarang.getText();

                mp.setId(id);//mt didapat dari pembuatan objek, dari kelas ModelTeman (instansiasi dilakukan diatas)
                mp.setNamaTeman(nama);
                mp.setBarangDipinjam(barang);

                cp.ubahDataPinjam(mp);//ct didapat dari pembuatan objek, dari kelas ControllerTeman (instansiasi dilakukan diatas)

                tampilPinjam();
                tabelUnKlik();
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Galat jButtonUbahActionPerformed : ");
            }
        } else {
        }
    }//GEN-LAST:event_jButtonUbahActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        // TODO add your handling code here:
          if (JOptionPane.showConfirmDialog(null, "Apakah Kamu Ingin Menghapus?", "PERHATIAN!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(jTextFieldId.getText());

                mp.setId(id);//mt didapat dari pembuatan objek, dari kelas ModelTeman (instansiasi dilakukan diatas)
                cp.hapusDataPinjam(mp);//ct didapat dari pembuatan objek, dari kelas ControllerTeman (instansiasi dilakukan diatas)

                tampilPinjam();
                tabelUnKlik();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Galat jButtonHapusActionPerformed : " + e);
            }
        } else {
        }
    }//GEN-LAST:event_jButtonHapusActionPerformed

    private void jTablePinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePinjamMouseClicked
        // TODO add your handling code here:
        try {
            int baris = jTablePinjam.getSelectedRow();//mengambil urutan baris dari table yang ada
            jTextFieldId.setText(jTablePinjam.getValueAt(baris, 0).toString());
            jTextFieldNama.setText(jTablePinjam.getValueAt(baris, 1).toString());
            jTextAreaBarang.setText(jTablePinjam.getValueAt(baris, 2).toString());
            tabelKlik();
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }//GEN-LAST:event_jTablePinjamMouseClicked

            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBaru;
    private javax.swing.JButton jButtonBersih;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonTutup;
    private javax.swing.JButton jButtonUbah;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePinjam;
    private javax.swing.JTextArea jTextAreaBarang;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNama;
    // End of variables declaration//GEN-END:variables
}
