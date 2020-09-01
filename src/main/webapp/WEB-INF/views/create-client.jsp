<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
                <h1 class="h3 mb-0 text-gray-800">Dodaj nowego klienta</h1>
                <div class="card mb-4 py-3 border-left-primary">

                    <form:form method="post" action="/create/client" modelAttribute="clientData">
                        <div class="row">
                            <div class="col-1"><c:out value="${message}"/></div>
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label for="name">Imię</label>
                                    <form:input type="text" required="true" path="name" id="name"
                                                class="form-control"
                                                placeholder="Podaj imię"/>
                                    <form:errors path="name"/>
                                </div>
                                <div class="form-group">
                                    <label for="surname">Nazwisko</label>
                                    <form:input type="text" required="true" path="surname" id="surname"
                                                class="form-control"
                                                placeholder="Podaj nazwisko"/>
                                    <form:errors path="surname"/>
                                </div>
                                <div class="form-group">
                                    <label for="birthdate">Data urodzenia</label>
                                    <form:input type="date" required="true" path="birthdate" id="birthdate"
                                                class="form-control"
                                                placeholder="YYYY-MM-DD"/>
                                    <form:errors path="birthdate"/>
                                </div>
                               <div class="card shadow mb-4">
                                   <div class="card-header py-3">
                                      <h6 class="m-0 font-weight-bold text-primary">Wybierz płeć:</h6>
                                   </div>
                                   <select class="card mb-4 py-3 border-left-primary" name="gender"
                                            id="gender" size="${fn:length(genders)}">
                                       <c:forEach var="el" items="${genders}">
                                           <option value="<c:out value="${el.gender}"/>"><c:out
                                                   value="${el.gender}"/></option>
                                       </c:forEach>
                                   </select>
                               </div>
                            </div>

                            <div class="col-lg-4">
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Wybierz sektor pracy: </h6>
                                    </div>
                                    <select class="card mb-4 py-3 border-left-primary" name="occupation"
                                            id="occupation" size="${fn:length(occupations)}">
                                        <c:forEach var="el" items="${occupations}">
                                            <option value="<c:out value="${el.occupation}"/>"><c:out
                                                    value="${el.occupation}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">

                            <button class="btn btn-primary" type="submit">Dodaj klienta</button>
<%--                            <button class="btn btn-secondary" type="reset">Wyczyść dane</button>--%>
                        </div>
                        <sec:csrfInput/>
                    </form:form>
                    <div class="col-5"></div>
                </div>
            </div>
            <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/fragments/scripts-footer.jsp"/>

</body>

</html>