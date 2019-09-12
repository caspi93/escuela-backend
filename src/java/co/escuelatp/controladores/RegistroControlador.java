/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.escuelatp.controladores;

import co.escuelatp.dao.UsuarioDao;
import co.escuelatp.modelos.Genero;
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
@WebServlet(name = "RegistroControlador", urlPatterns = {"/RegistroControlador"})
public class RegistroControlador extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        
        String primerNombre = request.getParameter("primerNombre");
        String segundoNombre = request.getParameter("segundoNombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        String celular = request.getParameter("celular");
        String correo = request.getParameter("correo");
        int tipoDoc = Integer.parseInt(request.getParameter("tipoDoc"));
        String numDoc = request.getParameter("numDoc");
        String direccion = request.getParameter("direccion");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        int generos = Integer.parseInt(request.getParameter("genero"));
        String nombreUsuario = request.getParameter("nombreUsuario");
        String clave = request.getParameter("clave");
        
        System.out.println("hello man 6");
        Genero genero = new Genero(generos);
        Rol rol = new Rol(cargo);
        TipoDocumento tipoDocumento = new TipoDocumento(tipoDoc);
        
        usuario.setPrimerNombre(primerNombre);
        usuario.setSegundoNombre(segundoNombre);
        usuario.setPrimerApellido(primerApellido);
        usuario.setSegundoApellido(segundoApellido);
        usuario.setNumeroDocumento(numDoc);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setClave(clave);
        usuario.setCorreo(correo);
        usuario.setCelular(celular);
        usuario.setDireccion(direccion);
        usuario.setRol(rol);
        usuario.setGenero(genero);
        usuario.setTipoDocumento(tipoDocumento);
        
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.crearUsuario(usuario);
        System.out.println("hello man 5");
        
        System.out.println("hello man 7");
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuarios.jsp");
        dispatcher.forward(request, response);
    }
}
