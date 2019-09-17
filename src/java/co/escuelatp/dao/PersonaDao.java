/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.dao;

import co.escuelatp.database.DriverDB;
import co.escuelatp.modelos.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luisk
 */
public class PersonaDao {
    
    private final Connection connection;

    public PersonaDao() {
        this.connection = DriverDB.getConnection();;
    }
    
    public boolean eliminarPersona(Persona p) {

        String consulta = "delete from Personas where id = ?;";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(consulta);
            statement.setInt(1, p.getIdPersona());
            
            statement.execute();
                      
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
    
}
