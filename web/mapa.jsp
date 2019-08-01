
<%@include file="WEB-INF/jspf/head.jspf" %>
<body>

    <div class="container">
        <%@include file="WEB-INF/jspf/header.jspf" %>

        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <div id="container" class="row">
            <main id="content" class="col-sm-12 col-md-9">
                <section>
                    <main class="row justify-content-center">
                        <article class="col-sm-12 col-md-9">
                            <div id="map" width="100%">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1961.8019163257063!2d-74.62037386301776!3d10.452978136051044!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8ef5ed1702fed1e7%3A0x9b6465d5324a1262!2sPanaca+Club+Campestre!5e0!3m2!1ses-419!2sco!4v1544169418872" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
                            </div>
                        </article>
                    </main>
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