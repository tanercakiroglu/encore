<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 14.11.2018
  Time: 11:24
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
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>

<jsp:include page="../_header.jsp"></jsp:include>
<section class="home_banner_area_sec" id="home">
    <div class="banner_inner">
        <div class="container">
            <div class="banner_content">
            </div>
        </div>
    </div>
</section>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<section id="main">

    <div class="container ">
        <form id="employeeForm">
            <div class="row">
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-4">
                            <label>Çalışanın Tc No :</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="employeeId" name="employeeId"
                                       placeholder="Çalışanın Tc Kimlik Numarası">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Çalışanın Adı :</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="text" class="form-control" id="employeeName" name="employeeName"
                                       placeholder="Çalışanın Adı">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>Çalışanın Soyadı:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="text" class="form-control" id="employeeSurname" name="employeeSurname"
                                       placeholder="Çalışanın Soyadı">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>Çalışanın Tipi:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group input-group">
                                <select class="form-control" id="employeeType">
                                    <option value="Seçiniz" selected>Seçiniz</option>
                                    <c:forEach items="${employeeSelectList}" var="item" varStatus="status">
                                        <option value="${item.key}">${item.value}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>Doğum Tarihi:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group input-group">
                                <input type="hidden" id="hiddenDate" name="hiddenDate">
                                <input type="text" maxlength="10" class="form-control" id="employeeBirthDay"
                                       name="employeeBirthDay"
                                       autocomplete="off" placeholder="Doğum Tarihi "/>
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-default" data-toggle="datepicker"
                                            data-target-name="employeeBirthDay"><span
                                            class="fa fa-calendar"></span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-4">
                            <label>Pasaport No:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="employeePassportId"
                                       name="employeePassportId"
                                       placeholder="Pasaport No">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Telefon:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="employeePhone" name="employeePhone"
                                       placeholder="Çalışanın Telefonu örn 534xxxyyzz">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>Mail:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="text" class="form-control" id="employeeMail" name="employeeMail"
                                       placeholder="Çalışanın Maili">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <label>Adres:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                            <textarea cols="50" rows="4" class="form-control" id="employeeAddress"
                                      name="employeeAddress"
                                      placeholder="Çalışanın Adresi">
                            </textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group text-right">
                        <button value="submit" type="submit" id="submit_btn" class="btn submit_btn">Kaydet
                        </button>
                        <button id="clear_btn" type="button" class="btn submit_btn">Temizle</button>
                    </div>
                </div>
            </div>
        </form>
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table id="employees" class="table display table-striped table-bordered" style="width:100%">
                        <thead>
                        <tr>
                            <th>Tc No</th>
                            <th>Adı</th>
                            <th>Soyadı</th>
                            <th>Tipi</th>
                            <th>Doğum Tarihi</th>
                            <th>Pasaport No</th>
                            <th>Telefon</th>
                            <th>Mail</th>
                            <th>Adres</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${employees}" var="item">
                            <tr>
                                <td>${item.employeeId}</td>
                                <td>${item.employeeName}</td>
                                <td>${item.employeeSurname}</td>
                                <td>${employeeSelectList[item.employeeType]}</td>
                                <td>${item.employeeBirthDay}</td>
                                <td>${item.employeePassportId}</td>
                                <td>${item.employeePhone}</td>
                                <td>${item.employeeMail}</td>
                                <td>${item.employeeAddress}</td>
                                <td><i id="${item.employeeId}" class="fa fa-edit fa-2x"></i></td>
                                <td><i id="${item.employeeId}" class="fa fa-remove fa-2x"></i></td>
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
<script type="text/javascript" src="/statics/js/pages/secured/employee.js"></script>
</body>
</html>


