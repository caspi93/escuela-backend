/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "LoginControlador", urlPatterns = {"/login"})
public class LoginControlador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String clave = request.getParameter("clave");
        HttpSession sesion = request.getSession();
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.login(nombreUsuario, clave);
        String ruta;
        if (usuario == null) {
            ruta = "login.jsp"; 
            request.setAttribute("INVALIDO", true);
        } else {
            ruta = "index.jsp";
            sesion.setAttribute("USUARIO", usuario);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(ruta);
        dispatcher.forward(request, response);
    }
}
