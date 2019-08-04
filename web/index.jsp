<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main id="content" class="col-sm-12 col-md-9">
                <section class="contenido">
                    <article>
                        <h1 class="title">Bienvenidos</h1>
                        <p class="text">Nuestra escuela de fútbol Talento Pivijayero te invita a que hagas parte de la recreación y el deporte.
                        Te invitamos a que incorpores a tu niño a nuestro club deportivo, donde va a tener la oportunidad para desarrollar sus cualidades deportivas y sociales.
                        No pierdas esta gran oportunidad, te esperamos.</p>

                        <h3 id="subtitle">Dr. Olmedo Pedroza</h3> 
                    </article>
                    <article class="img">
                        <img src="image/imagen1.jpg" alt="imagen">

                    </article>
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