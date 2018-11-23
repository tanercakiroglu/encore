var webContextPath = "/app";
$(document).ready(function () {


    $body = $("body");
   /* $.validator.setDefaults({ignore: []});*/
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

    $.validator.addMethod("valueEquals", function (value, element, arg) {
        return arg !== value;
    }, "bu alan zorunludur");


    jQuery.validator.addMethod("decimalFormat",
        function (value, element, params) {
            var decimal=  /^[-+]?[0-9]+\.[0-9]{2}$/s;
            return (value.match(decimal));
        },('Tutar girişleri 1221.23 formatında olmalıdır. '));


    jQuery.validator.addMethod("greaterThan",
        function (value, element, params) {

            if (!/Invalid|NaN/.test(new Date(value))) {
                return new Date(value) > new Date($(params).val());
            }

            return isNaN(value) && isNaN($(params).val())
                || (Number(value) > Number($(params).val()));
        }, ('Must be greater than start date.'));

    $(document).on({
        ajaxStart: function () {
            $body.addClass("loading");
        },
        ajaxStop: function () {
            $body.removeClass("loading");
        }
    });

    $(document).on('click', '.fa-remove', function () {
        openDeleteConfirmModal(this.id)
    });

    $(document).ajaxSuccess(function (event, request, settings) {
        if (request.responseJSON != null && request.responseJSON.status == "expired") {
            openModal("Oturum süreniz dolmuştur.Anasayfaya yönlendirileceksiniz");
            setTimeout(function () {
                window.location.href = webContextPath + request.responseJSON.message;
            }, 3000);
        }
    });
});

function convertFromTimeStampToDate(date) {
    var exprDate = new RegExp(/([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/);
    dateStr = new String(date);
    if (date != null && date != undefined) {
        if (dateStr.match(exprDate)) {
            var dateObj = dateStr.split('-');
            return new Date(dateObj[0], parseInt(dateObj[1]) - 1, dateObj[2]);
        } else {
            return (new Date(date));
        }
    }
}

function openModal(content) {
    $('.modal-body').empty();
    $('.modal-body').append(content);
    $('#myModal').modal('show');
}

function openDeleteConfirmModal(id) {
    $('.modal-body').empty();
    $('.modal-body').append("Kaydı silmek istediğinizden emin misiniz?");
    $("#confirmDelete").attr("data-id", id);
    $('#confirm-delete').modal('show');
}

function closeDeleteConfirmModal() {
    $('#confirm-delete').modal('hide');
}

function  openDocument(body,name) {
    var blob = new Blob([_base64ToArrayBuffer([body])]);
    var link = document.createElement('a');
    // Browsers that support HTML5 download attribute
    if (link.download !== undefined) {
        url = URL.createObjectURL(blob);
        var fileName =name;
        link.setAttribute('href', url);
        link.setAttribute('download', fileName);
        link.style.visibility = 'hidden';
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    }

}

function _base64ToArrayBuffer(base64) {
    var binary_string = window.atob(base64);
    var len = binary_string.length;
    var bytes = new Uint8Array(len);
    for (var i = 0; i < len; i++) {
        bytes[i] = binary_string.charCodeAt(i);
    }
    return bytes.buffer;
}