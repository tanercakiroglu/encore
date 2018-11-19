<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 05.11.2018
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="tr">
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css"      href="/statics/css/style.css">
    <link rel="stylesheet" type="text/css"      href="/statics/css/responsive.css">
    <link rel="stylesheet" type="text/css"      href="/statics/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css"      href="/statics/css/data-table.css">
    <link rel="stylesheet" type="text/css"href="/statics/css/bootstrap.min.css">

    <link rel="stylesheet" href="/statics/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="/statics/vendors/linericon/style.css" type="text/css">
    <link rel="stylesheet" href="/statics/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/statics/vendors/owl-carousel/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/statics/vendors/lightbox/simpleLightbox.css" type="text/css">
    <link rel="stylesheet" href="/statics/vendors/animate-css/animate.css" type="text/css">
    <link rel="stylesheet" href="/statics/css/datepicker.css">
    <link rel="stylesheet" href="/statics/css/jquery-ui.min.css">
    <link rel="stylesheet" href="/statics/css/bootstrap-datatable.css">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="/statics/img/favicon.png" type="image/png">
    <script …>
        var ctx = '<%= request.getContextPath()%>';
    </script>
</head>
<body  data-spy="scroll" data-target="#mainNav" data-offset="70">
<!--================Header Menu Area =================-->
<header class="header_area">
    <div class="main_menu" id="mainNav">
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container box_1620">

                <!-- Brand and toggle get grouped for better mobile display -->
                <a class="navbar-brand logo_h" href="index.html"><img src="/statics/img/logo.PNG" alt=""></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                    <ul class="nav navbar-nav menu_nav ml-auto">
                        <security:authorize access="isAuthenticated()">
                            <li class="nav-item"><a class="nav-link" href="#">Welcome  <security:authentication property="principal.username" /></a></li>
                        </security:authorize>
                        <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/app/secured/user/home">anasayfa</a></li>
                        <security:authorize access="!isAuthenticated()">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/login">Oturumu aç</a>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/about">Hakkımızda</a>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/contact">iletişim</a></li>
                        </security:authorize>
                        <security:authorize access="isAuthenticated()">
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/secured/admin/employee">çalışanlar</a></li>
                        </security:authorize>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/secured/user/project">projeler</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/secured/user/proposal">teklifler</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/secured/user/product">ürünler</a></li>
                            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/secured/logout">çıkış</a></li>

                        </security:authorize>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>



</body>
</html>
