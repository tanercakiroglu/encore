
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	HOME SECURED
	<input id="prodId" name="prodId" type="hidden" value="${model}">
	
	<button  type="submit" id="btn" class="btn submit_btn">Login</button>



	<jsp:include page="../_footer.jsp"></jsp:include>
<script src="../../../resources/js/pages/secured/home.js"></script>
</body>
</html>