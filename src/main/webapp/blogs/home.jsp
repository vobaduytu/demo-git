<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Colorlib Balita &mdash; Minimal Blog Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300, 400,700" rel="stylesheet">

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<header role="banner">
    <div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-9 social">
                    <a href="#"><span class="fa fa-twitter"></span></a>
                    <a href="#"><span class="fa fa-facebook"></span></a>
                    <a href="#"><span class="fa fa-instagram"></span></a>
                    <a href="#"><span class="fa fa-youtube-play"></span></a>
                    <a href="#"><span class="fa fa-vimeo"></span></a>
                    <a href="#"><span class="fa fa-snapchat"></span></a>
                </div>
                <div class="col-3 search-top">
                    <!-- <a href="#"><span class="fa fa-search"></span></a> -->
                    <form action="home?action=search" method="post" class="search-form">
                        <div class="form-group">
                            <span class="icon fa fa-search"></span>
                            <input type="text" class="form-control" id="searchs" placeholder="Type a keyword and hit enter" name="title">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container logo-wrap">
        <div class="row pt-5">
            <div class="col-12 text-center">
                <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu" role="button"
                   aria-expanded="false" aria-controls="navbarMenu"><span class="burger-lines"></span></a>
                <h1 class="site-logo"><a href="index.html">Balita</a></h1>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-md  navbar-light bg-light">
        <div class="container">


            <div class="collapse navbar-collapse" id="navbarMenu">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="home">Home</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="home?action=category&id=${categorys.id}" id="dropdown05" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Categories</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown05">
                            <c:forEach items="${category}" var="postss">
                                <a class="dropdown-item" href="home?action=category&id=${postss.id}">${postss.title}</a>
                            </c:forEach>
                        </div>

                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.html">Contact</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</header>
<!-- END header -->

<section class="site-section pt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">

                <div class="owl-carousel owl-theme home-slider">
                    <c:forEach items="${listTop3}" var="post">
                        <div>
                            <a href="home?action=postList&id=${post.id}" class="a-block d-flex align-items-center height-lg"
                               style="background-image: url('${post.image}'); ">
                                <div class="text half-to-full">
                                    <div class="post-meta">
                                        <span class="category">${post.category.title}</span>
                                        <span class="mr-2">${post.createDate}</span> &bullet;
                                        <span class="ml-2"><span class="fa fa-comments"></span>3</span>
                                    </div>
                                    <h3>${post.title}</h3>
                                </div>
                            </a>
                        </div>
                    </c:forEach>

                </div>

            </div>
        </div>
        <div class="row">
            <c:forEach items="${listTop3}" var="post">
                <div class="col-md-6 col-lg-4">
                    <a href="home?action=postList&id=${post.id}" class="a-block d-flex align-items-center height-md"
                       style="background-image: url('${post.image}'); ">
                        <div class="text">
                            <div class="post-meta">
                                <span class="category">${post.category.title}</span>
                                <span class="mr-2">${post.createDate}</span> &bullet;
                                <span class="ml-2"><span class="fa fa-comments"></span>3</span>
                            </div>
                            <h3>${post.title}</h3>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- END section -->

<section class="site-section py-sm">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 class="mb-4">Lifestyle Category</h2>
            </div>
        </div>
        <div class="row blog-entries">
            <div class="col-md-12 col-lg-8 main-content">

                <div class="row">
                    <c:forEach items="${listTop6}" var="post">
                        <div class="col-md-6">
                            <a href="home?action=postList&id=${post.id}" class="blog-entry element-animate" data-animate-effect="fadeIn">
                                <img src="${post.image}" alt="Image placeholder">
                                <div class="blog-content-body">
                                    <div class="post-meta">
                                        <span class="category">${post.category.title}</span>
                                        <span class="mr-2">${post.createDate}</span> &bullet;
                                        <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                    </div>
                                    <h2>${post.shortContent}</h2>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>


                <div class="row">
                    <div class="col-md-12 text-center">
                        <nav aria-label="Page navigation" class="text-center">
                            <ul class="pagination">
                                <li class="page-item  active"><a class="page-link" href="#">Prev</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>

            </div>

            <!-- END main-content -->

            <div class="col-md-12 col-lg-4 sidebar">
                <div class="sidebar-box search-form-wrap">
                    <form action="home?action=staff" method="post" class="search-form">
                        <div class="form-group">
                            <span class="icon fa fa-search"></span>
                            <input type="text" class="form-control" id="s" placeholder="Type a keyword and hit enter" name="fullName">
                        </div>
                    </form>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <c:forEach items="${user}" var="users">
                        <div class="bio text-center" style="padding: 70px">
                            <img src="${users.image}" alt="Image Placeholder" class="img-fluid">
                            <div class="bio-body">
                                <h2>${users.fullname}</h2>
                                <p>${users.about}</p>
                                <p><a href="#" class="btn btn-primary btn-sm">Read my bio</a></p>
                                <p class="social">
                                    <a href="#" class="p-2"><span class="fa fa-facebook"></span></a>
                                    <a href="#" class="p-2"><span class="fa fa-twitter"></span></a>
                                    <a href="#" class="p-2"><span class="fa fa-instagram"></span></a>
                                    <a href="#" class="p-2"><span class="fa fa-youtube-play"></span></a>
                                </p>
                            </div>

                        </div>
                    </c:forEach>
                </div>


                <!-- END sidebar-box -->

                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Categories</h3>
                    <ul class="categories">
                        <c:forEach items="${category}" var="postss">
                            <li><a href="home?action=category&id=${postss.id}">${postss.title}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Tags</h3>
                    <ul class="tags">
                        <c:forEach items="${category}" var="postss">
                            <li><a href="home?action=category&id=${postss.id}">${postss.title}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!-- END sidebar -->

        </div>
    </div>
</section>

<footer class="site-footer">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-4">
                <h3>Paragraph</h3>
                <p>
                    <img src="images/img_1.jpg" alt="Image placeholder" class="img-fluid">
                </p>

                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi, accusantium optio unde perferendis
                    eum illum voluptatibus dolore tempora, consequatur minus asperiores temporibus reprehenderit.</p>
            </div>
            <div class="col-md-6 ml-auto">
                <div class="row">
                    <div class="col-md-7">
                        <h3>Latest Post</h3>
                        <c:forEach items="${listTop3}" var="post">
                            <div class="post-entry-sidebar">
                                <ul>
                                    <li>
                                        <a href="home?action=postList&id=${post.id}">
                                            <img src="${post.image}" alt="Image placeholder" class="mr-4">
                                            <div class="text">
                                                <h4>${post.title}</h4>
                                                <div class="post-meta">
                                                    <span class="mr-2">${post.createDate}</span> &bullet;
                                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-md-1"></div>

                    <div class="col-md-4">

                        <div class="mb-5">
                            <h3>Quick Links</h3>
                            <ul class="list-unstyled">
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Travel</a></li>
                                <li><a href="#">Adventure</a></li>
                                <li><a href="#">Courses</a></li>
                                <li><a href="#">Categories</a></li>
                            </ul>
                        </div>

                        <div class="mb-5">
                            <h3>Social</h3>
                            <ul class="list-unstyled footer-social">
                                <li><a href="#"><span class="fa fa-twitter"></span> Twitter</a></li>
                                <li><a href="#"><span class="fa fa-facebook"></span> Facebook</a></li>
                                <li><a href="#"><span class="fa fa-instagram"></span> Instagram</a></li>
                                <li><a href="#"><span class="fa fa-vimeo"></span> Vimeo</a></li>
                                <li><a href="#"><span class="fa fa-youtube-play"></span> Youtube</a></li>
                                <li><a href="#"><span class="fa fa-snapchat"></span> Snapshot</a></li>

                            </ul>
                        </div>
                        <div class="mb-5">
                               <a href="authentication"> Login</a>
                           <a href="authentication?action=register"> Sign Up</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a
                    href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </div>
        </div>
    </div>
</footer>
<!-- END footer -->

<!-- loader -->
<div id="loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#f4b214"/>
    </svg>
</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/jquery-migrate-3.0.0.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>


<script src="js/main.js"></script>
</body>
</html>
