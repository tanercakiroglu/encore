<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 05.11.2018
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>

<section class="home_banner_area" id="home">
    <div class="banner_inner">
        <div class="container">
            <section  id="loginForm" >

                <div class="container ">
                    <div class="row">

                        <div class="col-sm-8">
                            <div class="form-group">
                                <input type="text" class="form-control" id="name" name="email" placeholder="Enter your name">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="surname" name="password" placeholder="Enter your surname">
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" id="email" name="email" placeholder="Enter email address">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
                            </div>
                            <div class="form-group text-right">
                                <button type="submit" value="submit" class="btn submit_btn">Sign-in</button>
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
