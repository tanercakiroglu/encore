<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<html>
<head>

    <title>Home</title>
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
        <div class="row">

            <div class="col-lg-8">
                <form id="proposalForm">

                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <input type="text" class="form-control" id="propName" name="propName"
                                       placeholder="Enter proposal name">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="proposedBy" name="proposedBy"
                                       placeholder="Enter proposed by">
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group input-group">
                                <input type="text" class="form-control" id="startDate" name="startDate" autocomplete="off" placeholder="Enter start date"/>
                                <div class="input-group-append">
						        <button type="button" class="btn btn-default" data-toggle="datepicker"
                                        data-target-name="startDate"><span
                                        class="fa fa-calendar"></span>
                                </button>
                                </div>
                            </div>

                            <div class="form-group input-group">
                                <input type="text" class="form-control" id="endDate" name="endDate" autocomplete="off" placeholder="Enter end date"/>
                                <div class="input-group-append">
                                    <button type="button" class="btn btn-default" data-toggle="datepicker"
                                            data-target-name="endDate"><span
                                            class="fa fa-calendar"></span>
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group text-right">
                                <button value="submit" type="submit" id="submit_btn" class="btn submit_btn">Save
                                </button>
                            </div>
                        </div>


                    </div>




                </form>

            </div>

        </div>
    </div>
</section>

<jsp:include page="../_footer.jsp"></jsp:include>
<script src="/statics/js/pages/secured/home.js" type="text/javascript"></script>
</body>
</html>