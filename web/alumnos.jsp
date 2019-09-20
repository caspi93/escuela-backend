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
                    <%@page import="co.escuelatp.modelos.Acudiente" %>
                    <% ArrayList<Alumno> alumnos = (ArrayList<Alumno>) request.getAttribute("Alumnos");%>
                    <div class="form-group col-sm-12">
                        <% if (usuario.verificarPermiso("MATRICULAR_ALUMNO")) { %>
                        <a class="btn btn-primary" href="MatriculaControlador">Crear</a>
                        <% } %>
                    </div>
                    <table class="table table-hover table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Alumno</th>
                                <th scope="col">T.Doc</th>
                                <th scope="col">N.Doc</th>
                                <th scope="col">Categoría</th>
                                <th scope="col">F.Nac</th>
                                <th scope="col">Acudiente</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Estado</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Alumno a : alumnos) {%>
                            <tr>

                                <td><%= a.getPersona().getPrimerNombre() + " " + a.getPersona().getPrimerApellido()%></td>
                                <% if (a.getPersona().getTipoDocumento().getNombreCorto() == null) { %>
                                <td> Vacío </td>
                                <% } else {%>
                                <td><%= a.getPersona().getTipoDocumento().getNombreCorto()%></td>
                                <% } %>
                                <% if (a.getPersona().getNumeroDocumento() == null) { %>
                                <td> Vacío </td>
                                <% } else {%>
                                <td><%= a.getPersona().getNumeroDocumento()%></td>
                                <% } %>
                                <% if (a.getCategoria().getNombre() == null) { %>
                                <td> Vacío </td>
                                <% } else {%>
                                <td><%= a.getCategoria().getNombre() %></td>
                                <% } %>
                                <% if (a.getFechaNacimiento() == null) { %>
                                <td> Vacío </td>
                                <% } else {%>
                                <td><%= a.getFechaNacimiento()%></td>
                                <% }%>
                                <td><%= a.getAcudiente().getPersona().getPrimerNombre() + " " + a.getAcudiente().getPersona().getPrimerApellido()%></td>
                                <% if (a.getDireccion() == null) { %>
                                <td> Vacío </td>
                                <% } else {%>
                                <td><%= a.getDireccion()%></td>
                                <% }%>
                                <td><%= a.getEstadoAlumno().getCodigo()%></td>

                                <td><a class="btn btn-primary btn-sm"  href="EditarAlumno?idAlumno=<%= a.getId()%>" role="button">Editar</a>
                                    <% if (usuario.verificarPermiso("ELIMINAR_ALUMNO")) {%>
                                    <a class="btn btn-danger btn-sm" href="EliminarAlumno?idAlumno=<%= a.getId()%>" role="button">Eliminar</a>
                                    <% } %>
                                    <% if (a.getEstadoAlumno().getId() == 2) {%>
                                    <a class="btn btn-primary btn-sm" href="MatricularAlumno?idAlumno=<%= a.getId()%>" role="button">Matricular</a></td>
                                    <% } %>
                                    <% }%>
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