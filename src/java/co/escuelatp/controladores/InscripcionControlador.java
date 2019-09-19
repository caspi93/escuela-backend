/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

import co.escuelatp.dao.AcudienteDao;
import co.escuelatp.dao.AlumnoDao;
import co.escuelatp.database.Utils;
import co.escuelatp.modelos.Acudiente;
import co.escuelatp.modelos.Alumno;
import co.escuelatp.modelos.Categoria;
import co.escuelatp.modelos.EstadoAlumno;
import co.escuelatp.modelos.Genero;
import co.escuelatp.modelos.Persona;
import co.escuelatp.modelos.Talla;
import co.escuelatp.modelos.TipoDocumento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luisk
 */
@WebServlet(name = "InscripcionControlador", urlPatterns = {"/InscripcionControlador"})
public class InscripcionControlador extends HttpServlet {

    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        Alumno alumno = new Alumno();
        
        String primerNombre = request.getParameter("primerNombre");
        String primerApellido = request.getParameter("primerApellido");
        int estado = Integer.parseInt(request.getParameter("estado"));
        
        String aPrimerNombre = request.getParameter("aPrimerNombre");
        String aPrimerApellido = request.getParameter("aPrimerApellido");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        int generos = Integer.parseInt(request.getParameter("generos"));
        
        Genero genero = new Genero(generos);
        Persona persona = new Persona();
        Persona p = new Persona();
        alumno.setPersona(persona);
        Acudiente acudiente = new Acudiente();
        EstadoAlumno estadoAlumno = new EstadoAlumno(estado);
        
        persona.setPrimerNombre(primerNombre);
        persona.setPrimerApellido(primerApellido);
        alumno.setEstadoAlumno(estadoAlumno);
        alumno.setPersona(persona);
        alumno.setAcudiente(acudiente);
        
        p.setPrimerNombre(aPrimerNombre);
        p.setPrimerApellido(aPrimerApellido);
        p.setGenero(genero);
        acudiente.setCorreo(correo);
        acudiente.setCelular(celular);
        acudiente.setPersona(p);
        
        AcudienteDao acudienteDao = new AcudienteDao();
        acudienteDao.inscribirAcudiente(acudiente);
        AlumnoDao alumnoDao = new AlumnoDao();
        alumnoDao.inscribirAlumno(alumno);

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
