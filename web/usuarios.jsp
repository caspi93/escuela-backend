<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main class="row justify-content-center" class ="horario">
                <div class="horario-practica" class="col-sm-9 col-md-12">
                    <h3>Lista de Usuarios</h3>

                    <%@page import="co.escuelatp.modelos.Usuario, java.util.ArrayList" %>

                    <% ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("Usuarios");%>
                    <div class="form-group col-sm-12">
                        <% if (usuario.verificarPermiso("CREAR_USUARIO")) { %>
                        <a class="btn btn-primary" href="RegistroControlador">Crear</a>
                        <% } %>
                    </div>
                    <table class="table table-hover table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Usuario</th>
                                <th scope="col">T.Doc</th>
                                <th scope="col">N.Doc</th>
                                <th scope="col">Celular</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Cargo</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% for (Usuario u : usuarios) {%>
                                <% if (u.getId() != 1) { %>
                                <tr>
                                    <td><%= u.getPrimerNombre() + " " + u.getPrimerApellido() %></td>
                                    <td><%= u.getTipoDocumento().getNombreCorto()%></td>
                                    <td><%= u.getNumeroDocumento()%></td>
                                    <td><%= u.getCelular()%></td>
                                    <td><%= u.getCorreo()%></td>
                                    <% if(u.getDireccion() == null) { %>
                                        <td> Vacío </td>
                                    <% } else { %>
                                    <td><%= u.getDireccion()%></td>
                                    <% } %>
                                    <td><%= u.getRol().getNombre()%></td>
                                    <td><a class="btn btn-primary" href="EditarUsuario?idUsuario=<%= u.getId() %>" role="button">Editar</a>
                                        <% if (usuario.verificarPermiso("ELIMINAR_USUARIO")) { %>
                                    <a class="btn btn-danger" href="EliminarUsuario?idUsuario=<%= u.getId() %>" role="button">Eliminar</a></td>
                                    <% } %>

                                </tr>
                                <% }%>
                            <% } %>
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