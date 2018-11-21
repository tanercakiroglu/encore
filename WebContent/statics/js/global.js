var webContextPath = "/app";
$(document).ready(function () {


    $body = $("body");
    $.validator.setDefaults({ ignore: [] });
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

    $.validator.addMethod("valueEquals", function(value, element, arg){
        return arg !== value;
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

    $(document).ajaxSuccess(function( event, request, settings ) {
        if(request.responseJSON!= null && request.responseJSON.status=="expired"){
            setTimeout(function(){
                openModal("İşlem Süreniz Dolmuştur.");
                window.location.href=webContextPath+request.responseJSON.message;
            }, 3000);

        }
    });



});

function  convertFromTimeStampToDate(date){
    var exprDate = new RegExp(/([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/);
    dateStr = new String(date);
    if (date != null && date != undefined) {
      if(dateStr.match(exprDate)){
           var dateObj = dateStr.split('-');
           return new Date(dateObj[0],parseInt(dateObj[1])-1, dateObj[2]);
       }else {
          return (new Date(date));
      }
    }
}

function  openModal(content){
    $('.modal-body').empty();
    $('.modal-body').append(content);
    $('#myModal').modal('show');
}

function  openDeleteConfirmModal(id){
    $('.modal-body').empty();
    $('.modal-body').append("Kaydı silmek istediğnizden emin misiniz?");
    $("#confirmDelete").attr("data-id",id);
    $('#confirm-delete').modal('show');
}

function  closeDeleteConfirmModal(){
    $('#confirm-delete').modal('hide');
}