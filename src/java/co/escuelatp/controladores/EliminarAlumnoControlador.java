/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

import co.escuelatp.dao.AlumnoDao;
import co.escuelatp.dao.PersonaDao;
import co.escuelatp.modelos.Alumno;
import co.escuelatp.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luisk
 */
@WebServlet(name = "EliminarAlumnoControlador", urlPatterns = {"/EliminarAlumno"})
public class EliminarAlumnoControlador extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            AlumnoDao alumnoDao = new AlumnoDao();
            Alumno a = alumnoDao.getAlumno(idAlumno);
            alumnoDao.eliminarAlumno(a);
            PersonaDao personaDao = new PersonaDao();
            personaDao.eliminarPersona(a.getPersona());
          
            response.sendRedirect("listaAlumnos");
        }
    }

  
}
