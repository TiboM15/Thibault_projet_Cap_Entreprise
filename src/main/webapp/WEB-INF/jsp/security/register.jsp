<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5" style="max-width:600px">
  <f:form method="POST" modelAttribute="userForm" class="form-signin">
    <h2 class="form-signin-heading text-center mb-4">
      Create your account
    </h2>
      <div class="form-group mt-2 ${status.error ? 'has-error' : ''} opacity-75">
        <f:input type="text" path="email" class="form-control" placeholder="Email"
                    autofocus="true"/>
        <f:errors path="email" cssClass="invalid-feedback"/>
      </div>
      <div class="form-group mt-2 ${status.error ? 'has-error' : ''} opacity-75">
        <f:input type="text" path="nickname" class="form-control" placeholder="Account name"
                    autofocus="true"/>
        <f:errors path="nickname" cssClass="invalid-feedback"/>
      </div>
      <div class="form-group mt-2 ${status.error ? 'has-error' : ''} opacity-75">
        <f:input type="password" path="password" class="form-control" placeholder="Password"/>
        <f:errors path="password" cssClass="invalid-feedback"/>
      </div>
    <div class="form-group mt-2 ${status.error ? 'has-error' : ''} opacity-75">
      <f:input type="birthedAt" path="birthedAt" class="form-control" placeholder="Birh Date (dd/MM/yyyy)"/>
      <f:errors path="birthedAt" cssClass="invalid-feedback"/>
    </div>
      <button class="btn btn-lg btn-primary btn-block mt-2" type="submit">Submit</button>
  </f:form>
</div>

<%@ include file="../footer.jsp" %>