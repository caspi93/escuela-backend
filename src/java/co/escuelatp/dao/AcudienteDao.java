/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.dao;

import co.escuelatp.database.DriverDB;
import co.escuelatp.modelos.Acudiente;
import co.escuelatp.modelos.Genero;
import co.escuelatp.modelos.Persona;
import co.escuelatp.modelos.TipoDocumento;
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
    
    public boolean editarAcudiente(Acudiente acudiente ) {
        try {
            PreparedStatement stmt = connection.prepareStatement("update Personas set PrimerNombre = ?, SegundoNombre = ?, PrimerApellido = ?, \n" +
                "SegundoApellido = ?, GeneroId = ?, TiposDeDocumentoId = ?, NumeroDocumento = ?\n" +
                "where Id = ?;");
            stmt.setString(1, acudiente.getPersona().getPrimerNombre());
            stmt.setString(2, acudiente.getPersona().getSegundoNombre());
            stmt.setString(3, acudiente.getPersona().getPrimerApellido());
            stmt.setString(4, acudiente.getPersona().getSegundoApellido());
            stmt.setInt(5, acudiente.getPersona().getGenero().getId());
            stmt.setInt(6, acudiente.getPersona().getTipoDocumento().getId());
            stmt.setString(7, acudiente.getPersona().getNumeroDocumento());
            stmt.setInt(8, acudiente.getPersona().getIdPersona());
            System.out.println("la id es: " + acudiente.getPersona().getIdPersona());
            stmt.executeUpdate();
            
            PreparedStatement stment = connection.prepareStatement("update Acudientes set Correo = ?, Celular = ?\n" +
                "where id = ?;");
            stment.setString(1, acudiente.getCorreo());
            stment.setString(2, acudiente.getCelular());
            stment.setInt(3, acudiente.getId());
            stment.executeUpdate();
 
            return true;
             
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Acudiente getAcudiente(int idAcudiente) {
        Acudiente ac = null;

        String consulta = "select * from Acudientes ac\n"
                + "inner join Personas p\n"
                + "on ac.PersonaId = p.Id\n"
                + "inner join Generos g\n"
                + "on p.GeneroId = g.id\n"
                + "left join TiposDeDocumento td\n"
                + "on p.TiposDeDocumentoId = td.id\n"
                + "where ac.id = ?;";
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(consulta);
            statement.setInt(1, idAcudiente);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int idPersona = result.getInt("PersonaId");
                String pimerNombre = result.getString("primerNombre");
                String segundoNombre = result.getString("SegundoNombre");
                String primerApellido = result.getString("PrimerApellido");
                String segundoApellido = result.getString("SegundoApellido");
                int tipoDeDocumentoId = result.getInt("TiposDeDocumentoId");
                String numeroDocumento = result.getString("NumeroDocumento");
                int generoId = result.getInt("GeneroId");
                String correo = result.getString("Correo");
                String celular = result.getString("Celular");



                ac = new Acudiente(idAcudiente);
                Persona p = new Persona(idPersona);
                

                p.setPrimerNombre(pimerNombre);
                p.setSegundoNombre(segundoNombre);
                p.setPrimerApellido(primerApellido);
                p.setSegundoApellido(segundoApellido);
                p.setTipoDocumento(new TipoDocumento(tipoDeDocumentoId));
                p.setNumeroDocumento(numeroDocumento);
                p.setGenero(new Genero(generoId));
                ac.setCelular(celular);
                ac.setCorreo(correo);
                ac.setPersona(p);
         
            }

        } catch (Exception ex) {
            Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ac;
    }
    
    public boolean eliminarAcudiente(Acudiente ac) {

        String consulta = "delete from Acudientes where id = ?;";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(consulta);
            statement.setInt(1, ac.getId());
            
            statement.execute();
                      
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AcudienteDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
