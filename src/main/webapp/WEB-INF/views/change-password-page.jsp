<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="pl">
<head>

    <jsp:include page="/WEB-INF/views/fragments/header.jsp"/>

</head>
<body id="page-top">
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/fragments/sidebar.jsp"/>
    <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
            <jsp:include page="/WEB-INF/views/fragments/topbar.jsp"/>
            <div class="container-fluid">
                <jsp:include page="/WEB-INF/views/fragments/page-heading.jsp"/>
                <h1 class="h3 mb-0 text-gray-800">Zmiana hasła użytkownika</h1>
                <div class="card mb-4 py-3 border-left-primary">
                    <div class="row">
                        <div class="col-1"></div>
                        <div class="col-6">
                            <form:form method="post" action="/change/password" modelAttribute="passwordData">
                                <div class="row">
                                    <div class="col-lg-4">

                                        <div class="card shadow mb-4">
                                            <div class="card-header py-3">
                                                <h6 class="m-0 font-weight-bold text-primary">Nazwa użytkownika</h6>
                                            </div>
                                            <div class="card-body">
                                                <form:hidden path="username"/>
                                                <c:out value="${passwordData.username}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="card shadow mb-4">
                                            <div class="card-header py-3">
                                                <h6 class="m-0 font-weight-bold text-primary">Imię</h6>
                                            </div>
                                            <div class="card-body">
                                                <form:hidden path="name"/>
                                                <c:out value="${passwordData.name}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <div class="card shadow mb-4">
                                            <div class="card-header py-3">
                                                <h6 class="m-0 font-weight-bold text-primary">Nazwisko</h6>
                                            </div>
                                            <div class="card-body">
                                                <form:hidden path="surname"/>
                                                <c:out value="${passwordData.surname}"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${passwordData.code==0}">
                                    <div class="form-group">
                                        <label for="password">Hasło</label>
                                        <form:input type="password" id="password" required="true" path="password"
                                                    class="form-control" placeholder="Podaj hasło"/>
                                        <form:errors path="password"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="rePassword">Powtórz Hasło</label>
                                        <form:input type="password" required="true" path="rePassword" id="rePassword"
                                                    class="form-control" placeholder="Powtórz hasło"/>
                                        <form:errors path="rePassword"/>
                                    </div>
                                    <button class="btn btn-primary" type="submit">Zmień hasło</button>
                                    <button class="btn btn-secondary" type="reset">Wyczyść dane</button>
                                </c:if>
                                <sec:csrfInput/>
                            </form:form>
                            <c:if test="${passwordData.code==1}">
                                <div class="card mb-4 py-3 border-bottom-primary">
                                    <div class="card-body">Hasło zostało pomyślnie zmienione</div>
                                </div>
                                    <a href="/" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                                        <i class="fas fa-download fa-sm text-white-50"></i> Powrót na stronę główną</a>

                            </c:if>

                        </div>

                        <div class="col-5"></div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
    </div>
</div>
<jsp:include page="/WEB-INF/views/fragments/scripts-footer.jsp"/>

</body>

</html>