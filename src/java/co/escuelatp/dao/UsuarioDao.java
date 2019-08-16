/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.dao;

import co.escuelatp.database.DriverDB;
import co.escuelatp.modelos.Genero;
import co.escuelatp.modelos.Rol;
import co.escuelatp.modelos.TipoDocumento;
import co.escuelatp.modelos.Usuario;
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
public class UsuarioDao {
    private final Connection connection;
    
    public UsuarioDao(){
        this.connection = DriverDB.getConnection();;
    }
    
    public Usuario login(String nombreUsuario, String clave){
        System.out.println(nombreUsuario + " -- " + clave);
        Usuario u = null;
        
        
        String consulta = "select * from Usuarios u\n" +
            "inner join Personas p\n" +
            "on u.PersonaId = p.Id\n" +
            "where u.NombreUsuario = ? and u.Clave = ?;";
        PreparedStatement statement = null;
                    
        try { 
            
            statement = connection.prepareStatement(consulta);
            statement.setString(1, nombreUsuario);
            statement.setString(2, clave);
            
            ResultSet result = statement.executeQuery();

            if(result.next()){
                int id = result.getInt("id");
                int idPersona = result.getInt("PersonaId");
                String pimerNombre = result.getString("primerNombre");
                String segundoNombre = result.getString("SegundoNombre");
                String primerApellido = result.getString("PrimerApellido");
                String segundoApellido = result.getString("SegundoApellido");
                int tipoDeDocumentoId = result.getInt("TiposDeDocumentoId");
                String numeroDocumento = result.getString("NumeroDocumento");
                int generoId = result.getInt("GeneroId");
                int rolId = result.getInt("RolId");
                String correo = result.getString("Correo");
                String celular = result.getString("Celular");
                
                u = new Usuario(id, idPersona);
                
                u.setPrimerNombre(pimerNombre);
                u.setSegundoNombre(segundoNombre);
                u.setPrimerApellido(primerApellido);
                u.setSegundoApellido(segundoApellido);
                u.setNombreUsuario(u.getNombreUsuario());
                u.setTipoDocumento(new TipoDocumento(tipoDeDocumentoId));
                u.setNumeroDocumento(numeroDocumento);
                u.setGenero(new Genero(generoId));
                u.setRol(new Rol(rolId));
                u.setCorreo(correo);
                u.setCelular(celular);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            
        return u;
    }
}
