
<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main id="content" class="col-sm-12 col-md-9">
                <section class="contenido-formulario">
                    <div class="container">
                        <h1 id="titulo">Escuela de fútbol Talento Pivijayero</h1>
                        
                        <form class="row" method="post" action="<%= request.getAttribute("url")%>">
                            <% Usuario seleccion = (Usuario) request.getAttribute("USUARIO_SELECCIONADO"); %>
                            
                            <% if (seleccion != null) { %>
                                <input type="hidden" name="idUsuario" value="<%= seleccion.getId() %>" class="form-control" id="pnombre" placeholder="">
                                <input type="hidden" name="idPersona" value="<%= seleccion.getIdPersona() %>" class="form-control" id="pnombre" placeholder="">
                            <% } %>
                            
                            <div class="col-sm-12"><h3 class="subtitle">Registro</h3></div>
                            <div class="form-group col-sm-10 col-md-6">                                   
                                <label for="pnombre">Primer Nombre</label>
                                <input required type="text" name="primerNombre" class="form-control" id="pnombre" placeholder="Primer Nombre" value="<%= seleccion != null ? seleccion.getPrimerNombre() : "" %>" required>
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="nombres-acudiente">Segundo Nombre</label>
                                <input required type="text" name="segundoNombre" class="form-control" id="nombres-acudiente" placeholder="Segundo Nombre" value="<%= seleccion != null ? seleccion.getSegundoNombre() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="apellidos">Primer Apellido</label>
                                <input required type="text" name="primerApellido" class="form-control" id="Apellidos" placeholder="Primer Apellido" value="<%= seleccion != null ? seleccion.getPrimerApellido() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="apellidos">Segundo Apellido</label>
                                <input required type="text" name="segundoApellido" class="form-control" id="Apellidos" placeholder="Segundo Apellido" value="<%= seleccion != null ? seleccion.getSegundoApellido() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="edad">Tipo de Documento</label>
                                <select class="form-control" name="tipoDoc" required>
                                    <option value="">Selecione un tipo de documento</option>
                                    <option value="1">Cédula de Ciudadanía</option>
                                    <option value="2">Tarjeta de Identidad</option>
                                    <option value="3">Pasaporte</option>
                                    <option value="4">Cédula de Extranjería</option>
                                    <option value="5">Registro Civil</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="apellidos">Número de Documento</label>
                                <input required type="text" name="numDoc" class="form-control" id="Apellidos" placeholder="Número de Documento" value="<%= seleccion != null ? seleccion.getNumeroDocumento() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="edad">Género</label>
                                <select class="form-control" name="genero" required>
                                    <option value="">Selecione un género</option>
                                    <option value="1">Masculino</option>
                                    <option value="2">Femenino</option>
                                    <option value="3">Otro</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="edad">Cargo</label>
                                <select class="form-control" name="cargo" required>
                                    <option value="">Selecione un cargo</option>
                                    <% if (usuario.verificarPermiso("CREAR_ADMINISTRADOR")) { %>
                                    <option value="2">Administrador</option>
                                    <% } %>
                                    <option value="3">Entrenador</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="telefono">Celular</label>
                                <input required type="text" name="celular" class="form-control" id="telefono" placeholder="Telefono" value="<%= seleccion != null ? seleccion.getCelular() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="exampleInputEmail1">Correo Electrónico</label>
                                <input required type="email" name="correo" class="form-control" id="exampleInputEmail1" placeholder="Correo Electrónico" value="<%= seleccion != null ? seleccion.getCorreo() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6 offset-md-3">
                                <label for="exampleInputEmail1">Dirección</label>
                                <input type="text" name="direccion" class="form-control" id="exampleInputEmail1" placeholder="Dirección" value="<%= seleccion != null ? seleccion.getDireccion() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="nombreUsuario">Nombre de Usuario</label>
                                <input required type="text" name="nombreUsuario" class="form-control" id="NombreUsuario" placeholder="Nombre de Usuario" value="<%= seleccion != null ? seleccion.getNombreUsuario() : "" %>">
                            </div>
                            <div class="form-group col-sm-10 col-md-6">
                                <label for="apellidos">Contraseña</label>
                                <input required type="password" name="clave" class="form-control" id="Clave" placeholder="Contraseña">
                            </div>
                            <div class="form-group col-sm-12">
                                <button type="submit" class="btn btn-primary">Guardar datos</button>
                            </div>
                        </form>
                    </div>
                </section>
            </main>
            <%@include file="WEB-INF/jspf/side_bar.jspf" %>
        </div>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>