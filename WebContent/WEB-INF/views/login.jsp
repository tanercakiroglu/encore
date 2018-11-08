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

            <section  id="loginForm" >

                <div class="container ">
                    <div class="row">

                        <div class="col-sm-8">


                            <div class="form-group">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email address">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
                            </div>
                            <div class="form-group text-right">
                                <button type="submit" value="submit" class="btn submit_btn">Login</button>
                            </div>

                        </div>

                    </div>
                </div>
            </section>
        </div>
    </div>
</section>

<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
