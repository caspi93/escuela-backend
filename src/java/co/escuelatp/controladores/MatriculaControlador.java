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
import co.escuelatp.modelos.Usuario;
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
@WebServlet(name = "MatriculaControlador", urlPatterns = {"/MatriculaControlador"})
public class MatriculaControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("url", "MatriculaControlador");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("matriculas.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {

            Alumno alumno = new Alumno();

            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            int tipoDoc = Integer.parseInt(request.getParameter("tipoDoc"));
            String numDocAlumno = request.getParameter("numeroDocumentoAlumno");
            float altura = Float.parseFloat(request.getParameter("altura"));
            int talla = Integer.parseInt(request.getParameter("talla"));
            float peso = Float.parseFloat(request.getParameter("peso"));
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            String direccion = request.getParameter("direccion");
            String fecNac = request.getParameter("fecNac");
            int estado = Integer.parseInt(request.getParameter("estado"));

            String aPrimerNombre = request.getParameter("aPrimerNombre");
            String aSegundoNombre = request.getParameter("aSegundoNombre");
            String aPrimerApellido = request.getParameter("aPrimerApellido");
            String aSegundoApellido = request.getParameter("aSegundoApellido");
            String celular = request.getParameter("celular");
            String correo = request.getParameter("correo");
            int tipoDocAc = Integer.parseInt(request.getParameter("tipoDocAc"));
            String numDoc = request.getParameter("numeroDocumento");
            int generos = Integer.parseInt(request.getParameter("genero"));

            TipoDocumento tipoDocumento = new TipoDocumento(tipoDoc);
            TipoDocumento tipoDocument = new TipoDocumento(tipoDocAc);
            Genero genero = new Genero(generos);
            Persona persona = new Persona();
            Persona p = new Persona();
            alumno.setPersona(persona);
            Talla t = new Talla(talla);
            Categoria c = new Categoria(categoria);
            Acudiente acudiente = new Acudiente();
            EstadoAlumno estadoAlumno = new EstadoAlumno(estado);

            persona.setPrimerNombre(primerNombre);
            persona.setSegundoNombre(segundoNombre);
            persona.setPrimerApellido(primerApellido);
            persona.setSegundoApellido(segundoApellido);
            persona.setTipoDocumento(tipoDocumento);
            persona.setNumeroDocumento(numDocAlumno);
            alumno.setAltura(altura);
            Date fecha = Utils.parseFecha(fecNac);
            alumno.setFechaNacimiento(fecha);
            alumno.setPeso(peso);
            alumno.setTalla(t);
            alumno.setDireccion(direccion);
            alumno.setCategoria(c);
            alumno.setEstadoAlumno(estadoAlumno);
            alumno.setPersona(persona);

            p.setPrimerNombre(aPrimerNombre);
            p.setSegundoNombre(aSegundoNombre);
            p.setPrimerApellido(aPrimerApellido);
            p.setSegundoApellido(aSegundoApellido);
            p.setGenero(genero);
            p.setTipoDocumento(tipoDocument);
            p.setNumeroDocumento(numDoc);
            acudiente.setCorreo(correo);
            acudiente.setCelular(celular);
            acudiente.setPersona(p);
            alumno.setAcudiente(acudiente);

            AcudienteDao acudienteDao = new AcudienteDao();
            acudienteDao.crearAcudiente(acudiente);
            AlumnoDao alumnoDao = new AlumnoDao();
            alumnoDao.matricularAlumno(alumno);

            response.sendRedirect("listaAlumnos");
        }
    }

}
