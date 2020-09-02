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
                <h1 class="h3 mb-0 text-gray-800">Ostatnie wysłane wiadomości</h1>
                <div class="card-body">
                    <div class="card mb-4 py-3 border-left-primary">
                        <div class="card-body">
                            <c:if test="${campaingMessagesPage.hasPrevious()}">
                            <a href=" <c:url value="/generate/report/${pageNumber-1}/${campaingMessagesPage.size}"/>" class="btn hidden btn-light btn-icon-split">
                               <span class="icon text-gray-600"> <i class="fas fa-arrow-left"></i>
                                </span>
                                <span class="text">Previous Page</span>
                            </a>
                            </c:if>
                                    <c:if test="${campaingMessagesPage.hasNext()}">
                            <a href=" <c:url value="/generate/report/${pageNumber+1}/${campaingMessagesPage.size}"/>" class="btn btn-light btn-icon-split">
                                <span class="icon text-gray-600">
                                  <i class="fas fa-arrow-right"></i>
                                </span>
                                <span class="text">Next Page</span>
                            </a>
                                    </c:if>
                                <p>Strona <c:out value="${campaingMessagesPage.number+1}"> </c:out>
                                    z <c:out value="${campaingMessagesPage.totalPages}"></c:out></p>
                            <div class="mb-4"></div>
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
                                        <th>Kampania</th>
                                        <th>Treść</th>
                                        <th>Data wysyłki</th>
                                        <th>Status wysyłki wiadomości</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="el" items="${campaingMessagesList}" varStatus="index">
                                        <tr>
                                            <td><c:out value="${index.count+(pageNumber-1)*campaingMessagesPage.size}"/></td>
                                            <td><c:out value="${el.client.name}"/> <c:out
                                                    value="${el.client.surname}"/></td>
                                            <td><c:out value="${el.client.gender.gender}"/></td>
                                            <td><c:out value="${el.client.birthdate}"/></td>
                                            <td><c:out value="${el.client.occupation.occupation}"/></td>
                                            <td><c:out value="${el.phone.country.name}"/></td>
                                            <td><c:out value="${el.phone.number}"/></td>
                                            <td><c:out value="${el.phone.purpose.purpose}"/></td>
                                            <td><c:out value="${el.phone.type.type}"/></td>
                                            <td><c:out value="${el.campaing.cname}"/></td>
                                            <td><c:out value="${el.content}"/></td>
                                            <td><c:out value="${el.sendingDate}"/></td>
                                            <td><c:out value="${el.sendingStatus}"/></td>
                                        </tr>
                                    </c:forEach>
                                    <%--                                    <c:forEach var="el" items="${campaingMessages}" varStatus="index">--%>
                                    <%--                                        <tr>--%>
                                    <%--                                            <td><c:out value="${index.count}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.clientName}"/> <c:out--%>
                                    <%--                                                    value="${el.clientSurname}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.clientGender}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.clientBirthdate}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.clientOccupation}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.phoneCountryName}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.phoneNumber}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.phonePurposePurpose}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.phoneTypeType}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.campaingCname}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.content}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.sendingDate}"/></td>--%>
                                    <%--                                            <td><c:out value="${el.sendingStatus}"/></td>--%>
                                    <%--                                        </tr>--%>
                                    <%--                                    </c:forEach>--%>
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