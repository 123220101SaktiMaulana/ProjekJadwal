/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Jadwal;

import java.util.List;

/**
 *
 * @author Aibra
 */
public interface InterfaceDaoJadwal {
    public void Insert (ModelJadwal jadwal);
    
    public void Update (ModelJadwal jadwal);
    
    public void Delete (int id);
    
    public List<ModelJadwal> getAll();
    
    public List<ModelJadwal> Search(String nama);
    
    public List<ModelJadwal> Filter(String kelas);
}
