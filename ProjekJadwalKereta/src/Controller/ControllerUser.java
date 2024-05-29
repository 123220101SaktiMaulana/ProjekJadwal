/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User.DAOUser;
import Model.User.InterfaceUser;
import Model.User.ModelUser;
import javax.swing.JOptionPane;
import projekjadwalkereta.Daftar;
import projekjadwalkereta.Login;

/**
 *
 * @author Aibra
 */
public class ControllerUser {
    Daftar Formdaftar;
    
    InterfaceUser daoUser;
    
    public ControllerUser(Daftar Formdaftar){
        this.Formdaftar = Formdaftar;
        this.daoUser = new DAOUser();
    
    }
     
     public void tes(){
         System.out.println("halo");
     }
     
//    List<ModelUser> daftarUser;
    public void InsertUser(){
    try {

            ModelUser UserBaru = new ModelUser();

            String nama = Formdaftar.getInputNama();
            String umur = Formdaftar.getInputUmur();
            String alamat = Formdaftar.getInputAlamat();
            String username = Formdaftar.getInputUsername();
            String password = Formdaftar.getInputPassword();

            if ("".equals(nama) || "".equals(umur) || "".equals(alamat) || "".equals(username) || "".equals(password)) {
                throw new Exception("Pastikan data diisi semua !!!");
            }
            
            UserBaru.setNama(nama);
            UserBaru.setEmail(umur);
            UserBaru.setNohp(alamat);
            UserBaru.setUsername(username);
            UserBaru.setPassword(password);

            daoUser.Insert(UserBaru);
           
            JOptionPane.showMessageDialog(null, "User baru berhasil ditambahkan.");

            Formdaftar.dispose();
            Login log = new Login();
            log.setVisible(true);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    
    }
}
