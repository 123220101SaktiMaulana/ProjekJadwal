/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Jadwal.DAOJadwal;
import Model.Jadwal.InterfaceDaoJadwal;
import Model.Jadwal.ModelJadwal;
import Model.Jadwal.ModelTableJadwal;
import View.HalamanUtamaJadwal;
import View.Jadwal.EditData;
import View.Jadwal.TambahData;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aibra
 */
public class ControllerJadwal {
    HalamanUtamaJadwal homepage;
    TambahData halamanInput;
    EditData halamanEdit;
    
    
    InterfaceDaoJadwal daoJadwal;
    
     List<ModelJadwal> daftarJadwal;
     
     public ControllerJadwal(HalamanUtamaJadwal homepage) {
        this.homepage = homepage;
        this.daoJadwal = new DAOJadwal();
    }
     
    public ControllerJadwal(TambahData halamanInput){
        this.halamanInput = halamanInput;
        this.daoJadwal = new DAOJadwal();
    }
    
    public ControllerJadwal(EditData halamanEdit){
        this.halamanEdit = halamanEdit;
        this.daoJadwal = new DAOJadwal();
        
    }
    
    
     
     public void showAllJadwal() {
         System.out.println("Tes Show All");

        daftarJadwal = daoJadwal.getAll();

        ModelTableJadwal table = new ModelTableJadwal(daftarJadwal);

        homepage.getTabeltampil().setModel(table);
    }
     
     public void Insert(String kelas) {
    try {
        ModelJadwal JadwalBaru = new ModelJadwal();

        String nama = halamanInput.getInputNama_kereta();
        String tujuan = halamanInput.getInputTujuan();
        String berangkat = halamanInput.getInputWaktu_berangkat();

        if ("".equals(nama) || "".equals(tujuan) || "".equals(kelas) || "".equals(berangkat)) {
            throw new Exception("Data diisi Tidak boleh kosong!");
        }

        JadwalBaru.setNama_kereta(nama);
        JadwalBaru.setTujuan(tujuan);
        JadwalBaru.setKelas(kelas); // Menggunakan nilai kelas yang diterima dari parameter
        JadwalBaru.setWaktu_berangkat(berangkat);

        daoJadwal.Insert(JadwalBaru);

        JOptionPane.showMessageDialog(null, "Jadwal Baru berhasil ditambahkan.");

        halamanInput.dispose();

        HalamanUtamaJadwal homepage = new HalamanUtamaJadwal();
        homepage.setVisible(true);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}

     
     public void EditDosen(int id, String Kelas){
       try {
           
                ModelJadwal jadwaledit = new ModelJadwal();
           
                String nama = halamanEdit.getInputNama_kereta();
                String tujuan = halamanEdit.getInputTujuan();
                String berangkat = halamanEdit.getInputWaktu_berangkat();

                if ("".equals(nama) || "".equals(tujuan) || "".equals(Kelas) || "".equals(berangkat)) {
                    throw new Exception("Data tidak boleh kosong!");
                }
                
                jadwaledit.setId_jadwal(id);
                jadwaledit.setNama_kereta(nama);
                jadwaledit.setTujuan(tujuan);
                jadwaledit.setKelas(Kelas);
                jadwaledit.setWaktu_berangkat(berangkat);
                
                daoJadwal.Update(jadwaledit);

                JOptionPane.showMessageDialog(null, "Berhasil mengedit data.");

                halamanEdit.dispose();
                HalamanUtamaJadwal homepage= new HalamanUtamaJadwal();
                homepage.setVisible(true);
                homepage.setLocationRelativeTo(null);
                
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage());
            }
   }
     
     public void deleteJadwal(Integer baris){
        Integer id = (int) homepage.getTabeltampil().getValueAt(baris, 0);
        String nama = homepage.getTabeltampil().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null, 
                "Hapus " + nama + "?", 
                "Hapus Jadwal", 
                JOptionPane.YES_NO_OPTION
        );
        if (input == 0) {
           daoJadwal.Delete(id);

            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            
            showAllJadwal();
        }
   }
     
     
   public void search(String nama){
    daftarJadwal = daoJadwal.Search(nama);
    ModelTableJadwal table = new ModelTableJadwal(daftarJadwal);
    homepage.getTabeltampil().setModel(table);
}
   
   public void Filter(String kelas){
    daftarJadwal = daoJadwal.Filter(kelas);
    ModelTableJadwal table = new ModelTableJadwal(daftarJadwal);
    homepage.getTabeltampil().setModel(table);
}


}
