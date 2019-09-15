/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.dao;

import co.escuelatp.database.DriverDB;
import co.escuelatp.modelos.Acudiente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AcudienteDao {

    private final Connection connection;

    public AcudienteDao() {
        this.connection = DriverDB.getConnection();;
    }

    public Acudiente crearAcudiente(Acudiente acudiente) {
        
        String consult = "insert into Personas(PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, TiposDeDocumentoId, NumeroDocumento, GeneroId)\n"
                    + "values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stt = null;
        try {
            stt = connection.prepareStatement(consult);
            stt.setString(1, acudiente.getPersona().getPrimerNombre());
            stt.setString(2, acudiente.getPersona().getSegundoNombre());
            stt.setString(3, acudiente.getPersona().getPrimerApellido());
            stt.setString(4, acudiente.getPersona().getSegundoApellido());
            stt.setInt(5, acudiente.getPersona().getTipoDocumento().getId());
            stt.setString(6, acudiente.getPersona().getNumeroDocumento());
            stt.setInt(7, acudiente.getPersona().getGenero().getId());
            stt.execute();

            PreparedStatement st = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
            st.execute();

            ResultSet r = st.getResultSet();
            if (r.next()) {
                int personaId = r.getInt("LastID");

                PreparedStatement sta = connection.prepareStatement("insert into Acudientes (correo, celular, PersonaId)\n"
                        + "values (?, ?, ?);");
                sta.setString(1, acudiente.getCorreo());
                sta.setString(2, acudiente.getCelular());
                sta.setInt(3, personaId);
                sta.execute();
                
                PreparedStatement stementt = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
                stementt.execute();

                ResultSet resultad = stementt.getResultSet();

                if (resultad.next()) {
                    int acudienteId = resultad.getInt("LastId");
                    acudiente.setId(acudienteId);
                    acudiente.getPersona().setIdPersona(personaId);

                    return acudiente;
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stt != null) {
                try {
                    stt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return acudiente;
    
    }
    
    public Acudiente inscribirAcudiente(Acudiente acudiente) {
        
        String consult = "insert into Personas(PrimerNombre,PrimerApellido, GeneroId)\n"
                    + "values (?, ?, ?);";
            PreparedStatement stt = null;
        try {
            stt = connection.prepareStatement(consult);
            stt.setString(1, acudiente.getPersona().getPrimerNombre());
            stt.setString(2, acudiente.getPersona().getPrimerApellido());
            stt.setInt(3, acudiente.getPersona().getGenero().getId());
            stt.execute();

            PreparedStatement st = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
            st.execute();

            ResultSet r = st.getResultSet();
            if (r.next()) {
                int personaId = r.getInt("LastID");

                PreparedStatement sta = connection.prepareStatement("insert into Acudientes (correo, celular, PersonaId)\n"
                        + "values (?, ?, ?);");
                sta.setString(1, acudiente.getCorreo());
                sta.setString(2, acudiente.getCelular());
                sta.setInt(3, personaId);
                sta.execute();
                
                PreparedStatement stementt = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
                stementt.execute();

                ResultSet resultad = stementt.getResultSet();

                if (resultad.next()) {
                    int acudienteId = resultad.getInt("LastId");
                    acudiente.setId(acudienteId);
                    acudiente.getPersona().setIdPersona(personaId);

                    return acudiente;
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stt != null) {
                try {
                    stt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return acudiente;
    
    }
}
