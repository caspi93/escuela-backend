
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
                        
                            <form class="row" method="post" action="MatriculaControlador">
                                <div class="col-sm-12"> <h3 class="subtitle">Datos del alumno</h3></div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="nombres">Primer Nombre</label>
                                    <input type="text" name="primerNombre" class="form-control" id="nombres" placeholder="Primer Nombre - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="snombre-alumno">Segundo Nombre</label>
                                    <input type="text" name="segundoNombre" class="form-control" id="snombre-alumno" placeholder="Segundo Nombre - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Primer Apellido</label>
                                    <input type="text" name="primerApellido" class="form-control" id="Apellidos" placeholder="Primer Apellido - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="papellido-alumno">Segundo Apellido</label>
                                    <input type="text" name="segundoApellido" class="form-control" id="papellido-alumno" placeholder="Primer Apellido - Alumno">
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
                                    <label for="alumnoDoc">Número de Documento</label>
                                    <input type="text" name="numeroDocumentoAlumno" class="form-control" id="sapellido-alumno" placeholder="Número de documento - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="fecnac-alumno">Fecha de nacimiento</label>
                                    <input type="date" name="fecNac" class="form-control" id="fecnac-alumno" placeholder="Fecha de nacimiento - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="direccion-alumno">Dirección</label>
                                    <input type="text" name="direccion" class="form-control" id="direccion-alumno" placeholder="Direccion - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="peso-alumno">Peso</label>
                                    <input type="text" name="peso" class="form-control" id="peso-alumno" placeholder="Peso - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="tallaa">Talla</label>
                                    <select class="form-control" name="talla">
                                        <option value="">Selecione una talla</option>
                                        <option value="1">14</option>
                                        <option value="2">12</option>
                                        <option value="3">10</option>
                                        <option value="4">8</option>
                                        <option value="5">6</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="papellido-alumno">Altura</label>
                                    <input type="text" name="altura" class="form-control" id="altura-alumno" placeholder="Altura - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="categoria">Categoría</label>
                                    <select class="form-control" name="categoria">
                                        <option value="">Selecione una categoría</option>
                                        <option value="1">Sub-6</option>
                                        <option value="2">Sub-8</option>
                                        <option value="3">Pre-Infantil</option>
                                        <option value="4">Infantil</option>
                                    </select>
                                </div>
                                <div class="col-sm-12"><h3 class="subtitle">Datos del acudiente</h3></div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="pnombre-acudiente">Primer Nombre</label>
                                    <input type="text" name="aPrimerNombre" class="form-control" id="pnombre-acudiente" placeholder="Primer Nombre - Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="snombre-acudiente">Segundo Nombre</label>
                                    <input type="text" name="aSegundoNombre" class="form-control" id="snombre-acudiente" placeholder="Segundo Nombre - Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos-acudiente">Primer Apellido</label>
                                    <input type="text" name="aPrimerApellido" class="form-control" id="nombres" placeholder="Primer Apellido- Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="sapellido-alumno">Segundo Apellido</label>
                                    <input type="text" name="aSegundoApellido" class="form-control" id="sapellido-alumno" placeholder="Segundo Apellido - Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad">Tipo de Documento</label>
                                    <select class="form-control" name="tipoDocAc">
                                        <option value="">Selecione un tipo de documento</option>
                                        <option value="1">Cédula de Ciudadanía</option>
                                        <option value="2">Tarjeta de Identidad</option>
                                        <option value="3">Pasaporte</option>
                                        <option value="4">Cédula de Extranjería</option>
                                        <option value="5">Registro Civil</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="numDoc">Número de Documento</label>
                                    <input type="text" name="numeroDocumento" class="form-control" id="sapellido-alumno" placeholder="Número de documento - Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="genero">Género</label>
                                    <select class="form-control" name="genero">
                                        <option value="">Selecione un género</option>
                                        <option value="1">Masculino</option>
                                        <option value="2">Femenino</option>
                                        <option value="3">Otro</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="telefono">Telefono</label>
                                    <input type="text" name="celular" class="form-control" id="telefono" placeholder="Telefono">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="exampleInputEmail1">Correo Electrónico</label>
                                    <input type="email" name="correo" class="form-control" id="exampleInputEmail1" placeholder="Correo Electrónico">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="genero">Estado</label>
                                    <select class="form-control" name="estado">
                                        <option value="">Selecione un estado</option>
                                        <option value="1">Matriculado</option>
                                        <option value="2">Inscrito</option>
                                        <option value="3">Suspendido</option>
                                    </select>
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