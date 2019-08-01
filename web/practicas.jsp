<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main class="row justify-content-center" class ="horario">
                <div class="horario-practica" class="col-sm-9 col-md-12">
                    <h3>Horarios de prácticas</h3>
                    <table class="table table-hover table-dark">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Lunes</th>
                                <th scope="col">Martes</th>
                                <th scope="col">Miércoles</th>
                                <th scope="col">Jueves</th>
                                <th scope="col">Viernes</th>
                                <th scope="col">Sabado</th>
                                <th scope="col">Domingo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Semana 1</th>
                                <td>04:00 pm</td>
                                <td></td>
                                <td>07:00 am</td>
                                <td></td>
                                <td>05:00 pm</td>
                                <td></td>
                                <td></td>

                            </tr>
                            <tr>
                                <th scope="row">Semana 2</th>
                                <td></td>
                                <td>03:00 pm</td>
                                <td></td>
                                <td>03:00 pm</td>
                                <td></td>
                                <td>08:00 am</td>
                                <td></td>
                            </tr>
                            <tr>
                                <th scope="row">Semana 3</th>
                                <td></td>
                                <td></td>
                                <td>05:00 pm</td>
                                <td></td>
                                <td>04:00 pm</td>
                                <td></td>
                                <td>08:00 am</td>

                            </tr>
                            <tr>
                                <th scope="row">Semana 4</th>
                                <td>05:00 pm</td>
                                <td>05:00 pm</td>
                                <td></td>
                                <td></td>
                                <td>04:00 pm</td>
                                <td></td>
                                <td></td>
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