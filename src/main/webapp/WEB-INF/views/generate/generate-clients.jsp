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
                <form method="post" >
                <div class="row">
                    <div class="col-lg-4">
                        <h1 class="h3 mb-4 text-gray-800">Generuj klientów na kampanię</h1>
                    </div>

                        <div class="col-lg-4">
                            <button type="submit" class="btn btn-primary btn-icon-split">
                                <span class="icon text-white-50">
                                       <i class="fas fa-flag"></i>
                                   </span>
                                <span class="text">Generuj</span>
                            </button>
                        </div>
                </div>

                <div class="row">
                    <div class="col-lg-4">

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz przedział wiekowy klientów:</h6>
                            </div>
                            <div class="card-body">
                                <input class="form-control form-control-user" name="ageMin" type="number" min="0" step = "1" placeholder="Min">
                                <input class="form-control form-control-user"  name="ageMax" type="number" min="0" step="1" placeholder="Max">
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz płeć:</h6>
                            </div>
                            <div class="card-body">
                                <c:forEach var="el" items="${allGenders}">
                                    <input type="checkbox" value="<c:out value="${el.gender}"/>" name= "gender" id="<c:out value="${el.gender}"/>">
                                    <label for="<c:out value="${el.gender}"/>"><c:out value="${el.gender}"/></label>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz sektor pracy: </h6>
                            </div>
                                <select class="card mb-4 py-3 border-left-primary" name="occupation" id="occupation" multiple size="${fn:length(allOccupations)}">
                                    <c:forEach var="el" items="${allOccupations}">
                                        <option value="<c:out value="${el.occupation}"/>"><c:out value="${el.occupation}"/></option>
                                    </c:forEach>
                                </select>
                        </div>

                    </div>

                    <div class="col-lg-4">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz przeznaczenie numeru:</h6>
                            </div>
                            <div class="card-body">
                                <c:forEach var="el" items="${allPurposes}">
                                    <input type="checkbox" name= "purpose" value="<c:out value="${el.purpose}"/>" id ="<c:out value="${el.purpose}"/>">
                                    <label for="<c:out value="${el.purpose}"/>"><c:out value="${el.purpose}"/></label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz rodzaj numeru:</h6>
                            </div>
                            <div class="card-body">
                                <c:forEach var="el" items="${allTypes}">
                                    <input type="checkbox" name= "type" value="<c:out value="${el.type}"/>" id="<c:out value="${el.type}"/>">
                                    <label for="<c:out value="${el.type}"/>"><c:out value="${el.type}"/></label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz kraj numeru:</h6>
                            </div>

                                <select class="card mb-4 py-3 border-left-primary" name="country" id="country" multiple size="${fn:length(allCountries)}">
                                    <c:forEach var="el" items="${allCountries}" >
                                        <option value="<c:out value="${el.countryName}"/>"><c:out value="${el.countryName}"/></option>
                                    </c:forEach>
                                </select>
                        </div>
                    </div>
                </div>
                    <sec:csrfInput/>
                </form>


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