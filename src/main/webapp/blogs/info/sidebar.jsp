<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="menu-sidebar d-none d-lg-block">
    <div class="logo">
        <a href="#">
            <img src="../../admin-assets/images/icon/logo.png" alt="Cool Admin"/>
        </a>
    </div>
    <div class="menu-sidebar__content js-scrollbar1">
        <nav class="navbar-sidebar">
            <ul class="list-unstyled navbar__list">
                <c:if test="${role != 3}">
                    <li>
                        <a href="category">
                            <i class="fas fa-chart-bar"></i>Category Manage</a>
                    </li>
                </c:if>
                <li>
                    <a href="post">
                        <i class="fas fa-table"></i>Post Manage</a>
                    </a>
                </li>
                <li>
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
        </nav>
    </div>
</aside>