/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Jadwal;

/**
 *
 * @author Aibra
 */
public class ModelJadwal {
    private Integer id_jadwal;
    private String nama_kereta, tujuan, kelas, waktu_berangkat;

    public Integer getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(Integer id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getNama_kereta() {
        return nama_kereta;
    }

    public void setNama_kereta(String nama_kereta) {
        this.nama_kereta = nama_kereta;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getWaktu_berangkat() {
        return waktu_berangkat;
    }

    public void setWaktu_berangkat(String waktu_berangkat) {
        this.waktu_berangkat = waktu_berangkat;
    }
    
    
}
