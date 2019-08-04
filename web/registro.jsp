
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
                            <form class="row">
                                <div class="col-sm-12"><h3 class="subtitle">Registro</h3></div>
                                <div class="form-group col-sm-10 col-md-6">                                   
                                    <label for="nombres">Primer Nombre</label>
                                    <input type="text" class="form-control" id="nombres" placeholder="Primer Nombre">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="nombres-acudiente">Segundo Nombre</label>
                                    <input type="text" class="form-control" id="nombres-acudiente" placeholder="Segundo Nombre">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Primer Apellido</label>
                                    <input type="text" class="form-control" id="Apellidos" placeholder="Primer Apellido">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Segundo Apellido</label>
                                    <input type="text" class="form-control" id="Apellidos" placeholder="Segundo Apellido">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad">Tipo de Documento</label>
                                    <select class="form-control" name="select">
                                        <option value="">Selecione un tipo de documento</option>
                                        <option value="masculino">Cédula de Ciudadanía</option>
                                        <option value="femenino">Tarjeta de Identidad</option>
                                        <option value="femenino">Pasaporte</option>
                                        <option value="femenino">Cédula de Extranjería</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Número de Documento</label>
                                    <input type="text" class="form-control" id="Apellidos" placeholder="Número de Documento">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad">Género</label>
                                    <select class="form-control" name="select">
                                        <option value="">Selecione un género</option>
                                        <option value="masculino">Masculino</option>
                                        <option value="femenino">Femenino</option>
                                        <option value="otro">Otro</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad">Cargo</label>
                                    <select class="form-control" name="select">
                                        <option value="">Selecione un cargo</option>
                                        <option value="masculino">Administrador</option>
                                        <option value="femenino">Entrenador</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="telefono">Celular</label>
                                    <input type="text" class="form-control" id="telefono" placeholder="Telefono">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="exampleInputEmail1">Correo Electrónico</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Correo Electrónico">
                                </div>
                                <div class="form-group col-sm-10 col-md-6 offset-md-3">
                                    <label for="exampleInputEmail1">Dirección</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Dirección">
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