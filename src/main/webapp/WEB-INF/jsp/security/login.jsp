<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Se connecter"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5" style="max-width:600px">
  <form method="POST" action="${UrlRoute.URL_LOGIN}" class="form-signin">
    <h2 class="form-heading text-center mb-4">
      Log in
    </h2>
    <div class="form-group ${error != null ? 'has-error' : ''}">
      <span>${message}</span>
      <input name="username" type="text" class="form-control mb-4 w-100 opacity-75" placeholder="Username"
             autofocus="true"/>
      <input name="password" type="password" class="form-control w-100 opacity-75" placeholder="Password"/>
      <p class="invalid-feedback" >${error}</p>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <button class="btn btn-lg btn-primary btn-block"  type="submit">Log In</button>
      <h4 class="text-center">
        <a href="${contextPath}/register" class="btn-link mt-5" alt="create link">
          Create an account
        </a>
      </h4>
    </div>
  </form>
</div>

<%@ include file="../footer.jsp" %>