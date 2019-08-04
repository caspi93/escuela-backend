
<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main id="content" class="col-sm-12 col-md-9">
                <section class="contenido">
                    <article>
                        <h1 class="title"> Misión</h1>
                        <p class="text">La escuela de fútbol Talento Pivijayero tiene como finalidad impulsar el deporte 
                        y la recreación de nuestros niños a través de la práctica del fútbol, ya que dicha
                         práctica les permite crecer sanos y fuertes, manteniéndolos enfocados en los buenos 
                         hábitos para así formar una sociedad sana y saludable.</p>
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