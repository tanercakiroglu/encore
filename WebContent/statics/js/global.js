$(document).ready(function () {

    $.ajaxSetup({
        beforeSend: function (xhr, settings) {
           xhr.setRequestHeader("faces-request", "partial/ajax");
        }
    });

    $('[data-toggle=datepicker]').each(function () {
        var target = $(this).data('target-name');
        var t = $('input[name=' + target + ']');
        t.datepicker({
            dateFormat: 'yy-mm-dd',
            autoclose: true,
            useCurrent: true,
            ignoreReadonly: true,
            startDate: new Date()
        });
        $(this).on("click", function () {
            t.datepicker("show");
        });
    });
})