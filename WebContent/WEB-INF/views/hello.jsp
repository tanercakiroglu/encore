<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 09.11.2018
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<section  id="sec" >

    <div class="container ">
        <div class="row">

            <div class="col-sm-8">
                <form id="loginForm" action="<c:url value='/j_spring_security_check' />" method="post">


                    <div class="form-group">
                        <input type="email" class="form-control" id="email" name="j_username" placeholder="Enter email address">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="j_password" placeholder="Enter password">
                    </div>
                    <div class="form-group text-right">
                        <button value="submit" type="submit" id="submit_btn" class="btn submit_btn">Login</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
