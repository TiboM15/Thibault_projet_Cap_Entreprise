<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Les_jeux"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="btn-link btn-link-gradient" href="${contextPath}${UrlRoute.URL_HOME}">Accueil</a></li>
            <li class="breadcrumb-item active" aria-current="page">Les jeux</li>
            <li class="breadcrumb-item"><a class="btn-link btn-link-gradient" href="${contextPath}${UrlRoute.URL_REVIEW}">Avis</a></li>
        </ol>
    </nav>

    <h1 class="mt-4">
        Les jeux
        <security:authorize access="hasRole('MODERATOR')">
            <a href="${UrlRoute.URL_GAME_NEW}" class="ms-2">
                <i class="fa fa-circle-plus link-green"></i>
            </a>
        </security:authorize>
    </h1>
    <c:if test="${messageModerate.equals('')}">
        <div class="alert alert-success">
                ${messageModerate}
        </div>
    </c:if>
    <div class="d-flex justify-content-between w-100">
        <div class="d-flex">
            <!-- Label à afficher -->
            <c:set var="label" scope="request" value="Date"/>
            <!-- Sur quelle propriété de l'objet on souhaite trier -->
            <c:set var="sortable" value="publishedAt"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Name"/>
            <c:set var="sortable" value="name"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Genre"/>
            <c:set var="sortable" value="genre.name"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Editeur"/>
            <c:set var="sortable" value="publisher.name"/>
            <%@ include file="../component/sortable.jsp" %>

            <%@ include file="../component/filter-reset.jsp" %>
        </div>

        <c:set var="page" scope="request" value="${pageGames}"/>
        <%@ include file="../component/pagination-number.jsp" %>
    </div>
    <div class="row mb-5">
        <c:forEach items="${pageGames.content}" var="game">
            <%@ include file="../component/entity/game-card.jsp" %>
        </c:forEach>
    </div>
    <%@ include file="../component/pagination.jsp" %>
</div>

<%@ include file="../footer.jsp" %>
