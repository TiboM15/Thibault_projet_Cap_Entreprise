<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="CAP ENTREPRISE"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
    <h1 alt="text">Jeux du moment</h1>
    <div class="row">
        <c:forEach items="${gamesReleased}" var="game">
            <a class="col-4 mt-2 main-game-card mb-4" href="${s:mvcUrl('AppGame#show').arg(0, game.slug).build()}">
                <div class="game-card">
                    <div class="game-card-img">
                        <img alt="${game.name}" src="${game.image}">
                    </div>
                    <div class="d-flex justify-content-between">
                        <p>${game.name}</p>

                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

<%@ include file="footer.jsp" %>
