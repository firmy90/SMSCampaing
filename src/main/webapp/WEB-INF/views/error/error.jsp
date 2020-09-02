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
                <h1 class="h3 mb-0 text-gray-800">Ooops...</h1>
                <div class="card mb-4 py-3 border-left-primary">
                    <div class="card-body">
                        <div class="text-center">
                            <div data-text="404">404</div>
                            <p class="lead text-gray-800 mb-5">Takiej strony nie ma...</p>
                            <p class="text-gray-500 mb-0"><a href="/">Powrót do strony głównej</a></p>
                            <div class="row">
                                <div class="col-1"></div>
                            </div>

                            <sec:authorize access="isAuthenticated()">
                                <c:if test="${exception.message != null}">
                                    <div class="row">
                                        <div class="col">
                                            <div class="card shadow mb-4">
                                                <div class="card-header py-3">
                                                    <h6 class="m-0 font-weight-bold text-primary">Kod błędu:</h6>
                                                </div>
                                                <div class="card-body">
                                                    <pre><c:out value="${exception.message}"/></pre>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </sec:authorize>

                            <sec:authorize access="hasRole('ADMIN')">
                                <div class="row">
                                    <div class="col">
                                        <div class="card shadow mb-4">
                                            <div class="card-header py-3">
                                                <h6 class="m-0 font-weight-bold text-primary">Informacje o błędzie:</h6>
                                            </div>
                                            <div class="card-body">
                                                <c:if test="${stackTrace != null}">
                                                    <pre><c:out value="${stackTrace}"/></pre>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </sec:authorize>

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