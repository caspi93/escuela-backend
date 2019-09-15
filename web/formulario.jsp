
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
                        <div class="row justify-content-center">
                            <form class="col-sm-10 col-md-6" action="InscripcionControlador" method="post">
                                <div class="form-group">
                                    <h3 class="subtitle">Datos del alumno</h3>
                                    <label for="nombres">Primer Nombre</label>
                                    <input type="text" name="primerNombre" class="form-control" id="nombres" placeholder="Primer Nombre - Alumno">
                                </div>
                                <div class="form-group">
                                    <label for="apellidos">Primer Apellido</label>
                                    <input type="text" name="primerApellido" class="form-control" id="Apellidos" placeholder="Primer Apellido - Alumno">
                                </div>
                                <h3 class="subtitle">Datos del acudiente</h3>
                                <div class="form-group">
                                    <label for="nombres-acudiente">Primer Nombre</label>
                                    <input type="text" name="aPrimerNombre"class="form-control" id="nombres-acudiente" placeholder="Primer Nombre - Acudiente">

                                </div>
                                <div class="form-group">
                                    <label for="apellidos-acudiente">Primer Apellido</label>
                                    <input type="text" name="aPrimerApellido" class="form-control" id="nombres" placeholder="Primer Apellido- Acudiente">
                                </div>
                                <div class="form-group">
                                    <label for="edad">Género</label>
                                    <select class="form-control" name="generos">
                                        <option value="">Selecione un género</option>
                                        <option value="1">Masculino</option>
                                        <option value="2">Femenino</option>
                                        <option value="3">Otro</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Telefono</label>
                                    <input type="text" name="celular" class="form-control" id="telefono" placeholder="Telefono">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Correo Electrónico</label>
                                    <input type="email" name="correo" class="form-control" id="exampleInputEmail1" placeholder="Correo Electrónico">
                                </div>
                                <div class="form-group">
                                    <label for="genero">Estado</label>
                                    <select class="form-control" name="estado">
                                        <option value="">Selecione un estado</option>
                                        <option value="1">Matriculado</option>
                                        <option value="2">Inscrito</option>
                                        <option value="3">Suspendido</option>
                                    </select>
                                </div>

                                <button type="submit" class="btn btn-primary">Guardar datos</button>
                            </form>
                        </div>
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