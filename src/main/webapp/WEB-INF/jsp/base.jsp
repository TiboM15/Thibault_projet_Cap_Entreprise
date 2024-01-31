<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<%
    Object title = request.getAttribute("title");
    if (title == null) {
        title = "CAP ENTREPRISE";
    }
    request.setAttribute("title", title);
%>

<html>
    <head>
        <title>${title}</title>
        <link href="${contextPath}/css/main.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" rel="stylesheet">
        <script type="text/javascript" src="${contextPath}/js/main.js"></script>
        <script type="text/javascript" src="${contextPath}/js/init-sortable.js"></script>
        <script type="text/javascript" src="${contextPath}/js/hide-form.js"></script>
        <script type="text/javascript" src="${contextPath}/js/alert.js"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

<%--                    <security:authorize access="!isAuthenticated()">--%>

<%--                    </security:authorize>--%>
                    <security:authorize access="isAuthenticated()">
                        <div class="row w-100">
                            <div class="col-2">
                                <a class="navbar-brand ms-3" href="${contextPath}/">
                                    <i class="fa-brands fa-steam fa-2x"></i>
                                </a>
                            </div>
                            <div class="col-2">
                                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                                    <div class="navbar-nav">
                                        <security:authorize access="hasRole('ROLE_ADMIN')">
                                            <a class="nav-link" href="${contextPath}">Platform</a>
                                        </security:authorize>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="main-container p-2">
                                    <div class="d-flex">
                                        <input type="text"
                                               class="form-control"
                                               placeholder="Starcraft, FPS, ..."
                                               data-search-bar-games
                                        >
                                        <a class="my-auto me-3">
                                            <i class="fa fa-magnifying-glass"></i>
                                        </a>
                                    </div>
                                    <div class="search-response-container">
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                        <div class="d-flex justify-content-end" style="font-size: medium   ">
                            Bienvenue
                            <span class="ms-2 logged-user">
                                    <security:authentication property="name"/>
                                </span>
                            <a class="nav- position-absolute top-50 start-0 ms-2" href="${contextPath}/avis">Avis</a>
                        </div>
                        <div class="d-flex justify-content-end">
                            <form method="POST" action="${contextPath}/logout" autocomplete="off">
                                <button type="submit" tabindex="3" class="btn btn-link">Logout</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                        </div>
                    </security:authorize>
                </div>
            </div>
        </nav>
        <c:if test="${not empty flashMessage.message}">
            <div class="container">
                <div class="alert alert-${flashMessage.type}">
                        ${flashMessage.message}
                </div>
            </div>
        </c:if>