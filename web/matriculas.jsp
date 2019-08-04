
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
                                <div class="col-sm-12"> <h3 class="subtitle">Datos del alumno</h3></div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="nombres">Primer Nombre</label>
                                    <input type="text" class="form-control" id="nombres" placeholder="Primer Nombre - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="snombre-alumno">Segundo Nombre</label>
                                    <input type="text" class="form-control" id="snombre-alumno" placeholder="Segundo Nombre - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos">Primer Apellido</label>
                                    <input type="text" class="form-control" id="Apellidos" placeholder="Primer Apellido - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="papellido-alumno">Segundo Apellido</label>
                                    <input type="text" class="form-control" id="papellido-alumno" placeholder="Primer Apellido - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="fecnac-alumno">Fecha de nacimiento</label>
                                    <input type="date" class="form-control" id="fecnac-alumno" placeholder="Fecha de nacimiento - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="edad-alumno">Edad</label>
                                    <input type="text" class="form-control" id="edad-alumno" placeholder="Edad - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="direccion-alumno">Dirección</label>
                                    <input type="text" class="form-control" id="direccion-alumno" placeholder="Direccion - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="peso-alumno">Peso</label>
                                    <input type="text" class="form-control" id="peso-alumno" placeholder="Peso - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="talla-alumno">Talla</label>
                                    <input type="text" class="form-control" id="talla-alumno" placeholder="Talla - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="papellido-alumno">Altura</label>
                                    <input type="text" class="form-control" id="altura-alumno" placeholder="Altura - Alumno">
                                </div>
                                <div class="form-group col-sm-10 col-md-6 offset-md-3">
                                    <label for="categoria">Categoría</label>
                                    <select class="form-control" name="select">
                                        <option value="">Selecione una categoría</option>
                                        <option value="Pre-infantil">Pre-infantil</option>
                                        <option value="Sub-10">Sub-10</option>
                                        <option value="Sub-8">Sub-8</option>
                                        <option value="Sub-6">Sub-6</option>
                                    </select>
                                </div>
                                <div class="col-sm-12"><h3 class="subtitle">Datos del acudiente</h3></div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="pnombre-acudiente">Primer Nombre</label>
                                    <input type="text" class="form-control" id="pnombre-acudiente" placeholder="Primer Nombre - Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="snombre-acudiente">Segundo Nombre</label>
                                    <input type="text" class="form-control" id="snombre-acudiente" placeholder="Segundo Nombre - Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="apellidos-acudiente">Primer Apellido</label>
                                    <input type="text" class="form-control" id="nombres" placeholder="Primer Apellido- Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="sapellido-alumno">Segundo Apellido</label>
                                    <input type="text" class="form-control" id="sapellido-alumno" placeholder="Segundo Apellido - Acudiente">
                                </div>
                                <div class="form-group col-sm-10 col-md-6 offset-md-3">
                                    <label for="genero">Género</label>
                                    <select class="form-control" name="select">
                                        <option value="">Selecione un género</option>
                                        <option value="masculino">Masculino</option>
                                        <option value="femenino">Femenino</option>
                                        <option value="otro">Otro</option>
                                    </select>
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="telefono">Telefono</label>
                                    <input type="text" class="form-control" id="telefono" placeholder="Telefono">
                                </div>
                                <div class="form-group col-sm-10 col-md-6">
                                    <label for="exampleInputEmail1">Correo Electrónico</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Correo Electrónico">
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