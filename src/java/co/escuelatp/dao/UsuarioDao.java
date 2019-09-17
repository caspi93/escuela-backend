/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.dao;

import co.escuelatp.database.DriverDB;
import co.escuelatp.modelos.Genero;
import co.escuelatp.modelos.Permiso;
import co.escuelatp.modelos.Rol;
import co.escuelatp.modelos.TipoDocumento;
import co.escuelatp.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UsuarioDao {

    private final Connection connection;
    ArrayList<Permiso> permisos;

    public UsuarioDao() {
        this.connection = DriverDB.getConnection();;
    }

    public Usuario login(String nombreUsuario, String clave) {
        Usuario u = null;

        String consulta = "select * from Usuarios u\n"
                + "inner join Personas p\n"
                + "on u.PersonaId = p.Id\n"
                + "inner join Roles r\n"
                + "on u.RolId = r.id\n"
                + "where u.NombreUsuario = ? and u.Clave = ?;";
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(consulta);
            statement.setString(1, nombreUsuario);
            statement.setString(2, clave);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
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
                String rolNombre = result.getString("nombre");
                String correo = result.getString("Correo");
                String celular = result.getString("Celular");

                u = new Usuario(id, idPersona);
                Rol r = new Rol(rolId);

                u.setPrimerNombre(pimerNombre);
                u.setSegundoNombre(segundoNombre);
                u.setPrimerApellido(primerApellido);
                u.setSegundoApellido(segundoApellido);
                u.setNombreUsuario(u.getNombreUsuario());
                u.setTipoDocumento(new TipoDocumento(tipoDeDocumentoId));
                u.setNumeroDocumento(numeroDocumento);
                u.setGenero(new Genero(generoId));
                u.setRol(r);
                u.setCorreo(correo);
                u.setCelular(celular);

                r.setNombre(rolNombre);

                consulta = "select * from Permisos p\n"
                        + "inner join PermisosPorRoles pr\n"
                        + "on pr.idPermisos = p.id\n"
                        + "where pr.idRol = ?;";
                statement = connection.prepareStatement(consulta);
                statement.setInt(1, rolId);

                ResultSet resultado = statement.executeQuery();

                while (resultado.next()) {
                    int permisoId = resultado.getInt("id");
                    String codigo = resultado.getString("Codigo");
                    Permiso p = new Permiso(permisoId, codigo);

                    r.asignarPermisos(p);

                }
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return u;
    }

    public Usuario crearUsuario(Usuario usuario) {
        String consulta = "insert into Personas(PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, TiposDeDocumentoId, NumeroDocumento, GeneroId)\n"
                + "values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(consulta);
            stmt.setString(1, usuario.getPrimerNombre());
            stmt.setString(2, usuario.getSegundoNombre());
            stmt.setString(3, usuario.getPrimerApellido());
            stmt.setString(4, usuario.getSegundoApellido());
            stmt.setInt(5, usuario.getTipoDocumento().getId());
            stmt.setString(6, usuario.getNumeroDocumento());
            stmt.setInt(7, usuario.getGenero().getId());
            stmt.execute();

            PreparedStatement stment = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
            stment.execute();

            ResultSet resultado = stment.getResultSet();

            if (resultado.next()) {
                int personaId = resultado.getInt("LastID");

                PreparedStatement stement = connection.prepareStatement("insert into Usuarios (PersonaId, Correo, Celular, NombreUsuario, Clave, RolId)\n"
                        + "values (?,?,?,?,?,?);");

                stement.setInt(1, personaId);
                stement.setString(2, usuario.getCorreo());
                stement.setString(3, usuario.getCelular());
                stement.setString(4, usuario.getNombreUsuario());
                stement.setString(5, usuario.getClave());
                stement.setInt(6, usuario.getRol().getId());
                stement.execute();

                PreparedStatement stementt = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
                stementt.execute();

                ResultSet resultad = stementt.getResultSet();

                if (resultad.next()) {
                    int usuarioId = resultad.getInt("LastId");
                    usuario.setId(usuarioId);
                    usuario.setIdPersona(personaId);

                    return usuario;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return usuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        try {
            PreparedStatement stmt = connection.prepareStatement("select *\n"
                    + "from Usuarios u\n"
                    + "inner join Personas p\n"
                    + "on u.PersonaId = p.Id\n"
                    + "inner join Roles r\n"
                    + "on u.RolId = r.id\n"
                    + "inner join TiposDeDocumento td\n"
                    + "on p.TiposDeDocumentoId = td.id\n"
                    + "inner join Generos g\n"
                    + "on p.GeneroId = g.id;");
            stmt.execute();

            ResultSet resultado = stmt.getResultSet();
            ArrayList<Usuario> usuarios = new ArrayList<>();

            while (resultado.next()) {

                int id = resultado.getInt("id");
                int personaId = resultado.getInt("PersonaId");
                String primerNombre = resultado.getString("PrimerNombre");
                String segundoNombre = resultado.getString("SegundoNombre");
                String primerApellido = resultado.getString("PrimerApellido");
                String segundoApellido = resultado.getString("SegundoApellido");
                int tipoDocumentoId = resultado.getInt("tiposDeDocumentoId");
                String numeroDocumento = resultado.getString("NumeroDocumento");
                String nombreCorto = resultado.getString("nombreCorto");
                int generoId = resultado.getInt("GeneroId");
                String nombre = resultado.getString(18);
                int rolId = resultado.getInt("RolId");
                String nombreRol = resultado.getString(18);
                String nombreUsuario = resultado.getString("nombreUsuario");
                String clave = resultado.getString("Clave");
                String direccion = resultado.getString("direccion");
                String correo = resultado.getString("Correo");
                String celular = resultado.getString("Celular");

                Usuario usuario = new Usuario();

                usuario.setId(id);
                usuario.setIdPersona(personaId);
                usuario.setPrimerNombre(primerNombre);
                usuario.setSegundoNombre(segundoNombre);
                usuario.setPrimerApellido(primerApellido);
                usuario.setSegundoApellido(segundoApellido);
                usuario.setTipoDocumento(new TipoDocumento(tipoDocumentoId, nombreCorto));
                usuario.setNumeroDocumento(numeroDocumento);
                usuario.setGenero(new Genero(generoId, nombre));
                usuario.setRol(new Rol(rolId, nombreRol));
                usuario.setDireccion(direccion);
                usuario.setCorreo(correo);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setClave(clave);
                usuario.setCelular(celular);
                usuarios.add(usuario);
            }
            return usuarios;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean editarUsuarios(Usuario usuario) {
        System.out.println("estamos jodidos y medio");
        try {
            PreparedStatement stmt = connection.prepareStatement("update Personas set PrimerNombre = ?, SegundoNombre = ?, PrimerApellido = ?, SegundoApellido = ?, \n"
                    + "TiposDeDocumentoId = ?, NumeroDocumento = ?, Direccion = ?\n"
                    + "where Id = ?;");
            System.out.println("estamos jodidos");
            stmt.setString(1, usuario.getPrimerNombre());
            stmt.setString(2, usuario.getSegundoNombre());
            stmt.setString(3, usuario.getPrimerApellido());
            stmt.setString(4, usuario.getSegundoApellido());
            stmt.setInt(5, usuario.getTipoDocumento().getId());
            stmt.setString(6, usuario.getNumeroDocumento());
            stmt.setString(7, usuario.getDireccion());
            stmt.setInt(8, usuario.getIdPersona());
            System.out.println("la id es: " + usuario.getIdPersona());
            stmt.executeUpdate();

            System.out.println("estamos un poco jodidos");
            PreparedStatement stment = connection.prepareStatement("update Usuarios set Correo = ?, Celular = ?,\n"
                    + "NombreUsuario = ?, Clave = ?,\n"
                    + "RolId = ? where id = ?;");

            System.out.println("estamos un poquito jodidos");
            stment.setString(1, usuario.getCorreo());
            stment.setString(2, usuario.getCelular());
            stment.setString(3, usuario.getNombreUsuario());
            stment.setString(4, usuario.getClave());
            stment.setInt(5, usuario.getRol().getId());
            stment.setInt(6, usuario.getId());
            stment.executeUpdate();
            System.out.println("vamos mejorando");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Usuario getUsuario(int idUsuario) {

        Usuario u = null;

        String consulta = "select * from Usuarios u\n"
                + "inner join Personas p\n"
                + "on u.PersonaId = p.Id\n"
                + "where u.id = ?;";
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(consulta);
            statement.setInt(1, idUsuario);

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
                int rolId = result.getInt("RolId");
                String correo = result.getString("Correo");
                String celular = result.getString("Celular");
                String nombreUsuario = result.getString("NombreUsuario");

                u = new Usuario(idUsuario, idPersona);
                Rol r = new Rol(rolId);

                u.setPrimerNombre(pimerNombre);
                u.setSegundoNombre(segundoNombre);
                u.setPrimerApellido(primerApellido);
                u.setSegundoApellido(segundoApellido);
                u.setTipoDocumento(new TipoDocumento(tipoDeDocumentoId));
                u.setNumeroDocumento(numeroDocumento);
                u.setGenero(new Genero(generoId));
                u.setRol(r);
                u.setCorreo(correo);
                u.setCelular(celular);
                u.setNombreUsuario(nombreUsuario);
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return u;
    }

    public boolean eliminarUsuario(Usuario u) {

        String consulta = "delete from Usuarios where id = ?;";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(consulta);
            statement.setInt(1, u.getId());
            
            statement.execute();
                      
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
