<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <a href="meals" class="navbar-brand"><spring:message code="app.title"/></a>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="sprav.title"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="users"><spring:message code="sprav.users"/></a></li>
                        <li><a href="planes"><spring:message code="sprav.planes"/></a></li>
                        <li><a href="schedules"><spring:message code="sprav.schedules"/></a></li>
                    </ul>
                </li>
                <%--
                <li>
                    <form:form class="navbar-form" action="logout" method="post">
                        <sec:authorize access="isAuthenticated()">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a class="btn btn-info" role="button" href="users"><spring:message code="users.title"/></a>
                            </sec:authorize>
                            <a class="btn btn-info" role="button" href="profile">${userTo.name} profile</a>
                            <input type="submit" class="btn btn-primary" value="<spring:message code="app.logout"/>">
                        </sec:authorize>
                    </form:form>
                </li>
--%>
                <jsp:include page="lang.jsp"/>
            </ul>
        </div>
    </div>
</div>
