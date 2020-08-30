<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
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
                <form method="post" action="/generate/send">
                    <div class="row">
                        <div class="col-lg-4">
                            <h1 class="h3 mb-4 text-gray-800">Potwierdź wysyłkę</h1>
                        </div>
                        <div class="col-lg-4">
                            <button type="submit" class="btn btn-primary btn-icon-split">
                                <span class="icon text-white-50">
                                       <i class="fas fa-flag"></i>
                                   </span>
                                <span class="text">Wyślij</span>
                            </button>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Nazwa kampanii </h6>
                                </div>
                                <div class="card-body">
                                    <c:out value="${campaingByName.campaingCname}"/>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Wiadomość</h6>
                                    </div>
                                    <div class="card-body">
                                        <c:out value="${campaingByName.content}"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Wybierz serwis wysyłkowy</h6>
                                    </div>
                                    <div class="card-body">
                                        <c:out value="${campaingByName.authorizationParameter.provider}"/>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <sec:csrfInput/>
                </form>

                <h1 class="h3 mb-0 text-gray-800">Wybrani klienci:</h1>
                <div class="card-body">
                    <div class="card mb-4 py-3 border-left-primary">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Klient</th>
                                        <th>Płeć</th>
                                        <th>Data urodzenia</th>
                                        <th>Sektor Zatrudnienia</th>
                                        <th>Państwo</th>
                                        <th>Numer telefonu</th>
                                        <th>Przeznaczenie jego użycia</th>
                                        <th>Typ numeru</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="el" items="${phonesSes}" varStatus="index">
                                        <tr>
                                            <td><c:out value="${index.count}"/></td>
                                            <td><c:out value="${el.clientName}"/> <c:out
                                                    value="${el.clientSurname}"/></td>
                                            <td><c:out value="${el.clientGender}"/></td>
                                            <td><c:out value="${el.clientBirthdate}"/></td>
                                            <td><c:out value="${el.clientOccupation}"/></td>
                                            <td><c:out value="${el.countryName}"/></td>
                                            <td><c:out value="${el.number}"/></td>
                                            <td><c:out value="${el.purposePurpose}"/></td>
                                            <td><c:out value="${el.typeType}"/></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
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