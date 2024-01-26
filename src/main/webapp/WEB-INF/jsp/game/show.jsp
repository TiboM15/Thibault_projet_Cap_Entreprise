<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Home"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">
    <h1>Liste des avis</h1>
    <div class="row">
        <c:forEach items="${review}" var="review">
            <a class="col-4 mt-2 main-game-card" href="${s:mvcUrl('AppGame#show').arg(0, game.slug).build()}">
                <div class="game-card">
                    <div class="game-card-img">
                        <img alt="${game.name}" src="${game.thumbnailCover}">
                    </div>
                    <div class="d-flex justify-content-between">
                        <p>${game.name}</p>
                        <p>${game.price}€</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>






<%@ include file="../footer.jsp" %>
