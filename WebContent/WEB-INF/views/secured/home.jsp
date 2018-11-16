<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="tr">
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="../_header.jsp"></jsp:include>
<section class="home_banner_area_sec" id="home">
    <div class="banner_inner">
        <div class="container">
        </div>
    </div>
</section>
<section id="main">
</section>
<jsp:include page="_footer.jsp"></jsp:include>
<script src="/statics/js/pages/secured/home.js" type="text/javascript"></script>
</body>
</html>