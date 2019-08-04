<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main class="row justify-content-center" class ="horario">
                <div class="horario-practica" class="col-sm-9 col-md-12">
                    <h3>Lista de Alumnos</h3>
                    <div class="form-group col-sm-12">
                        <button type="submit" class="btn btn-primary">Crear</button>
                    </div>
                    <table class="table table-hover table-dark">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombres</th>
                                <th scope="col">Apellidos</th>
                                <th scope="col">T.Doc</th>
                                <th scope="col">N.Doc</th>
                                <th scope="col">Categoría</th>
                                <th scope="col">F.Nac</th>
                                <th scope="col">S.Edad</th>
                                <th scope="col">Acudiente</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Datos</th>
                                <td>04:00 pm</td>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td><a class="btn btn-primary" href="#" role="button">Editar</a>
                                <a class="btn btn-danger" href="#" role="button">Eliminar</a></td>
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