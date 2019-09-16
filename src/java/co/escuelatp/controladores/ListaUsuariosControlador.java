/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

import co.escuelatp.modelos.Usuario;
import co.escuelatp.dao.UsuarioDao;
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
@WebServlet(name = "listaUsuariosControlador", urlPatterns = {"/listaUsuarios"})
public class ListaUsuariosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {
            UsuarioDao usuarioDao = new UsuarioDao();
            ArrayList<Usuario> usuarios = usuarioDao.getUsuarios();
            request.setAttribute("Usuarios", usuarios);

            RequestDispatcher dispatcher = request.getRequestDispatcher("usuarios.jsp");
            dispatcher.forward(request, response);
        }
    }
}
