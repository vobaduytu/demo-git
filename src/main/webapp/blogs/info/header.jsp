<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header-mobile d-block d-lg-none">
    <div class="header-mobile__bar">
        <div class="container-fluid">
            <div class="header-mobile-inner">
                <a class="logo" href="index.html">
                    <img src="../../admin-assets/images/icon/logo.png" alt="CoolAdmin"/>
                </a>
                <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                </button>
            </div>
        </div>
    </div>
    <nav class="navbar-mobile">
        <div class="container-fluid">
            <ul class="navbar-mobile__list list-unstyled">
                <c:if test="${role != 3}">
                <li>
                    <a href="category">
                        <i class="fas fa-chart-bar"></i>Category Manage</a>
                </li>
                </c:if>
                <li>
                    <a href="post">
                        <i class="fas fa-table"></i>Post Manage
                    </a>
                    <a href="home">
                        <i class="fas fa-table"></i>Home
                    </a>
                </li>
                <c:if test="${role == 1}">
                <li>
                    <a href="user">
                        <i class="far fa-check-square"></i>User Manage</a>
                </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>