<%@ page contentType="text/html;charset=UTF-8" %>

<div class="main-review-card w-100">
    <p class="text-center">
        Rédigé le ${dateUtils.getDateFormat(review.createdAt, "dd/MM/yyyy")}
        par <a class="btn-link" href="${UrlRoute.URL_USER}/${review.gamer.uuid}">${review.gamer.nickname}</a>
    <figcaption class="blockquote-footer text-center">
        <c:if test="${not empty review.moderator}">
            Modéré par <cite title="Source Title">${review.moderator.nickname}</cite> -
            le ${dateUtils.getDateFormat(review.moderatedAt, "dd/MM/yyyy")}
        </c:if>
    <c:if test="${empty review.moderator}">
        <cite class="modeattente" title="Source Title">En attente de moderation ⌛</cite>
        <c:if test="${userLogged.moderator}">
            <a class="btn btn-link rating-20"
               href="${UrlRoute.URL_REVIEW_MODERATE}/${review.id}/1"
               title="Accepter"
            >
                <i class="fa fa-check fa-2x"></i>
            </a>
            /
            <a class="btn btn-link rating-5"
               href="${UrlRoute.URL_REVIEW_MODERATE}/${review.id}/0"
               title="Refuser"
            >
                <i class="fa-solid fa-xmark fa-2x"></i>
            </a>
        </c:if>
    </c:if>
    </figcaption>
    </p>
    <div class="review-card w-100">
        <p class="review-description">
            ${jspUtils.excerpt(review.description, 209)}
        </p>
        <div class="d-flex justify-content-between w-100">
            <p class="${jspUtils.getCssClas(review.rating)}">
                ${jspUtils.getStringRating(review.rating)} / 20
            </p>
            <c:if test="${!game.name.equals(review.game.name)}">
                <a class="btn-link" href="${UrlRoute.URL_GAME}/${review.game.slug}">
                        ${review.game.name}
                </a>
            </c:if>
        </div>
    </div>
</div>