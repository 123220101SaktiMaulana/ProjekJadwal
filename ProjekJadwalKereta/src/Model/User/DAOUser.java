/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.User;

import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aibra
 */
public class DAOUser implements InterfaceUser{

    @Override
    public void Insert(ModelUser user) {
        try {
            String query = "INSERT INTO user (nama, Email, nohp, username, password) VALUES (?, ?, ?, ?, ?);";
            

            PreparedStatement statement;
            statement = Connector.Koneksi().prepareStatement(query);
            statement.setString(1, user.getNama());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getNohp());
            statement.setString(4, user.getUsername());
            statement.setString(5, user.getPassword());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }  
}
