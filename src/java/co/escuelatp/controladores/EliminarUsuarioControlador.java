/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

import co.escuelatp.dao.PersonaDao;
import co.escuelatp.dao.UsuarioDao;
import co.escuelatp.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EliminarUsuarioControlador", urlPatterns = {"/EliminarUsuario"})
public class EliminarUsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario u = usuarioDao.getUsuario(idUsuario);
            usuarioDao.eliminarUsuario(u);
            PersonaDao personaDao = new PersonaDao();
            personaDao.eliminarPersona(u);
          
            response.sendRedirect("listaUsuarios");
        }
    }
}
