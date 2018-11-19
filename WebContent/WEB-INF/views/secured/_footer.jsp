<%--
  Created by IntelliJ IDEA.
  User: taner.cakiroglu
  Date: 14.11.2018
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- Modals success -->

<div id="success" class="modal modal-message fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="fa fa-close"></i>
                </button>
                <h2>Thank you</h2>
                <p>Your message is successfully sent...</p>
            </div>
        </div>
    </div>
</div>

<!-- Modals error -->

<div id="error" class="modal modal-message fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <i class="fa fa-close"></i>
                </button>
                <h2>Sorry !</h2>
                <p> Something went wrong </p>
            </div>
        </div>
    </div>
</div>

<div class="loader"><!-- Place at bottom of page --></div>
<script src="/statics/js/jquery-3.3.1.js" type="text/javascript"></script>
<script type="text/javascript" src="/statics/js/data-table.js"></script>
<script src="/statics/js/popper.js" type="text/javascript"></script>
<script src="/statics/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/statics/js/stellar.js" type="text/javascript"></script>
<script src="/statics/vendors/lightbox/simpleLightbox.min.js" type="text/javascript"></script>
<script src="/statics/vendors/isotope/imagesloaded.pkgd.min.js" type="text/javascript"></script>
<script src="/statics/vendors/isotope/isotope-min.js" type="text/javascript"></script>
<script src="/statics/vendors/owl-carousel/owl.carousel.min.js" type="text/javascript"></script>
<script src="/statics/js/jquery.ajaxchimp.min.js" type="text/javascript"></script>
<script src="/statics/vendors/counter-up/jquery.waypoints.min.js" type="text/javascript"></script>
<script src="/statics/vendors/counter-up/jquery.counterup.js" type="text/javascript"></script>
<script src="/statics/js/mail-script.js" type="text/javascript"></script>
<script src="/statics/vendors/popup/jquery.magnific-popup.min.js" type="text/javascript"></script>
<script src="/statics/js/theme.js" type="text/javascript"></script>
<script src="/statics/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/statics/js/global.js" type="text/javascript"></script>
<script src="/statics/js/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="/statics/js/bootstrap-datepicker.tr.js" type="text/javascript"></script>
<script src="/statics/js/jquery.form.js" type="text/javascript"></script>
<script src="/statics/js/popper.js" type="text/javascript"></script>
<script src="/statics/js/datatable-bootstrap.js" type="text/javascript"></script>
<script src="/statics/js/datatable-responsive.js" type="text/javascript"></script>
<script src="/statics/js/datatable-responsive-bootstrap.js" type="text/javascript"></script>
<script src="/statics/js/datatable-fixedheader.js" type="text/javascript"></script>
<script>var ctx = "<%=request.getContextPath()%>"</script>
</body>
</html>
