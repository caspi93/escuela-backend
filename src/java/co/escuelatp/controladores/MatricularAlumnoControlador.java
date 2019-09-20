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
@WebServlet(name = "MatricularAlumnoControlador", urlPatterns = {"/MatricularAlumno"})
public class MatricularAlumnoControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("url", "MatricularAlumno");
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            AlumnoDao alumnoDao = new AlumnoDao();
            Alumno a = alumnoDao.getAlumno(idAlumno);
            request.setAttribute("ALUMNO_SELECCIONADO", a);
            
            AcudienteDao acudienteDao = new AcudienteDao();
            Acudiente ac = acudienteDao.getAcudiente(a.getAcudiente().getId());
            a.setAcudiente(ac);
            request.setAttribute("ACUDIENTE_SELECCIONADO", ac);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("matriculas.jsp");
            dispatcher.forward(request, response);
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if ((Usuario) request.getSession().getAttribute("USUARIO") == null) {
            response.sendRedirect("login.jsp");
        } else {

            //Alumno
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            int idPersona = Integer.parseInt(request.getParameter("idPersona"));
            String primerNombre = request.getParameter("primerNombre");
            String segundoNombre = request.getParameter("segundoNombre");
            String primerApellido = request.getParameter("primerApellido");
            String segundoApellido = request.getParameter("segundoApellido");
            int tipoDoc = Integer.parseInt(request.getParameter("tipoDoc"));
            String numeroDocumntoAlumno = request.getParameter("numeroDocumentoAlumno");
            String direccion = request.getParameter("direccion");
            float peso = Float.parseFloat(request.getParameter("peso"));
            float altura = Float.parseFloat(request.getParameter("altura"));
            int tallaId = Integer.parseInt(request.getParameter("talla"));
            int categoriaId = Integer.parseInt(request.getParameter("categoria"));
            String fecNac = request.getParameter("fecNac");
            
            //Acudiente
            String aPrimerNombre = request.getParameter("aPrimerNombre");
            String aSegundoNombre = request.getParameter("aSegundoNombre");
            String aPrimerApellido = request.getParameter("aPrimerApellido");
            String aSegundoApellido = request.getParameter("aSegundoApellido");
            int tipoDocAc = Integer.parseInt(request.getParameter("tipoDocAc"));
            String numeroDocumnto = request.getParameter("numeroDocumento");
            int generoId = Integer.parseInt(request.getParameter("genero"));
            int idAcudiente = Integer.parseInt(request.getParameter("idAcudiente"));
            int idPersonaA = Integer.parseInt(request.getParameter("idPersonaA"));
            String correo = request.getParameter("correo");
            String celular = request.getParameter("celular");
            
            
            Alumno alumno = new Alumno();
            Persona persona = new Persona();
            Persona p = new Persona(idPersonaA);
            Categoria categoria = new Categoria(categoriaId);
            Talla talla = new Talla(tallaId);
            TipoDocumento tipoDocumento = new TipoDocumento();
            TipoDocumento td = new TipoDocumento(tipoDocAc);
            Acudiente acudiente = new Acudiente();
            Genero genero = new Genero(generoId);
            EstadoAlumno ea = new EstadoAlumno(1);
            
            alumno.setPersona(persona);
            persona.setIdPersona(idPersona);
            alumno.setId(idAlumno);
            persona.setPrimerNombre(primerNombre);
            persona.setSegundoNombre(segundoNombre);
            persona.setPrimerApellido(primerApellido);
            persona.setSegundoApellido(segundoApellido);
            tipoDocumento.setId(tipoDoc);
            persona.setTipoDocumento(tipoDocumento);
            alumno.setTalla(talla);
            alumno.setCategoria(categoria);
            persona.setNumeroDocumento(numeroDocumntoAlumno);
            alumno.setDireccion(direccion);
            alumno.setAltura(altura);
            alumno.setPeso(peso);
            Date fecha = Utils.parseFecha(fecNac);
            alumno.setFechaNacimiento(fecha);
            alumno.setEstadoAlumno(ea);
            
            
            //Acudiente
            p.setPrimerNombre(aPrimerNombre);
            p.setSegundoNombre(aSegundoNombre);
            p.setPrimerApellido(aPrimerApellido);
            p.setSegundoApellido(aSegundoApellido);
            p.setTipoDocumento(td);
            p.setNumeroDocumento(numeroDocumnto);
            p.setGenero(genero);
            acudiente.setCorreo(correo);
            acudiente.setCelular(celular);
            acudiente.setPersona(p);
            acudiente.setId(idAcudiente);
            

            AlumnoDao alumnoDao = new AlumnoDao();
            alumnoDao.editarAlumno(alumno);
            AcudienteDao acudienteDao = new AcudienteDao();
            acudienteDao.editarAcudiente(acudiente);

            response.sendRedirect("listaAlumnos");
        }
        
    }

}
