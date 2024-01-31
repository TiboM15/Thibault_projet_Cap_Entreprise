<%@ page contentType="text/html;charset=UTF-8" %>

<a class="col-lg-4 col-md-6 col-sm-12 mt-5 main-game-card" href="${UrlRoute.URL_GAME}/${game.slug}">
    <div class="game-card">
        <div class="row">
            <p class="col-12 m-0 small">${game.name}</p>
            <p class="col-12 m-0 small">${game.publisher.name}</p>
        </div>
        <div class="game-card-img">
            <img alt="${game.name}" src="${game.image}">
        </div>
        <div class="d-flex justify-content-between w-100">
            <p>${dateUtils.getDateFormat(game.publishedAt, "dd/MM/yyyy")}</p>
            <p>${game.genre.name}</p>
        </div>
    </div>
</a>
