<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Acceuil"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Accueil</li>
            <li class="breadcrumb-item"><a class="btn-link btn-link-gradient" href="${contextPath}${UrlRoute.URL_GAME}">Les jeux</a></li>
            <li class="breadcrumb-item"><a class="btn-link btn-link-gradient" href="${contextPath}${UrlRoute.URL_REVIEW}">Avis</a></li>
        </ol>
    </nav>

    <body>
        <div class="ratio ratio-16x9">
            <iframe src="https://player.vimeo.com/video/277957882?h=af75e251f5&color=ffffff&title=0&byline=0&portrait=0&autoplay=1&controls=0&loop=1" width="640" height="360" frameborder="0" allow="autoplay; fullscreen; picture-in-picture" allowfullscreen></iframe>
    <%--        <iframe src="https://www.youtube-nocookie.com/embed/-cSFPIwMEq4?si=85Eb65tQhOgmYQf5&autoplay=1&amp;controls=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>></iframe>--%>
        </div>
    </body>

<%@ include file="footer.jsp" %>
