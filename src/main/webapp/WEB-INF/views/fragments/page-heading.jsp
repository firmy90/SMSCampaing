<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- Page Heading -->

<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <sec:authorize access="hasRole('ADMIN')">
        <h1 class="h3 mb-0 text-gray-800"></h1>
        <a href="/admin/register" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> Zarejestruj nowego użytkownika</a>
    </sec:authorize>
</div>
