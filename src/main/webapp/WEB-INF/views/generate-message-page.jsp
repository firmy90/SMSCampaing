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
                <form method="post" action="/generate/message">
                    <div class="row">
                        <div class="col-lg-4">
                            <h1 class="h3 mb-4 text-gray-800">Stwórz wiadomość dla wybranych klientów</h1>
                        </div>
                        <div class="col-lg-4">
                            <button type="submit" class="btn btn-primary btn-icon-split">
                                <span class="icon text-white-50">
                                       <i class="fas fa-flag"></i>
                                   </span>
                                <span class="text">Wyślij wiadomości</span>

                            </button>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Wybierz nazwę kampanii </h6>
                                </div>
                                <select class="card mb-4 py-3 border-left-primary" name="campaing">
                                    <c:forEach var="el" items="${campaings}">
                                        <option value="<c:out value="${el.cname}"/>"><c:out
                                                value="${el.cname}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Napisz wiadomość</h6>
                                </div>
                                <div class="card-body">
                                <textarea class="card mb-4 py-3 border-left-primary" maxlength="500" name="content"
                                          placeholder="wpisz wiadomość do klientów"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Wybierz serwis wysyłkowy</h6>
                                </div>
                                <select class="card mb-4 py-3 border-left-primary" name="provider">
                                    <c:forEach var="el" items="${providers}">
                                        <option value="<c:out value="${el.provider}"/>"><c:out
                                                value="${el.provider}"/> <input type="hidden" value="${el.id}"
                                                                                name="authId"/></option>
                                    </c:forEach>
                                </select>
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
    <script type="text/javascript" defer src="/vendor/datatables/jquery.dataTables.min.js"></script>
    <script type="text/javascript" defer src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>
    <script type="text/javascript" defer src="/js/demo/datatables-demo.js"></script>
</body>

</html>