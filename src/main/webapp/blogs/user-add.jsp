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
                        <div class="col-12 col-md-12">
                            <h3 class="title-5 m-b-35">User Manage</h3>
                        </div>

                        <div class="row ml-3 mb-3">
                            <a href="user" type="button" class="btn btn-primary">Exit</a>
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
                            <form method="post" class="form-horizontal" action="/user?action=add">
                                <div class="card-header">
                                    <strong>Add User</strong>
                                </div>
                                <div class="card-body card-block">
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="email" class=" form-control-label">Email</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" name="email" id="email" placeholder="email"
                                                   required class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="password" class=" form-control-label">Pass Word</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="password" required name="password"
                                                   placeholder="password" value=""
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="fullName" class=" form-control-label">Full Name</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="fullName" required name="fullName"
                                                   placeholder="fullName" value=""
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="alias" class=" form-control-label">Alias</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="alias" required name="alias"
                                                   placeholder="alias" value=""
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="role" class=" form-control-label">Role</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <select name="role" id="role" class="form-control-sm form-control">
                                                <option value="1">Admin</option>
                                                <option value="2">Staff</option>
                                                <option value="3">User</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="about" class=" form-control-label">About</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="about" required name="about"
                                                   placeholder="about" value=""
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="image" class=" form-control-label">Image</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="text" id="image" required name="image"
                                                   placeholder="image" value=""
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3">
                                            <label for="yob" class=" form-control-label">Yob</label>
                                        </div>
                                        <div class="col-12 col-md-9">
                                            <input type="number" id="yob" required name="yob"
                                                   placeholder="yob" value=""
                                                   class="form-control">
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