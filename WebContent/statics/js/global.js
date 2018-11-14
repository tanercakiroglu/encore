$(document).ready(function () {

    $body = $("body");
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
            startDate: new Date(new Date().setDate(new Date().getDate() - 1))
        });
        $(this).on("click", function () {
            t.datepicker("show");
        });
    });

    jQuery.validator.addMethod("greaterThan",
        function(value, element, params) {

            if (!/Invalid|NaN/.test(new Date(value))) {
                return new Date(value) > new Date($(params).val());
            }

            return isNaN(value) && isNaN($(params).val())
                || (Number(value) > Number($(params).val()));
        },('Must be greater than start date.'));

    $(document).on({
        ajaxStart: function() { $body.addClass("loading");    },
        ajaxStop:  function() { $body.removeClass("loading"); }
    });
})