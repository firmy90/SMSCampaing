<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Topbar -->
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>



    <!-- Topbar Navbar -->
    <ul class="navbar-nav ml-auto">



        <div class="topbar-divider d-none d-sm-block"></div>

        <!-- Nav Item - User Information -->
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <sec:authorize access="!isAuthenticated()">
                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Witaj</span>
                    <sec:csrfInput/>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${pageContext.request.userPrincipal.principal.username}</span>

            </a>
            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/logout" data-toggle="modal" data-target="#logoutModal">
                    <form class="form-inline mt-3" method="post" action="/logout">
                        <button class="btn btn-outline-primary" type="submit">Wyloguj</button>
                        <sec:csrfInput/>
                    </form>
                </a>
            </div>
            <sec:csrfInput/>
            </sec:authorize>
        </li>


    </ul>

</nav>
<!-- End of Topbar -->