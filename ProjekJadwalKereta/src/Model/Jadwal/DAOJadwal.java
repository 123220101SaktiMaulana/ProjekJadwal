/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Jadwal;

import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aibra
 */
public class DAOJadwal implements InterfaceDaoJadwal{

    @Override
    public void Insert(ModelJadwal jadwal) {
        try {
            String query = "INSERT INTO jadwal (nama_kereta, kelas, tujuan, waktu_berangkat) VALUES (?, ?, ?, ?);";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, jadwal.getNama_kereta());
            statement.setString(2, jadwal.getKelas());
            statement.setString(3, jadwal.getTujuan());
            statement.setString(4, jadwal.getWaktu_berangkat());
            
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void Update(ModelJadwal jadwal) {
        try {
            String query = "UPDATE jadwal SET nama_kereta=?, tujuan=?, kelas=?, waktu_berangkat=? WHERE id_jadwal=?;";
            
            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, jadwal.getNama_kereta());
            statement.setString(2, jadwal.getTujuan());
            statement.setString(3, jadwal.getKelas());
            statement.setString(4, jadwal.getWaktu_berangkat());
            statement.setInt(5, jadwal.getId_jadwal());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void Delete(int id) {
        try {
            String query = "DELETE FROM jadwal WHERE id_jadwal=?;";

            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelJadwal> getAll() {
        List<ModelJadwal> listJadwal = null;
  
        try {
            listJadwal = new ArrayList<>();
            
            Statement statement = Connector.Koneksi().createStatement();
            
            String query = "SELECT * FROM jadwal;";
            
            ResultSet resultSet = statement.executeQuery(query);
           
            while (resultSet.next()) {
                ModelJadwal jwl = new ModelJadwal();
                
                jwl.setId_jadwal(resultSet.getInt("id_jadwal"));
                jwl.setNama_kereta(resultSet.getString("nama_kereta"));
                jwl.setTujuan(resultSet.getString("tujuan"));
                jwl.setKelas(resultSet.getString("kelas"));
                jwl.setWaktu_berangkat(resultSet.getString("waktu_berangkat"));
                
                listJadwal.add(jwl);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listJadwal;
    }

    @Override
    public List<ModelJadwal> Search(String nama) {
        List<ModelJadwal> listJadwal = new ArrayList<>();

        try {
            String query = "SELECT * FROM jadwal WHERE nama_kereta LIKE ?";
            PreparedStatement statement = Connector.Koneksi().prepareStatement(query);

            // Menambahkan wildcard (%) untuk mencari kata yang mengandung nama
            statement.setString(1, "%" + nama + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ModelJadwal jwl = new ModelJadwal();

                jwl.setId_jadwal(resultSet.getInt("id_jadwal"));
                jwl.setNama_kereta(resultSet.getString("nama_kereta"));
                jwl.setTujuan(resultSet.getString("tujuan"));
                jwl.setKelas(resultSet.getString("kelas"));
                jwl.setWaktu_berangkat(resultSet.getString("waktu_berangkat"));

                listJadwal.add(jwl);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Search Failed: " + e.getMessage());
        }

        return listJadwal;
    }

    @Override
    public List<ModelJadwal> Filter(String kelas) {
        List<ModelJadwal> listJadwal = new ArrayList<>();

        try {
            String query = "SELECT * FROM jadwal WHERE kelas LIKE ?";
            PreparedStatement statement = Connector.Koneksi().prepareStatement(query);

            // Menambahkan wildcard (%) untuk mencari kata yang mengandung nama
            statement.setString(1, "%" + kelas + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ModelJadwal jwl = new ModelJadwal();

                jwl.setId_jadwal(resultSet.getInt("id_jadwal"));
                jwl.setNama_kereta(resultSet.getString("nama_kereta"));
                jwl.setTujuan(resultSet.getString("tujuan"));
                jwl.setKelas(resultSet.getString("kelas"));
                jwl.setWaktu_berangkat(resultSet.getString("waktu_berangkat"));

                listJadwal.add(jwl);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Search Failed: " + e.getMessage());
        }

        return listJadwal;
    }

}
    

