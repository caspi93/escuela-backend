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
import co.escuelatp.modelos.Talla;
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

                PreparedStatement stement = connection.prepareStatement("insert into Alumnos (Peso, Altura, Direccion, FechaDeNacimiento, FechaDeMatricula, PersonaId, CategoriaId, TallaId, EstadoId, AcudienteId)\n"
                        + "values (?,?,?,?, current_timestamp,?, ?, ?, ?, ?);");

                stement.setFloat(1, alumno.getPeso());
                stement.setFloat(2, alumno.getAltura());
                stement.setString(3, alumno.getDireccion());
                java.sql.Date fecha = new java.sql.Date(alumno.getFechaNacimiento().getTime());
                stement.setDate(4, fecha);
                stement.setInt(5, personaId);
                stement.setInt(6, alumno.getCategoria().getId());
                stement.setInt(7, alumno.getTalla().getId());
                stement.setInt(8, alumno.getEstadoAlumno().getId());
                stement.setInt(9, alumno.getAcudiente().getId());
                stement.execute();

                PreparedStatement stementt = connection.prepareStatement("SELECT Id AS LastID FROM Alumnos WHERE Id = @@Identity;");
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

                PreparedStatement stement = connection.prepareStatement("insert into Alumnos (FechaDeInscripcion, PersonaId, EstadoId, AcudienteId)\n"
                        + "values (current_timestamp, ?, ?, ?);");

                stement.setInt(1, personaId);
                stement.setInt(2, alumno.getEstadoAlumno().getId());
                stement.setInt(3, alumno.getAcudiente().getId());
                System.out.println("La id del acudiente es: " + alumno.getAcudiente().getId());
                stement.execute();

                PreparedStatement stementt = connection.prepareStatement("SELECT Id AS LastID FROM Alumnos WHERE Id = @@Identity;");
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
            PreparedStatement stmt = connection.prepareStatement("select a.id, p.PrimerNombre, p.PrimerApellido,\n"
                    + "td.nombreCorto, p.NumeroDocumento, c.Nombre as Categoria, a.FechaDeNacimiento, pp.PrimerNombre as APrimerNombre, pp.PrimerApellido as APrimerApellido, a.Direccion, ea.Nombre as Estado, EstadoId\n"
                    + "from Alumnos a\n"
                    + "inner join Personas p\n"
                    + "on a.PersonaId = p.Id\n"
                    + "left join TiposDeDocumento td\n"
                    + "on p.TiposDeDocumentoId = td.id\n"
                    + "left join Categorias c\n"
                    + "on a.CategoriaId = c.id\n"
                    + "inner join Acudientes ac\n"
                    + "on ac.id = a.AcudienteId\n"
                    + "inner join Personas pp\n"
                    + "on ac.PersonaId = pp.id\n"
                    + "inner join EstadosAlumnos ea\n"
                    + "on a.EstadoId = ea.id;");
            stmt.execute();

            ResultSet resultado = stmt.getResultSet();
            ArrayList<Alumno> alumnos = new ArrayList<>();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String primerNombre = resultado.getString("PrimerNombre");
                String primerApellido = resultado.getString("PrimerApellido");
                String numeroDocumento = resultado.getString("NumeroDocumento");
                String nombreCorto = resultado.getString("nombreCorto");
                String categoria = resultado.getString("Categoria");
                String fecNac = resultado.getString("FechaDeNacimiento");
                String aPrimerNombre = resultado.getString("APrimerNombre");
                String aPrimerApellido = resultado.getString("APrimerApellido");
                String direccion = resultado.getString("direccion");
                String estado = resultado.getString("Estado");
                int estadoId = resultado.getInt("EstadoId");

                Persona persona = new Persona();
                Persona p = new Persona();
                Alumno alumno = new Alumno();
                Acudiente acudiente = new Acudiente();
                Categoria c = new Categoria();
                EstadoAlumno e = new EstadoAlumno(estadoId);

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
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean editarAlumno(Alumno alumno) {
        System.out.println("estamos jodidos y medio");
        try {
            PreparedStatement stmt = connection.prepareStatement("update Personas set PrimerNombre = ?, SegundoNombre = ?, PrimerApellido = ?,\n"
                    + "SegundoApellido = ?, TiposDeDocumentoId = ?, NumeroDocumento = ?\n"
                    + "where Id = ?;");
            stmt.setString(1, alumno.getPersona().getPrimerNombre());
            stmt.setString(2, alumno.getPersona().getSegundoNombre());
            stmt.setString(3, alumno.getPersona().getPrimerApellido());
            stmt.setString(4, alumno.getPersona().getSegundoApellido());
            stmt.setInt(5, alumno.getPersona().getTipoDocumento().getId());
            stmt.setString(6, alumno.getPersona().getNumeroDocumento());
            stmt.setInt(7, alumno.getPersona().getIdPersona());
            stmt.executeUpdate();

            String consulta;
            if (alumno.getEstadoAlumno() == null) {
                consulta = "update Alumnos set Peso = ?, Altura = ?,\n"
                        + "TallaId = ?, CategoriaId = ?, Direccion = ?, FechaDeNacimiento = ?\n"
                        + "where id = ?;";
            } else {
                consulta = "update Alumnos set Peso = ?, Altura = ?,\n"
                        + "TallaId = ?, CategoriaId = ?, Direccion = ?, FechaDeNacimiento = ?, EstadoId = ?\n"
                        + "where id = ?;";
            }

            PreparedStatement stment = connection.prepareStatement(consulta);

            stment.setFloat(1, alumno.getPeso());
            stment.setFloat(2, alumno.getAltura());
            stment.setInt(3, alumno.getTalla().getId());
            stment.setInt(4, alumno.getCategoria().getId());
            stment.setString(5, alumno.getDireccion());
            java.sql.Date fecha = new java.sql.Date(alumno.getFechaNacimiento().getTime());
            stment.setDate(6, fecha);
            if (alumno.getEstadoAlumno() == null) {
                stment.setInt(7, alumno.getId());
            } else {
                stment.setInt(7, alumno.getEstadoAlumno().getId());
                stment.setInt(8, alumno.getId());
            }
            stment.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Alumno getAlumno(int idAlumno) {

        Alumno a = null;

        String consulta = "select * from Alumnos a\n"
                + "inner join Personas p\n"
                + "on a.PersonaId = p.Id\n"
                + "left join Tallas t\n"
                + "on a.TallaId = t.id\n"
                + "left join Categorias c\n"
                + "on a.CategoriaId = c.id\n"
                + "where a.id = ?;";
        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement(consulta);
            statement.setInt(1, idAlumno);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int idPersona = result.getInt("PersonaId");
                int idAcudiente = result.getInt("AcudienteId");
                String pimerNombre = result.getString("primerNombre");
                String segundoNombre = result.getString("SegundoNombre");
                String primerApellido = result.getString("PrimerApellido");
                String segundoApellido = result.getString("SegundoApellido");
                int tipoDeDocumentoId = result.getInt("TiposDeDocumentoId");
                String numeroDocumento = result.getString("NumeroDocumento");
                int tallaId = result.getInt("TallaId");
                int categoriaId = result.getInt("CategoriaId");
                String direccion = result.getString("Direccion");
                float peso = result.getFloat("Peso");
                float altura = result.getFloat("Altura");

                a = new Alumno(idAlumno);
                Talla talla = new Talla(tallaId);
                Categoria categoria = new Categoria(categoriaId);
                Persona p = new Persona(idPersona);
                Acudiente ac = new Acudiente(idAcudiente);

                p.setPrimerNombre(pimerNombre);
                p.setSegundoNombre(segundoNombre);
                p.setPrimerApellido(primerApellido);
                p.setSegundoApellido(segundoApellido);
                p.setTipoDocumento(new TipoDocumento(tipoDeDocumentoId));
                p.setNumeroDocumento(numeroDocumento);
                a.setCategoria(new Categoria(categoriaId));
                a.setTalla(new Talla(tallaId));
                a.setDireccion(direccion);
                a.setPeso(peso);
                a.setAltura(altura);
                a.setPersona(p);
                a.setCategoria(categoria);
                a.setTalla(talla);
                a.setAcudiente(ac);
            }

        } catch (Exception ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return a;
    }

    public boolean eliminarAlumno(Alumno a) {

        String consulta = "delete from Alumnos where id = ?;";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(consulta);
            statement.setInt(1, a.getId());

            statement.execute();

            return true;
        } catch (Exception ex) {
            Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AlumnoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
