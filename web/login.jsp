<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main id="content" class="col-sm-12 col-md-9">
                <section>
                    <div id="container" class="row">
                        <main id="content" class="col-sm-12 col-md-9">
                            <section class="contenido-formulario">
                                <div class="container">
                                    <h1 id="titulo">Incie Sesión Aquí</h1>
                                    <div class="row justify-content-center">
                                        <form class="col-sm-10 col-md-6" method="POST" action="login">
                                            <div class="form-group">
                                                <label for="nombres">Nombre de Usuario</label>
                                                <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" placeholder="Nombre de Usuario">
                                            </div>
                                            <div class="form-group">
                                                <label for="apellidos">Contraseña</label>
                                                <input type="password" class="form-control" id="clave" name="clave" placeholder="Contraseña">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Entrar</button>
                                        </form>
                                    </div>
                                    <%if(request.getAttribute("INVALIDO") != null) {
                                            %><div class="alert alert-danger" role="alert">
                                                Usuario o clave incorrecta!
                                              </div><%
                                        }
                                        %>
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