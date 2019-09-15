/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.dao;

import co.escuelatp.database.DriverDB;
import co.escuelatp.database.Utils;
import co.escuelatp.modelos.Acudiente;
import co.escuelatp.modelos.Alumno;
import co.escuelatp.modelos.Categoria;
import co.escuelatp.modelos.EstadoAlumno;
import co.escuelatp.modelos.Persona;
import co.escuelatp.modelos.TipoDocumento;
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
public class AlumnoDao {

    private final Connection connection;

    public AlumnoDao() {
        this.connection = DriverDB.getConnection();
    }

    public Alumno matricularAlumno(Alumno alumno) {
        String consulta = "insert into Personas(PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, TiposDeDocumentoId, NumeroDocumento)\n"
                + "values (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(consulta);
            stmt.setString(1, alumno.getPersona().getPrimerNombre());
            stmt.setString(2, alumno.getPersona().getSegundoNombre());
            stmt.setString(3, alumno.getPersona().getPrimerApellido());
            stmt.setString(4, alumno.getPersona().getSegundoApellido());
            stmt.setInt(5, alumno.getPersona().getTipoDocumento().getId());
            stmt.setString(6, alumno.getPersona().getNumeroDocumento());
            stmt.execute();

            PreparedStatement stemt = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
            stemt.execute();

            ResultSet resultado = stemt.getResultSet();
            if (resultado.next()) {
                int personaId = resultado.getInt("LastID");

                PreparedStatement stement = connection.prepareStatement("insert into Alumnos (Peso, Altura, Direccion, FechaDeNacimiento, FechaDeMatricula, PersonaId, CategoriaId, TallaId, EstadoId)\n"
                        + "values (?,?,?,?, current_timestamp,?, ?, ?, ?);");
               
                stement.setFloat(1, alumno.getPeso());
                stement.setFloat(2, alumno.getAltura());
                stement.setString(3, alumno.getDireccion());
                java.sql.Date fecha = new java.sql.Date(alumno.getFechaNacimiento().getTime());
                stement.setDate(4, fecha);
                stement.setInt(5, personaId);
                stement.setInt(6, alumno.getCategoria().getId());
                stement.setInt(7, alumno.getTalla().getId());
                stement.setInt(8, alumno.getEstadoAlumno().getId());
                stement.execute();
                
                PreparedStatement stementt = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
                stementt.execute();

                ResultSet resultad = stementt.getResultSet();

                if (resultad.next()) {
                    int alumnoId = resultad.getInt("LastId");
                    alumno.setId(alumnoId);
                    alumno.getPersona().setIdPersona(personaId);

                    return alumno;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return alumno;
    }
    
    public Alumno inscribirAlumno(Alumno alumno) {
        String consulta = "insert into Personas(PrimerNombre, PrimerApellido)\n"
                + "values (?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(consulta);
            stmt.setString(1, alumno.getPersona().getPrimerNombre());
            stmt.setString(2, alumno.getPersona().getPrimerApellido());
            stmt.execute();

            PreparedStatement stemt = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
            stemt.execute();

            ResultSet resultado = stemt.getResultSet();
            if (resultado.next()) {
                int personaId = resultado.getInt("LastID");

                PreparedStatement stement = connection.prepareStatement("insert into Alumnos (FechaDeInscripcion, PersonaId, EstadoId)\n"
                        + "values (current_timestamp, ?, ?);");
               
                stement.setInt(1, personaId);
                stement.setInt(2, alumno.getEstadoAlumno().getId());
                stement.execute();
                
                PreparedStatement stementt = connection.prepareStatement("SELECT Id AS LastID FROM Personas WHERE Id = @@Identity;");
                stementt.execute();

                ResultSet resultad = stementt.getResultSet();

                if (resultad.next()) {
                    int alumnoId = resultad.getInt("LastId");
                    alumno.setId(alumnoId);
                    alumno.getPersona().setIdPersona(personaId);

                    return alumno;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return alumno;
    }
    
    public ArrayList<Alumno> getAlumnos() {
        try {
            PreparedStatement stmt = connection.prepareStatement("select a.id, p.PrimerNombre, p.PrimerApellido,\n" +
                    "td.nombreCorto, p.NumeroDocumento, c.Nombre, a.FechaDeNacimiento, pp.PrimerNombre as APrimerNombre, pp.PrimerApellido as APrimerApellido, a.Direccion, ea.Nombre as Categoria\n" +
                    "from Alumnos a\n" +
                    "inner join Personas p\n" +
                    "on a.PersonaId = p.Id\n" +
                    "left join TiposDeDocumento td\n" +
                    "on p.TiposDeDocumentoId = td.id\n" +
                    "left join Categorias c\n" +
                    "on a.CategoriaId = c.id\n" +
                    "inner join Acudientes ac\n" +
                    "on ac.id = a.AcudienteId\n" +
                    "inner join Personas pp\n" +
                    "on ac.PersonaId = pp.id\n" +
                    "inner join EstadosAlumnos ea\n" +
                    "on a.EstadoId = ea.id;");
            stmt.execute();
            
            ResultSet resultado = stmt.getResultSet();
            ArrayList<Alumno> alumnos = new ArrayList<>();
            
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String primerNombre = resultado.getString("PrimerNombre");
                String primerApellido = resultado.getString("PrimerApellido");
                String numeroDocumento = resultado.getString("NumeroDocumento");
                String nombreCorto = resultado.getString("nombreCorto");
                String categoria = resultado.getString("Nombre");
                String fecNac = resultado.getString("FechaDeNacimiento");
                String aPrimerNombre = resultado.getString("APrimerNombre");
                String aPrimerApellido = resultado.getString("APrimerApellido");
                String direccion = resultado.getString("direccion");
                String estado = resultado.getString("Categoria");
                
                Persona persona = new Persona();
                Persona p = new Persona();
                Alumno alumno = new Alumno();
                Acudiente acudiente = new Acudiente();
                Categoria c = new Categoria();
                EstadoAlumno e = new EstadoAlumno();
                
                
                alumno.setId(id);
                persona.setPrimerNombre(primerNombre);
                persona.setPrimerApellido(primerApellido);
                persona.setTipoDocumento(new TipoDocumento(nombreCorto));
                persona.setNumeroDocumento(numeroDocumento);
                c.setNombre(categoria);
                alumno.setCategoria(c);
                if (fecNac != null) {
                    Date fecha = Utils.parseFecha(fecNac);
                    alumno.setFechaNacimiento(fecha);
                }
                p.setPrimerNombre(aPrimerNombre);
                p.setPrimerApellido(aPrimerApellido);
                alumno.setDireccion(direccion);
                e.setCodigo(estado);
                alumno.setEstadoAlumno(e);
                alumno.setPersona(persona);
                acudiente.setPersona(p);
                alumno.setAcudiente(acudiente);
                
                alumnos.add(alumno);
            }
            return alumnos;
        }catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
