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
                <div class="row">
                    <div class="col-lg-4">
                        <h1 class="h3 mb-4 text-gray-800">Generuj klientów na kampanię</h1>
                    </div>
                    <form id="clientsform" method="post" modelAttribute="clients">
                        <div class="col-lg-4">
                            <a href="#" method="post" class="btn btn-primary btn-icon-split">
                                <span class="icon text-white-50">
                                       <i class="fas fa-flag"></i>
                                   </span>
                                <span class="text">Generuj</span>
                            </a>
                        </div>
                </div>

                <div class="row">
                    <div class="col-lg-4">
                        <!-- <form> -->

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz przedział wiekowy klientów:</h6>
                            </div>
                            <div class="card-body">
                                <input type="number" min="0" placeholder="Min" value="0">
                                <input type="number" min="0" placeholder="Max" value="0">
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz płeć:</h6>
                            </div>
                            <div class="card-body">
                                <label>Wybierz płeć</label>
                                <input type="checkbox" id="scales" name="scales">
                                <label for="scales">Scales</label>
                                <input type="checkbox" id="horns" name="horns">
                                <label for="horns">Horns</label>
                            </div>
                        </div>

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz sektor pracy: </h6>
                            </div>
                            <div class="card-body">
                                <select name="occupation" id="occupation" multiple>
                                    <option value="volvo">Volvo</option>
                                    <option value="saab">Saab</option>
                                </select>
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-4">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz przeznaczenie numeru:</h6>
                            </div>
                            <div class="card-body">
                                <c:forEach var="el" items="${allPurposes}">
                                    <input type="checkbox" name=<c:out  value="${el.purpose}"/> >
                                    <label><c:out  value="${el.purpose}"/></label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz rodzaj numeru:</h6>
                            </div>
                            <div class="card-body">
                                <c:forEach var="el" items="${allTypes}">
                                    <input type="checkbox" name=<c:out  value="${el.type}"/> >
                                    <label><c:out  value="${el.type}"/></label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Wybierz kraj numeru:</h6>
                            </div>
                            <div class="card-body">
                                <select name="country" id="country" multiple>
                                    <option value="volvo">Volvo</option>
                                    <option value="saab">Saab</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                </form>

            </div>

        </div>
    </div>
    <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
</div>
</div>
<jsp:include page="/WEB-INF/views/fragments/scripts-footer.jsp"/>

</body>

</html>