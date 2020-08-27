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
                <h1 class="h3 mb-0 text-gray-800">Rejestracja nowego użytkownika</h1>
                <div class="card mb-4 py-3 border-left-primary">
                    <div class="row">
                        <div class="col-1"></div>
                        <div class="col-6">
                            <form:form method="post" action="/admin/register" modelAttribute="registrationData">
                                <div class="form-group">
                                    <label for="username">Nazwa użytkownika</label>
                                    <form:input type="text" required="true" path="username" id="username"
                                                class="form-control" placeholder="Podaj nazwę użytkownika"/>
                                </div>
                                <div class="form-group">
                                    <label for="name">Imię</label>
                                    <form:input type="text" required="true" path="name" id="name" class="form-control"
                                                placeholder="Podaj imię"/>
                                </div>
                                <div class="form-group">
                                    <label for="surname">Nazwisko</label>
                                    <form:input type="text" required="true" path="surname" id="surname"
                                                class="form-control"
                                                placeholder="Podaj nazwisko"/>
                                </div>
                                <div class="form-group">
                                    <label for="password">Hasło</label>
                                    <form:input type="password" required="true" path="password" id="password"
                                                class="form-control" placeholder="Podaj hasło"/>
                                </div>
                                <button class="btn btn-primary" type="submit">Zarejestruj Użytkownika</button>
                                <button class="btn btn-secondary" type="reset">Wyczyść dane</button>
                                <sec:csrfInput/>
                            </form:form>
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