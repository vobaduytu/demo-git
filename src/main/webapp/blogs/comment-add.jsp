<!-- COPPY CODE TU TEMPLATE COOLADMIN, PAGE INDEX -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">


<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

    <!-- Fontfaces CSS-->
    <link href="../admin-assets/css/font-face.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="../admin-assets/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="../admin-assets/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet"
          media="all">
    <link href="../admin-assets/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="../admin-assets/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../admin-assets/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<div class="page-wrapper">
    <!-- HEADER MOBILE-->
    <header class="header-mobile d-block d-lg-none">
        <div class="header-mobile__bar">
            <div class="container-fluid">
                <div class="header-mobile-inner">
                    <a class="logo" href="index.html">
                        <img src="../admin-assets/images/icon/logo.png" alt="CoolAdmin"/>
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

                    <li>
                        <a href="category">
                            <i class="fas fa-chart-bar"></i>Category Manage</a>
                    </li>
                    <li>
                        <a href="post">
                            <i class="fas fa-table"></i>Post Manage</a>
                    </li>
                    <li>
                        <a href="user">
                            <i class="far fa-check-square"></i>User Manage</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <aside class="menu-sidebar d-none d-lg-block">
        <div class="logo">
            <a href="#">
                <img src="../admin-assets/images/icon/logo.png" alt="Cool Admin"/>
            </a>
        </div>
        <div class="menu-sidebar__content js-scrollbar1">
            <nav class="navbar-sidebar">
                <ul class="list-unstyled navbar__list">
                    <li>
                        <a href="category">
                            <i class="fas fa-chart-bar"></i>Category Manage</a>
                    </li>
                    <li>
                        <a href="post">
                            <i class="fas fa-table"></i>Post Manage</a>
                    </li>
                    <li>
                        <a href="user">
                            <i class="far fa-check-square"></i>User Manage</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="header-wrap">
                        <form class="form-header" action="" method="POST">

                        </form>
                        <div class="header-button">
                            <div class="noti-wrap">
                            </div>
                            <div class="account-wrap">
                                <div class="account-item clearfix js-item-menu">
                                    <div class="image">
                                        <img src="../admin-assets/images/icon/avatar-01.jpg"
                                             alt="${sessionScope.user.fullname}"/>
                                    </div>
                                    <div class="content">
                                        <a class="js-acc-btn" href="#">${sessionScope.user.fullname}</a>
                                    </div>
                                    <div class="account-dropdown js-dropdown">
                                        <div class="info clearfix">
                                            <div class="image">
                                                <a href="#">
                                                    <img src="../admin-assets/images/icon/avatar-01.jpg"
                                                         alt="John Doe"/>
                                                </a>
                                            </div>
                                            <div class="content">
                                                <h5 class="name">
                                                    <a href="#">${sessionScope.user.fullname}</a>
                                                </h5>
                                                <span class="email">${sessionScope.username}</span>
                                            </div>
                                        </div>
                                        <div class="account-dropdown__body">

                                            <div class="account-dropdown__item">
                                                <a href="#">
                                                    <i class="zmdi zmdi-settings"></i>Setting</a>
                                            </div>

                                        </div>
                                        <div class="account-dropdown__footer">
                                            <a href="authentication?action=logout">
                                                <i class="zmdi zmdi-power"></i>Logout</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">

                    <div class="row">
                        <div class="col-12 col-md-12">
                            <h3 class="title-5 m-b-35">Comment Manage</h3>
                        </div>

                        <div class="row ml-3 mb-3">
                            <a href="comment" type="button" class="btn btn-primary">Exit</a>
                        </div>
                    </div>
                    <div class="row">
                        <c:if test="${mess!=null}">
                            <div class="col-12 col-md-12">
                                <div class="alert alert-primary"><i>${mess}</i></div>
                            </div>
                        </c:if>
                    </div>
                    <div class="row">
                        <!-- FORM ADD-->
                        <div class="col-12 col-md-12">
                            <form method="post" class="form-horizontal" action="/comment?action=add">
                                <div class="card-header">
                                    <strong>Add Comment</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="content" class=" form-control-label">Content</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" name="content" id="content" placeholder="Content"
                                                   required class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="email" class=" form-control-label">Email</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="email" required name="email"
                                                   placeholder="Email" value=""
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="post" class=" form-control-label">Post</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <select name="post" id="post" class="form-control-sm form-control">
                                                <c:forEach items="${postList}" var="post">
                                                    <option value="${post.id}">${post.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary btn-sm">
                                        <i class="fa fa-dot-circle-o"></i> Submit
                                    </button>
                                    <button type="reset" class="btn btn-danger btn-sm">
                                        <i class="fa fa-ban"></i> Reset
                                    </button>
                                </div>
                            </form>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-12">

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MAIN CONTENT-->
        <!-- END PAGE CONTAINER-->
    </div>
</div>
<!-- Jquery JS-->
<script src="../admin-assets/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JS-->
<script src="../admin-assets/vendor/bootstrap-4.1/popper.min.js"></script>
<script src="../admin-assets/vendor/bootstrap-4.1/bootstrap.min.js"></script>
<!-- Vendor JS       -->
<script src="../admin-assets/vendor/slick/slick.min.js">
</script>
<script src="../admin-assets/vendor/wow/wow.min.js"></script>
<script src="../admin-assets/vendor/animsition/animsition.min.js"></script>
<script src="../admin-assets/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
</script>
<script src="../admin-assets/vendor/counter-up/jquery.waypoints.min.js"></script>
<script src="../admin-assets/vendor/counter-up/jquery.counterup.min.js">
</script>
<script src="../admin-assets/vendor/circle-progress/circle-progress.min.js"></script>
<script src="../admin-assets/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="../admin-assets/vendor/chartjs/Chart.bundle.min.js"></script>
<script src="../admin-assets/vendor/select2/select2.min.js">
</script>

<!-- Main JS-->
<script src="../admin-assets/js/main.js"></script>
</body>

</html>
<!-- end document-->