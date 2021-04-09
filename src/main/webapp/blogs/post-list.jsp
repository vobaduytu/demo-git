<!-- COPPY CODE TU TEMPLATE COOLADMIN, PAGE INDEX -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link href="../admin-assets/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
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

    <c:import url="info/header.jsp"/>
    <!-- END HEADER MOBILE-->

    <!-- MENU SIDEBAR-->
    <c:import url="info/sidebar.jsp"/>
    <!-- END MENU SIDEBAR-->

    <!-- PAGE CONTAINER-->
    <div class="page-container">
        <!-- HEADER DESKTOP-->
        <c:import url="info/desktop.jsp"/>
        <!-- HEADER DESKTOP-->

        <!-- MAIN CONTENT-->
        <div class="main-content">
            <div class="section__content section__content--p30">
                <div class="container-fluid">
                    <div class="row">


                        <div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Post Manage</h3>
                                <c:if test='${mess != null}'>
                                    <div class="alert alert-danger">
                                        <strong>${mess}</strong>
                                    </div>
                                </c:if>
                                <div class="table-data__tool-right">

                                    <a href="/post?action=add" class="au-btn au-btn-icon au-btn--green au-btn--small">
                                        <i class="zmdi zmdi-plus"></i>add post
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive table-responsive-data2">
                            <table class="table table-data2">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>Short Content</th>
                                    <th>Image</th>
                                    <th>Create Date</th>
                                    <th>Modifile Date</th>
                                    <th>User</th>
                                    <th>Category</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${sessionScope.user.role == 3}">
                                    <c:forEach items="${postListUser}" var="post">
                                        <tr class="tr-shadow">
                                            <td>${post.id}</td>
                                            <td>${post.title}</td>
                                            <td>${post.shortContent}</td>
                                            <td><img src="${post.image}" alt=""></td>
                                            <td>${post.createDate}</td>
                                            <td>${post.modifiledDate}</td>
                                            <td>${post.user.fullname}</td>
                                            <td>${post.category.title}</td>
                                            <td>
                                                <div class="table-data-feature">

                                                    <a href="/post?action=update&id=${post.id}" class="item" data-toggle="tooltip" data-placement="top"
                                                       title="Edit">
                                                        <i class="zmdi zmdi-edit"></i>
                                                    </a>
                                                    <a href="/post?action=delete&id=${post.id}" class="item" data-toggle="tooltip" data-placement="top"
                                                       title="Delete" onclick="return confirm('co chac muon xoa khong?')">
                                                        <i class="zmdi zmdi-delete"></i>
                                                    </a>

                                                </div>
                                            </td>
                                        </tr>
                                        <tr class="spacer"></tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${sessionScope.user.role != 3}">
                                    <c:forEach items="${list}" var="post">
                                        <tr class="tr-shadow">
                                            <td>${post.id}</td>
                                            <td>${post.title}</td>
                                            <td>${post.shortContent}</td>
                                            <td><img src="${post.image}" alt=""></td>
                                            <td>${post.createDate}</td>
                                            <td>${post.modifiledDate}</td>
                                            <td>${post.user.fullname}</td>
                                            <td>${post.category.title}</td>
                                            <td>
                                                <div class="table-data-feature">

                                                    <a href="/post?action=update&id=${post.id}" class="item" data-toggle="tooltip" data-placement="top"
                                                       title="Edit">
                                                        <i class="zmdi zmdi-edit"></i>
                                                    </a>
                                                    <a href="/post?action=delete&id=${post.id}" class="item" data-toggle="tooltip" data-placement="top"
                                                       title="Delete" onclick="return confirm('co chac muon xoa khong?')">
                                                        <i class="zmdi zmdi-delete"></i>
                                                    </a>

                                                </div>
                                            </td>
                                        </tr>
                                        <tr class="spacer"></tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                        <!-- END DATA TABLE -->
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="copyright">
                            <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a
                                    href="https://colorlib.com">Colorlib</a>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END MAIN CONTENT-->
<!-- END PAGE CONTAINER-->

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