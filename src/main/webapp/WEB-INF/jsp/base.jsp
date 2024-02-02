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
        <script type="text/javascript" src="${contextPath}/js/multiple-select.js"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap" rel="stylesheet">
        <security:authorize access="isAuthenticated()">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark w-75">
                <div class="row w-100">
                    <div class="col-3">
                        <a class="navbar-brand ms-3" href="${contextPath}/">
                            <i class="logo">
                                <img src="${contextPath}/resources/image/logo/logo.png">
                            </i>
                        </a>
                    </div>
                    <div class="pixelReview col-9 row justify-content-evenly position-absolute align-self-center">
                        PixelReview
                    </div>
                    <div class="col-9">
                        <div class="d-flex justify-content-end">
                            Bienvenue
                            <span class="ms-2 logged-user">
                                <security:authentication property="name"/>
                            </span>
                        </div>
                        <div class="d-flex justify-content-end">
                            <form method="POST" action="${contextPath}/logout" autocomplete="off">
                                <button type="submit" tabindex="3" class="btn btn-link btn-link-gradient">Se déconnecter</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                        </div>
                    </div>
                </div>
            </nav>
        </security:authorize>
        <c:if test="${not empty flashMessage.message}">
            <div class="container mt-3">
                <div class="alert alert-${flashMessage.type}">
                        ${flashMessage.message}
                </div>
            </div>
        </c:if>