<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 14.11.2018
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>

    <title>Title</title>
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

    <div class="container ">
        <div class="row">

            <div class="col-lg-12">
                <div class="form-group text-left">
                    <a href="${pageContext.request.contextPath}/app/secured/user/proposal/operations"  id="submit_btn" class="btn submit_btn">Teklif Yarat
                    </a>
                </div>

                <div class="table-responsive">
                    <table id="proposals" class="table display table-striped table-bordered" style="width:100%">
                        <thead>
                        <tr>
                            <th>Numarası</th>
                            <th>Oluşturma Tarihi</th>
                            <th>Proje Adı</th>
                            <th>Ürün Adı</th>
                            <th>Ürün Satış</th>
                            <th>Teslim Şekli</th>
                            <th>Ödeme Şekli</th>
                            <th>Ödeme Süresi</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${proposals}" var="item">
                            <tr>
                                <td>TKL-${item.id}</td>
                                <td> ${item.createdDate}</td>
                                <td>PRJ-${item.projectId}</td>
                                <td>PRD-${item.productId}</td>
                                <td> ${item.salePrice}</td>
                                <td> ${item.deliveryType}</td>
                                <td> ${item.paymentType}</td>
                                <td> ${item.paymentPeriod}</td>
                                <td><i id="${item.id}" class="fa fa-edit fa-2x"></i></td>
                                <td><i id="${item.id}" class="fa fa-remove fa-2x"></i></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>


            </div>
        </div>
    </div>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
<script type="text/javascript" src="/statics/js/pages/secured/proposal.js"></script>
</body>
</html>
