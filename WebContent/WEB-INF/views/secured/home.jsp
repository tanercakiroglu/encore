
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

	<section  id="sec" >

		<div class="container ">
			<div class="row">

				<div class="col-sm-8">
					<form id="loginForm" action="secured/user/proposal" method="get">

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

	<jsp:include page="../_footer.jsp"></jsp:include>
<script src="../../../resources/js/pages/secured/home.js"></script>
</body>
</html>