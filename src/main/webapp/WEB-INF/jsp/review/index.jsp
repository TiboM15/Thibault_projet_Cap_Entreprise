<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container mt-5">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a class="btn-link btn-link-gradient" href="${contextPath}${UrlRoute.URL_HOME}">Accueil</a></li>
            <li class="breadcrumb-item"><a class="btn-link btn-link-gradient" href="${contextPath}${UrlRoute.URL_GAME}">Les jeux</a></li>
            <li class="breadcrumb-item active" aria-current="page">Avis</li>
        </ol>
    </nav>
    <c:if test="${messageModerate.equals('')}">
        <div class="alert alert-success">
                ${messageModerate}
        </div>
    </c:if>
    <h1 class="my-4">Les avis</h1>
    <div class="d-flex justify-content-between w-100">
        <!-- Label à afficher -->
        <div class="d-flex"
            <c:set var="label" scope="request" value="Date"/>
            <!-- Sur quelle propriété de l'objet on souhaite trier -->
            <c:set var="sortable" value="createdAt"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Note"/>
            <c:set var="sortable" value="rating"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Jeu"/>
            <c:set var="sortable" value="game.name"/>
            <%@ include file="../component/sortable.jsp" %>

            <c:set var="label" scope="request" value="Joueur"/>
            <c:set var="sortable" value="gamer.nickname"/>
            <%@ include file="../component/sortable.jsp" %>

        <security:authorize access="hasRole('MODERATOR')">
            <div class="sort-filter mt-4 me-3">
                <select class="form-select sortable-select">
                    <option value="all" data-filter-url="${currentUrl}">
                        Tous les commentaires
                    </option>
                    <option value="sort=moderator,desc"
                            data-filter-url="${jspUtils.generateUrlFrom(currentUrl, currentQuery, "sort=moderator,desc")}"
                    >
                        Modérés
                    </option>
                    <option value="sort=moderator,asc"
                            data-filter-url="${jspUtils.generateUrlFrom(currentUrl, currentQuery, "sort=moderator,asc")}"
                    >
                        À modérer
                    </option>
                </select>
            </div>
        </security:authorize>

            <%@ include file="../component/filter-reset.jsp" %>
        </div>
            <c:set var="page" scope="request" value="${pageReviews}"/>
            <%@ include file="../component/pagination-number.jsp" %>
    </div>
    <div class="row">
        <c:forEach items="${pageReviews.content}" var="review">
            <div class="col-lg-4 col-md-6 col-sm-12 mt-4">
                <%@ include file="../component/entity/review-card.jsp" %>
            </div>
        </c:forEach>
    </div>
    <div>
        <a href="${UrlRoute.URL_EXPORT}" class="btn btn-link">
            <i class="fa-solid fa-file-excel me-1"></i>
            Télécharger export Excel
        </a>
    </div>
    <c:set var="page" scope="request" value="${pageReviews}"/>
    <%@ include file="../component/pagination.jsp" %>

</div>

<%@ include file="../footer.jsp" %>