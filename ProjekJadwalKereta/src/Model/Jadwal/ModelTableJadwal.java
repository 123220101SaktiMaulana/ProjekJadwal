/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Jadwal;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aibra
 */
public class ModelTableJadwal extends AbstractTableModel{

    List<ModelJadwal> daftarJadwal;
    
    String kolom[] = {"ID","Nama Kereta","Tujuan","Kelas","waktu_berangkat"};
    
    
    public ModelTableJadwal(List<ModelJadwal> daftarJadwal) {
        this.daftarJadwal = daftarJadwal;
    }
    @Override
    public int getRowCount() {
        return daftarJadwal.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return daftarJadwal.get(rowIndex).getId_jadwal();
            case 1:
                return daftarJadwal.get(rowIndex).getNama_kereta();
            case 2:
                return daftarJadwal.get(rowIndex).getTujuan();
            case 3:
                return daftarJadwal.get(rowIndex).getKelas();
            case 4:
                return daftarJadwal.get(rowIndex).getWaktu_berangkat();
            default:
                return null;           
        }  
    }
    @Override
        public String getColumnName(int columnIndex){
            return kolom[columnIndex];
        }
    
}
