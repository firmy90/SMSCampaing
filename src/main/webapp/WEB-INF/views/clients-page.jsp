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
                <h1 class="h3 mb-0 text-gray-800">Lista użytkowników</h1>

<%--                <div class="card shadow mb-4">--%>
<%--                    <div class="card-header py-3">--%>
<%--                        <h6 class="m-0 font-weight-bold text-primary">Lista użytkowników</h6>--%>
<%--                    </div>--%>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Imię</th>
                                    <th>Nazwisko</th>
                                    <th>Akcja</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="client" items="${lastClients}" varStatus="index">
                                    <tr>
                                        <td>${index.count}</td>
                                        <td>${client.name}</td>
                                        <td>${client.surname}</td>
                                        <td>
                                            <a onclick="return confirm('Jesteś pewien?')"
                                               href='<c:url value="/user/delete?id=${client.id}"/>'>Usuń</a>
                                            <a href='<c:url value="/user/edit?id=${client.id}"/>'>Edit</a>
                                            <a href='<c:url value="/user/show?id=${client.id}"/>'>Pokaż</a>
                                        </td>
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