
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
                        <form class="row" method="post" action="RegistroControlador">
                                <div class="col-sm-12"><h3 class="subtitle">Registro</h3></div>
                                <div class="form-group col-sm-10 col-md-6">                                   
                                    <label for="pnombre">Primer Nombre</label>
                                    <input type="text" name="primerNombre" class="form-control" id="pnombre" placeholder="Primer Nombre">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="nombres-acudiente">Segundo Nombre</label>
                                    <input type="text" name="segundoNombre" class="form-control" id="nombres-acudiente" placeholder="Segundo Nombre">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Primer Apellido</label>
                                    <input type="text" name="primerApellido" class="form-control" id="Apellidos" placeholder="Primer Apellido">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Segundo Apellido</label>
                                    <input type="text" name="segundoApellido" class="form-control" id="Apellidos" placeholder="Segundo Apellido">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad">Tipo de Documento</label>
                                    <select class="form-control" name="tipoDoc">
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
                                    <input type="text" name="numDoc" class="form-control" id="Apellidos" placeholder="Número de Documento">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad">Género</label>
                                    <select class="form-control" name="genero">
                                        <option value="">Selecione un género</option>
                                        <option value="1">Masculino</option>
                                        <option value="2">Femenino</option>
                                        <option value="3">Otro</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad">Cargo</label>
                                    <select class="form-control" name="cargo">
                                        <option value="">Selecione un cargo</option>
                                        <% if (usuario.verificarPermiso("CREAR_ADMINISTRADOR")) { %>
                                        <option value="2">Administrador</option>
                                        <% } %>
                                        <option value="3">Entrenador</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="telefono">Celular</label>
                                    <input type="text" name="celular" class="form-control" id="telefono" placeholder="Telefono">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="exampleInputEmail1">Correo Electrónico</label>
                                    <input type="email" name="correo" class="form-control" id="exampleInputEmail1" placeholder="Correo Electrónico">
                                </div>
                                <div class="form-group col-sm-10 col-md-6 offset-md-3">
                                    <label for="exampleInputEmail1">Dirección</label>
                                    <input type="text" name="direccion" class="form-control" id="exampleInputEmail1" placeholder="Dirección">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="nombreUsuario">Nombre de Usuario</label>
                                    <input type="text" name="nombreUsuario" class="form-control" id="NombreUsuario" placeholder="Nombre de Usuario">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Contraseña</label>
                                    <input type="text" name="clave" class="form-control" id="Clave" placeholder="Contraseña">
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