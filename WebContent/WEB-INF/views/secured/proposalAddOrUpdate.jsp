<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 15.11.2018
  Time: 10:51
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

            <div class="col-lg-8">
                <form id="proposalForm">

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" id="propName" name="propName"
                                       placeholder="Teklif numarası" value="TKL${selectedProposal.id}">
                            </div>

                            <div class="form-group input-group">
                                <input type="text" class="form-control" id="startDate" name="startDate"
                                       value="${selectedProposal.createdDate}"
                                       autocomplete="off" placeholder="Enter start date"/>
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-default" data-toggle="datepicker"
                                            data-target-name="startDate"><span
                                            class="fa fa-calendar"></span>
                                    </button>
                                </div>
                            </div>
                            <div class="form-group input-group">
                                <select class="form-control">
                                   <c:forEach items="${projects}" var="item" varStatus="status">
                                        <option value="${item.key}">${item.value}</option>
                                        <p> ${status}</p>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-control" id="proposedBy" name="proposedBy"
                                       placeholder="Enter proposed by">
                            </div>


                            <div class="form-group text-right">
                                <button value="submit" type="submit" id="submit_btn" class="btn submit_btn">Kaydet
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

</body>
<jsp:include page="_footer.jsp"></jsp:include>
<script src="/statics/js/pages/secured/proposalOperations.js" type="text/javascript"></script>
</html>
