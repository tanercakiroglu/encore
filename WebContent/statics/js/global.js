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
            format: "dd-mm-yyyy",
            language: 'tr',
            autoclose: true,
            useCurrent: true,
            ignoreReadonly: true,
            locale: "tr-TR",
        }).datepicker('option', 'format', 'dd-mm-yyyy');
        $(this).on("click", function () {
            t.datepicker("show");
        });
    });

    $.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg === value;
    }, "bu alan zorunludur");


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



});

function  convertFromTimeStampToDate(date){
    if (date != null && date != undefined) {
        var dateObj = date.split('-');
        return new Date(dateObj[0], dateObj[1], dateObj[2]);
    }
}