<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>


<div class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Kampanie Marketingowe</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="/generate/clients"><i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Generuj listę</span></a>
    </li>

    <!-- Divider -->
    <div class="sidebar-divider"></div>


    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
           aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Pokaż</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Dostępne dane:</h6>
                <a class="collapse-item" href=" <c:url value="/"/>"> Kampanie</a>
                <a class="collapse-item" href=" <c:url value="/occupations"/>"> Sektory pracy</a>
                <a class="collapse-item" href=" <c:url value="/phones"/>">Klienci</a>
                <a class="collapse-item" href=" <c:url value="/generate/report"/>">Ostatnie wiadomości</a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <div class="sidebar-divider"></div>
    <sec:authorize access="hasRole('ADMIN')">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/admin/register"/>">
                <i class="fas fa-fw fa-folder"></i>
                <span>Zarejestruj użytkownika</span></a>
        </li>
    </sec:authorize>
    <sec:authorize access="!hasRole('ADMIN')">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/change/password"/>">
                <i class="fas fa-fw fa-folder"></i>
                <span>Zmień swoje hasło</span></a>
        </li>
    </sec:authorize>


    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

    </ul>
    <!-- End of Sidebar -->
</div>