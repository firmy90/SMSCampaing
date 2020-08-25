<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <jsp:include page="/WEB-INF/views/fragments/sidebar.jsp" />
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <jsp:include page="/WEB-INF/views/fragments/topbar.jsp" />
                <div class="container-fluid">
                    <jsp:include page="/WEB-INF/views/fragments/page-heading.jsp" />




                    <p>in container-fluid</p>







                </div>
            </div>
            <jsp:include page="/WEB-INF/views/fragments/footer.jsp"/>
        </div>
    </div>
<jsp:include page="/WEB-INF/views/fragments/scripts-footer.jsp"/>

</body>

</html>