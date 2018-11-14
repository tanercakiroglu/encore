<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 03.11.2018
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <title>Title</title>

</head>
<body>

<!--================Header Menu Area =================-->
<section id="nav">
    <jsp:include page="_header.jsp"></jsp:include>
</section>
<!--================Header Menu Area =================-->

<!--================Home Banner Area =================-->
<section class="home_banner_area" id="home">
    <div class="banner_inner">
        <div class="container">
            <div class="banner_content">
                <h2>Precise concept design <br />for stylish living</h2>
                <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $.17 each.</p>
                <a class="banner_btn" href="#">Get Started</a>
            </div>
        </div>
    </div>
</section>
<!--================End Home Banner Area =================-->


<!--================Feature Area =================-->
<section  class="contact_area p_120">
    <div class="container">
        <div class="main_title">
            <h2>What we offer to our clients</h2>
            <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $.17 each.</p>
        </div>
        <div class="feature_inner row">
            <div class="col-lg-4">
                <div class="feature_item">
                    <img src="/statics/img/icon/f-icon-1.png" alt="">
                    <h4>Architecture</h4>
                    <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $17 each.</p>
                    <a class="main_btn" href="#">View Details</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="feature_item">
                    <img src="/statics/img/icon/f-icon-2.png" alt="">
                    <h4>Interior Design</h4>
                    <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $17 each.</p>
                    <a class="main_btn" href="#">View Details</a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="feature_item">
                    <img src="/statics/img/icon/f-icon-3.png" alt="">
                    <h4>Concept Design</h4>
                    <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $17 each.</p>
                    <a class="main_btn" href="#">View Details</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Feature Area =================-->


<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
