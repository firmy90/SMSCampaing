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
                <h1 class="h3 mb-0 text-gray-800">Dostępne numery telefonów</h1>

                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Klient</th>
                                    <th>Państwo</th>
                                    <th>Numer telefonu</th>
                                    <th>Przeznaczenie jego użycia</th>
                                    <th>Typ numer</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="el" items="${phones}" varStatus="index">
                                    <tr>
                                        <td> <c:out value="${index.count}"/></td>
                                        <td><c:out value="${el.client.name}"/>    <c:out value="${el.client.surname}"/></td>
                                        <td><c:out value="${el.country.name}"/></td>
                                        <td><c:out value="${el.number}"/></td>
                                        <td><c:out value="${el.purpose}"/></td>
                                        <td><c:out value="${el.type}"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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