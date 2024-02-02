<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Se connecter"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="col-lg-4 col-md mx-auto">
  <form method="POST" action="${UrlRoute.URL_LOGIN}" class="form-signin">
    <h2 class="form-heading text-center mb-4">
      Se connecter
    </h2>
    <div class="form-group ${error != null ? 'has-error' : ''}">
      <span>${message}</span>
      <input name="username" type="text" class="form-control mb-4 w-100 opacity-75" placeholder="Username"
             autofocus="true"/>
      <input name="password" type="password" class="form-control w-100 opacity-75" placeholder="Password"/>
      <p class="invalid-feedback" >${error}</p>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <button class="btn btn-primary mb-5"  type="submit">Se connecter</button>
      <h4 class="text-center">
        <a href="${contextPath}/s-inscrire" class="btn-link btn-link-gradient mt-5" title="Lien création de compte">
          Créer un compte
        </a>
      </h4>
    </div>
  </form>
</div>

<%@ include file="../footer.jsp" %>