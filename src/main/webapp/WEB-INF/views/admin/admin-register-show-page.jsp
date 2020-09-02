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
                <h1 class="h3 mb-0 text-gray-800">Ostatnio dodany użytkownik</h1>
                <div class="card mb-4 py-3 border-left-primary">
                    <div class="row">
                        <div class="col-1"></div>
                        <div class="col-6">
                            <div class="row">
                                <div class="col-lg-4">
                                    <div class="card shadow mb-4">
                                        <div class="card-header py-3">
                                            <h6 class="m-0 font-weight-bold text-primary">Nazwa użytkownika</h6>
                                        </div>
                                        <div class="card-body">
                                            <c:out value="${AttributeUsername}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="card shadow mb-4">
                                        <div class="card-header py-3">
                                            <h6 class="m-0 font-weight-bold text-primary">Imię</h6>
                                        </div>
                                        <div class="card-body">
                                            <c:out value="${AttributeName}"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="card shadow mb-4">
                                        <div class="card-header py-3">
                                            <h6 class="m-0 font-weight-bold text-primary">Nazwisko</h6>
                                        </div>
                                        <div class="card-body">
                                            <c:out value="${AttributeSurname}"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
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