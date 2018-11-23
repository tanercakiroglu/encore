<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 14.11.2018
  Time: 10:24
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
            <div class="banner_content">
            </div>
        </div>
    </div>
</section>


<section id="main">

    <div class="container ">
        <form id="productForm">
            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-4">
                            <label>Ürün Numarası:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" disabled="disabled" class="form-control" id="id" name="id"
                                       placeholder="Ürün Numarası">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Ürün Adı:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="text" class="form-control" id="productName" name="productName"
                                       placeholder="Ürün Adı">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Ürün Tipi:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group input-group">
                                <select class="form-control" id="productType" name="productType">
                                    <option value="Seçiniz" selected>Seçiniz</option>
                                    <c:forEach items="${productTypeSelectList}" var="item" varStatus="status">
                                        <option value="${item.key}">${item.value}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Ürün Sorumlusu:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="text" class="form-control" id="productOwner" name="productOwner"
                                       placeholder="Ürün Sorumlusu">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-4">
                            <label>Ürün Boyu:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="productHeight" name="productHeight"
                                       placeholder="Ürün Boyu(cm örn 180)">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Ürün Eni:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="productWeight" name="productWeight"
                                       placeholder="Ürün Eni(cm örn 180)">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Ürün Yüksekliği:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="productDepth" name="productDepth"
                                       placeholder="Ürün Yüksekliği(cm örn 180)">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-4">
                            <label>Ürün Alış Fiyatı:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="productBuyPrice" name="productBuyPrice"
                                       placeholder="Ürün Alış Fiyatı">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Ürün Satış Fiyatı:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="number" class="form-control" id="productSellPrice" name="productSellPrice"
                                       placeholder="Ürün Satış Fiyatı">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Tedarikçi Firma:</label>
                        </div>
                        <div class="col-md-8">
                            <div class="form-group">
                                <input type="text" class="form-control" id="productSupplier" name="productSupplier"
                                       placeholder="Tedarikçi Firma">
                            </div>
                        </div>

                    </div>
                </div>
                <form id="file-form">
                    <div class="col-md-12">
                        <input type="file" id="file-select" name="files[]" multiple/>
                        <button type="button" class="btn submit_btn text-right" id="upload-button">Upload
                        </button>
                    </div>
                </form>
                    <div class="col-md-12 ">
                        <div class="form-group text-right ">
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
                    <table id="products" class="table display table-striped table-bordered" style="width:100%">
                        <thead>
                        <tr>
                            <th>Numarası</th>
                            <th>Adı</th>
                            <th>Tedarakçi Firma</th>
                            <th>Tipi</th>
                            <th>Boy</th>
                            <th>En</th>
                            <th>Yükseklik</th>
                            <th>Sorumlusu</th>
                            <th>Alış Fiyatı</th>
                            <th>Satış Fiyatı</th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${products}" var="item">
                            <tr>
                                <td>URN-${item.id}</td>
                                <td>${item.productName}</td>
                                <td>${item.productSupplier}</td>
                                <td>${productTypeSelectList[item.productType]}</td>
                                <td>${item.productHeight}</td>
                                <td>${item.productWeight}</td>
                                <td>${item.productDepth}</td>
                                <td>${item.productOwner}</td>
                                <td>${item.productBuyPrice}</td>
                                <td>${item.productBuyPrice}</td>
                                <td><i id="${item.id}" class="fa fa-edit fa-2x"></i></td>
                                <td><i id="${item.id}" class="fa fa-remove fa-2x"></i></td>
                                <td><i id="${item.fileId}" class="fa fa-file fa-2x"></i></td>
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
<script type="text/javascript" src="/statics/js/pages/secured/product.js"></script>
</body>
</html>