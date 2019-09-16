/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

import co.escuelatp.dao.UsuarioDao;
import co.escuelatp.modelos.Genero;
import co.escuelatp.modelos.Persona;
import co.escuelatp.modelos.Rol;
import co.escuelatp.modelos.TipoDocumento;
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
@WebServlet(name = "EditarUsuarioControlador", urlPatterns = {"/EditarUsuario"})
public class EditarUsuarioControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {
            System.out.println("hello man");
            request.setAttribute("url", "EditarUsuario");
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario u = usuarioDao.getUsuario(idUsuario);
            request.setAttribute("USUARIO_SELECCIONADO", u);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
            dispatcher.forward(request, response);
            System.out.println("hello man");
        }
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {

            System.out.println("quiero entrar");
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            int idPersona = Integer.parseInt(request.getParameter("idPersona"));
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            int tipoDoc = Integer.parseInt(request.getParameter("tipoDoc"));
            String numeroDocumnto = request.getParameter("numDoc");
            int genero = Integer.parseInt(request.getParameter("genero"));
            String celular = request.getParameter("celular");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            int cargo = Integer.parseInt(request.getParameter("cargo"));
            String nombreUsuario = request.getParameter("nombreUsuario");
            String clave = request.getParameter("clave");

            System.out.println("estoy dentro");
            Usuario usuario = new Usuario();
            Genero g = new Genero();
            Rol rol = new Rol();
            TipoDocumento tipoDocumento = new TipoDocumento();
            usuario.setIdPersona(idPersona);
            usuario.setId(idUsuario);
            usuario.setPrimerNombre(primerNombre);
            usuario.setSegundoNombre(segundoNombre);
            usuario.setPrimerApellido(primerApellido);
            usuario.setSegundoApellido(segundoApellido);
            tipoDocumento.setId(tipoDoc);
            usuario.setTipoDocumento(tipoDocumento);
            g.setId(genero);
            usuario.setGenero(g);
            rol.setId(cargo);
            usuario.setRol(rol);
            usuario.setNumeroDocumento(numeroDocumnto);
            usuario.setCelular(celular);
            usuario.setDireccion(direccion);
            usuario.setCorreo(correo);
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setClave(clave);

            System.out.println("voy llegando");
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.editarUsuarios(usuario);

            System.out.println("terminé");

            response.sendRedirect("listaUsuarios");
        }
    }
}
