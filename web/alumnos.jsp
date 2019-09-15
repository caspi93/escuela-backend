<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main class="row justify-content-center" class ="horario">
                <div class="horario-practica" class="col-sm-9 col-md-12">
                    <h3>Lista de Alumnos</h3>
                    <%@page import="co.escuelatp.modelos.Alumno, java.util.ArrayList" %>
                    <% ArrayList<Alumno> alumnos = (ArrayList<Alumno>) request.getAttribute("Alumnos");%>
                    <div class="form-group col-sm-12">
                        <% if (usuario.verificarPermiso("MATRICULAR_ALUMNO")) { %>
                        <a class="btn btn-primary" href="matriculas.jsp">Crear</a>
                        <% } %>
                    </div>
                    <table class="table table-hover table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Alumno</th>
                                <th scope="col">T.Doc</th>
                                <th scope="col">N.Doc</th>
                                <th scope="col">Categor�a</th>
                                <th scope="col">F.Nac</th>
                                <th scope="col">Acudiente</th>
                                <th scope="col">Direcci�n</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Alumno a: alumnos) {%>
                            <tr>
                             
                                <td><%= a.getPersona().getPrimerNombre() + " " + a.getPersona().getPrimerApellido() %></td>
                                <td><%= a.getPersona().getTipoDocumento().getNombreCorto()%></td>
                                <td><%= a.getPersona().getNumeroDocumento()%></td>
                                <td><%= a.getCategoria().getNombre()%></td>
                                <td><%= a.getFechaNacimiento()%></td>
                                <td><%= a.getAcudiente().getPersona().getPrimerNombre() + " " + a.getAcudiente().getPersona().getPrimerApellido()%></td>
                                <td><%= a.getDireccion() %></td>
                                <td><%= a.getEstadoAlumno().getCodigo()%></td>
        
                                <td><a class="btn btn-primary" href="#" role="button">Editar</a>
                                <a class="btn btn-danger" href="#" role="button">Eliminar</a></td>
                            <% } %>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </main>
            <%@include file="WEB-INF/jspf/side_bar.jspf" %>
        </div>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>