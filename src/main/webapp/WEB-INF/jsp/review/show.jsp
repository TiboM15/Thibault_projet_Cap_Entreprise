<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Avis"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
    <div class="row">
        <p class="d-flex justify-content-end mt-4">page ${pageReviews.number + 1} sur ${pageReviews.totalPages}</p>
        <c:forEach items="${pageReviews.content}" var="review">
            <div class="col-lg-4 col-md-6 col-sm-12 mt-4">
                <div class="main-review-card w-100">
                    <p class="text-center">
                        Le ${dateUtils.getDateFormat(review.createdAt, "dd/MM/yyyy")}
                        par <a class="btn-link" href="#">${review.gamer.nickname}</a>
                    </p>
                    <div class="review-card w-100">
                        <p style="font-family: Arial, sans-serif" class="review-description">
                                ${jspUtils.excerpt(review.description, 209)}
                        </p>
                        <div class="d-flex justify-content-between">
                            <p class= "${jspUtils.getCssClas(review.rating)}">
                                    ${jspUtils.getStringRating(review.rating)} / 20
                            </p>
                            <a class="btn-link" href="#">
                                    ${review.game.name}
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:set var="page" scope="request" value="${pageReviews}"/>
    <c:set var="url" scope="request" value="/"/>
    <%@ include file="../component/pagination.jsp" %>

</div>

<%@ include file="../footer.jsp" %>