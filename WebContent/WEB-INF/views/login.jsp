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

<section id="nav">
    <jsp:include page="_header.jsp"></jsp:include>
</section>



<section class="home_banner_area" id="home">
    <div class="banner_inner">
        <div class="container ">

            <section  id="sec" >

                <div class="container ">
                    <div class="row">

                        <div class="col-sm-8">
                            <form id="loginForm" action="<c:url value='/j_spring_security_check' />" method="post">


                                <div class="form-group">
                                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter email address">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
                                </div>
                                <div class="form-group text-right">
                                    <button value="submit" type="submit" id="submit_btn" class="btn submit_btn">Login</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </section>
        </div>
    </div>
</section>

<div id="success" class="modal modal-message fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="fa fa-close"></i>
                </button>
                <h2>Thank you</h2>
                <p>Your message is successfully sent...</p>
            </div>
        </div>
    </div>
</div>

<!-- Modals error -->

<div id="error" class="modal modal-message fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="fa fa-close"></i>
                </button>
                <h2>Sorry !</h2>
                <p> Something went wrong </p>
            </div>
        </div>
    </div>
</div>


<jsp:include page="_footer.jsp"></jsp:include>
<script src="../../resources/js/jquery.form.js"></script>
<script src="../../resources/js/jquery.validate.min.js"></script>
<script src="../../resources/js/pages/login.js"></script>
</body>
</html>
