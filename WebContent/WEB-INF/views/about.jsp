
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

</head>
<body>

<jsp:include page="_header.jsp"/>

<!--================Home Banner Area =================-->
<section class="banner_area">
    <div class="banner_inner d-flex align-items-center">
        <div class="overlay bg-parallax" data-stellar-ratio="0.9" data-stellar-vertical-offset="0" data-background=""></div>
        <div class="container">
            <div class="banner_content text-center">
                <h2>About Us</h2>
                <div class="page_link">
                    <a href="index.html">Home</a>
                    <a href="about-us.html">About Us</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Home Banner Area =================-->

<!--================Design Area =================-->
<section class="design_area p_120">
    <div class="container">
        <div class="design_inner row">
            <div class="col-lg-5">
                <img class="img-fluid" src="/statics/img/design-1.jpg" alt="">
            </div>
            <div class="col-lg-7">
                <div class="design_left_text">
                    <h6>Welcome to Maxitecture </h6>
                    <h2>Precise concept <br /> design for<br /> stylish living</h2>
                    <h5>Precise concept design for unique stylish living alone</h5>
                    <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $.17 each.</p>
                    <a class="main_btn" href="#">More About Us</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Design Area =================-->

<!--================Post Slider Area =================-->
<section class="post_slider_area">
    <div class="main_title">
        <h2>Our Recent Completed Projects</h2>
        <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $.17 each.</p>
    </div>
    <div class="post_slider_inner owl-carousel">
        <div class="item">
            <div class="post_s_item">
                <div class="post_img">
                    <img src="/statics/img/post-slider/post-s-1.jpg" alt="">
                </div>
                <div class="post_text">
                    <a href="single-blog.html"><h4>Nest Protect: 2nd Gen Smoke + CO Alarm</h4></a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>
                    <a class="main_btn" href="#">View Details</a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="post_s_item">
                <div class="post_img">
                    <img src="/statics/img/post-slider/post-s-2.jpg" alt="">
                </div>
                <div class="post_text">
                    <a href="single-blog.html"><h4>Nest Protect: 2nd Gen Smoke + CO Alarm</h4></a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>
                    <a class="main_btn" href="#">View Details</a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="post_s_item">
                <div class="post_img">
                    <img src="/statics/img/post-slider/post-s-3.jpg" alt="">
                </div>
                <div class="post_text">
                    <a href="single-blog.html"><h4>Nest Protect: 2nd Gen Smoke + CO Alarm</h4></a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>
                    <a class="main_btn" href="#">View Details</a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="post_s_item">
                <div class="post_img">
                    <img src="/statics/img/post-slider/post-s-4.jpg" alt="">
                </div>
                <div class="post_text">
                    <a href="single-blog.html"><h4>Nest Protect: 2nd Gen Smoke + CO Alarm</h4></a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>
                    <a class="main_btn" href="#">View Details</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Post Slider Area =================-->

<!--================Testimonials Area =================-->
<section class="testimonials_area p_120">
    <div class="container">
        <div class="main_title">
            <h2>What Customer Say About Us</h2>
            <p>If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $.17 each.</p>
        </div>
        <div class="testi_slider owl-carousel">
            <div class="item">
                <div class="testi_item">
                    <div class="media">
                        <div class="d-flex">
                            <img src="/statics/img/testimonials/testi-1.png" alt="">
                        </div>
                        <div class="media-body">
                            <p>Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware.</p>
                            <h4>Mark Alviro Wiens</h4>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="testi_item">
                    <div class="media">
                        <div class="d-flex">
                            <img src="/statics/img/testimonials/testi-2.png" alt="">
                        </div>
                        <div class="media-body">
                            <p>Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware.</p>
                            <h4>Mark Alviro Wiens</h4>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="testi_item">
                    <div class="media">
                        <div class="d-flex">
                            <img src="/statics/img/testimonials/testi-1.png" alt="">
                        </div>
                        <div class="media-body">
                            <p>Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware.</p>
                            <h4>Mark Alviro Wiens</h4>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="testi_item">
                    <div class="media">
                        <div class="d-flex">
                            <img src="/statics/img/testimonials/testi-2.png" alt="">
                        </div>
                        <div class="media-body">
                            <p>Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware.</p>
                            <h4>Mark Alviro Wiens</h4>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="testi_item">
                    <div class="media">
                        <div class="d-flex">
                            <img src="/statics/img/testimonials/testi-1.png" alt="">
                        </div>
                        <div class="media-body">
                            <p>Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware.</p>
                            <h4>Mark Alviro Wiens</h4>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="testi_item">
                    <div class="media">
                        <div class="d-flex">
                            <img src="/statics/img/testimonials/testi-2.png" alt="">
                        </div>
                        <div class="media-body">
                            <p>Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware.</p>
                            <h4>Mark Alviro Wiens</h4>
                            <div class="rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star-half-o"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Testimonials Area =================-->

<!--================Clients Logo Area =================-->
<section class="clients_logo_area p_120">
    <div class="container">
        <div class="clients_slider owl-carousel">
            <div class="item">
                <img src="/statics/img/clients-logo/c-logo-1.png" alt="">
            </div>
            <div class="item">
                <img src="/statics/img/clients-logo/c-logo-2.png" alt="">
            </div>
            <div class="item">
                <img src="/statics/img/clients-logo/c-logo-3.png" alt="">
            </div>
            <div class="item">
                <img src="/statics/img/clients-logo/c-logo-4.png" alt="">
            </div>
            <div class="item">
                <img src="/statics/img/clients-logo/c-logo-5.png" alt="">
            </div>
        </div>
    </div>
</section>
<!--================End Clients Logo Area =================-->

<jsp:include page="_footer.jsp"/>
<!--================End Footer Area =================-->




<!-- Optional JavaScript -->

</body>
</html>