/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

import co.escuelatp.dao.AlumnoDao;
import co.escuelatp.modelos.Alumno;
import co.escuelatp.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ListaAlumnosControlador", urlPatterns = {"/listaAlumnos"})
public class ListaAlumnosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {
            AlumnoDao alumnoDao = new AlumnoDao();
            ArrayList<Alumno> alumnos = alumnoDao.getAlumnos();
            request.setAttribute("Alumnos", alumnos);

            RequestDispatcher dispatcher = request.getRequestDispatcher("alumnos.jsp");
            dispatcher.forward(request, response);
        }
    }

}
