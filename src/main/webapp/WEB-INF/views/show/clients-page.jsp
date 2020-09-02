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
                <h1 class="h3 mb-0 text-gray-800">Klienci</h1>
                <div class="card mb-4 py-3 border-left-primary">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Imię i nazwisko</th>
                                    <th>Data urodzenia</th>
                                    <th>Płeć</th>
                                    <th>Sektor zatrudnienia</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="client" items="${clientsPage}" varStatus="index">
                                    <tr>
                                        <td><c:out value="${index.count}"/></td>
                                        <td><c:out value="${client.name}"/> <c:out value="${client.surname}"/></td>
                                        <td><c:out value="${client.birthdate}"/></td>
                                        <td><c:out value="${client.genderGender}"/></td>
                                        <td><c:out value="${client.occupationOccupation}"/></td>
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
<script type="text/javascript" defer src="/static/vendor/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" defer src="/static/vendor/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" defer src="/static/js/demo/datatables-demo.js"></script>

</body>

</html>