$(document).ready(function () {
    var table = $('#employees').DataTable({
        responsive: true,
        language: {
            lengthMenu: "Sayfada _MENU_ Göster",
            zeroRecords: "Kayıt Bulunmamaktadır.",
            info: "Sayfa _PAGE_ Gösterliyor.  ",
            infoEmpty: "Kayıt Bulunmamaktadır.",
            infoFiltered: "(filtered from _MAX_ total records)"
        }
    });
    /*new $.fn.dataTable.FixedHeader(table);*/

    $(function () {
        $('#employeeForm').validate({
            rules: {
                employeeId: {
                    required: true,
                    rangelength: [11, 11]
                },
                employeeName: {
                    required: true
                },
                employeeSurname: {
                    required: true
                },
                employeeType: {
                    valueEquals: "Seçiniz"
                },
                employeeBirthDay: {
                    required: true,
                    maxlength: 10
                },
                employeePhone: {
                    required: true,
                    rangelength: [10, 10]
                },
                employeeMail: {
                    required: true,
                    email: true
                },
                employeePassportId: {
                    required: true
                },
                employeeAddress: {
                    required: true
                }
            },
            messages: {
                employeeId: {
                    required: "Kimlik numarası alanı zorunludur.",
                    rangelength: "Kimlik numarası 11 haneli olmalıdır."
                },
                employeeName: {
                    required: "Çalışanını adı alanı zorunludur."
                },
                employeeSurname: {
                    required: "Çalışanını soyadı alanı zorunludur."
                },
                employeeType: {
                    valueEquals: "Çalışanın tipi alanı zoruludur.",
                },
                employeeBirthDay: {
                    required: "Çalışanını doğum günü alanı zorunludur.",
                    maxlength: "10 dan fazla olamaz"
                },
                employeePhone: {
                    rangelength: "Telefon numarası başında 0 olmadan 10 haneli olmalıdır.",
                    required: "Telefonu alanı zorunludur."
                },
                employeeMail: {
                    email: "Geçerli bir mail adresi giriniz.",
                    required: "Mail alanı zorunludur."
                },
                employeePassportId: {
                    required: "Pasaport alanı zorunludur."
                },
                employeeAddress: {
                    required: "Adress alanı zorunludur."
                }
            },
            errorPlacement: function (error, element) {

                element.attr('data-original-title', error.text());
                $(".error").tooltip(
                    {
                        tooltipClass: "ttError"
                    });
            },
            submitHandler: function (form) {
                var request = {
                    "employeeId": form.employeeId.value,
                    "employeeName": form.employeeName.value,
                    "employeeSurname": form.employeeSurname.value,
                    "employeeBirthDay": form.employeeBirthDay.value,
                    "employeeType": form.employeeType.value,
                    "employeeMail": form.employeeMail.value,
                    "employeePhone": form.employeePhone.value,
                    "employeePassportId": form.employeePassportId.value,
                    "employeeAddress": form.employeeAddress.value
                };

                $.ajax({
                    type: "POST",
                    data: JSON.stringify(request),
                    dataType: 'json',
                    url: form.baseURI + "/add",
                    contentType: "application/json; charset=utf-8",
                }).done(function (resp, status, jqXHR) {
                    if (resp != undefined && resp.status == undefined) {
                        var response = JSON.parse(resp);
                        if (response.status = "success") {
                            bindTable(response.data);
                            clearForm();
                            openModal(response.message);
                        }
                    }
                    if (resp.status == "business_error") {
                        openModal(resp.message);
                    }
                }).fail(function (resp, status, err) {
                    var response;
                    if (resp.status === 400) {
                        response = JSON.parse(resp.responseJSON);
                    } else {
                        response = JSON.parse(resp.responseText);
                    }
                    openModal(response.message);
                })
            }
        });
    })

    $(document).on('click', '.fa-edit', function () {
        var data = table.row($(this).parents('tr')).data();
        var keys = Object.keys(data);

        $("#employeeId").val(data[keys[0]]);
        $("#employeeName").val(data[keys[1]]);
        $("#employeeSurname").val(data[keys[2]]);
        if ($.isNumeric(data[keys[3]]))
            $("#employeeType").val(data[keys[3]]);
        else
            $("#employeeType option:contains(" + data[keys[3]] + ")").attr('selected', 'selected');
        $('#employeeBirthDay').datepicker("setDate", convertFromTimeStampToDate(data[keys[4]]));
        $("#employeePassportId").val(data[keys[5]]);
        $("#employeePhone").val(data[keys[6]]);
        $("#employeeMail").val(data[keys[7]]);
        $("#employeeAddress").val(data[keys[8]]);
    })

    $(document).on('click', '.confirmDelete', function () {
        closeDeleteConfirmModal();
        var id=$("#confirmDelete").attr("data-id");
        $.ajax({
            type: "POST",
            data: id,
            dataType: 'json',
            url: webContextPath + "/secured/admin/employee/remove",
            contentType: "application/json; charset=utf-8"
        }).done(function (resp, status, jqXHR) {
            if (resp != undefined && resp.status == undefined) {
                var response = JSON.parse(resp);
                if (response.status = "success") {
                    bindTable(response.data);
                    openModal(response.message);
                    clearForm();
                }
            } else if (resp.status == "business_error") {
                openModal(resp.message);
            }

        }).fail(function (resp, status, err) {
            var response;
            if (resp.status === 400) {
                response = JSON.parse(resp.responseJSON);
            } else {
                response = JSON.parse(resp.responseText);
            }
            openModal(response.message);
        })
    })



    function bindTable(data) {
        table.destroy();
        table = $('#employees').DataTable({
            responsive: true,
            searching: true,
            paging: true,
            bInfo: false,
            language: 'tr',
            lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
            data: data,
            language: {
                lengthMenu: "Sayfada _MENU_ Göster",
                zeroRecords: "Kayıt Bulunmamaktadır.",
                info: "Sayfa _PAGE_ Gösterliyor.  ",
                infoEmpty: "Kayıt Bulunmamaktadır.",
                infoFiltered: "(filtered from _MAX_ total records)"
            },
            aoColumns: [
                {'mData': "employeeId"},
                {'mData': "employeeName"},
                {'mData': "employeeSurname"},
                {
                    'mRender': function (data, type, row) {
                        return $("#employeeType option[value=" + (row.employeeType) + "]").text();
                    }
                },
                {
                    'mRender': function (data, type, row) {
                        return jQuery.format.date(new Date(row.employeeBirthDay), 'dd-MM-yyyy');
                    }
                },
                {'mData': "employeePassportId"},
                {'mData': "employeePhone"},
                {'mData': "employeeMail"},
                {'mData': "employeeAddress"},
                {
                    'mRender': function (data, type, row) {
                        return '<i id="' + row.employeeId + '"class="fa fa-edit fa-2x"></i>';
                    }
                },
                {
                    'mRender': function (data, type, row) {
                        return '<i id="' + row.employeeId + '"class="fa fa-remove fa-2x"></i>';
                    }
                }
            ]
        });
    }

    $(document).on('click', '#clear_btn', function () {
        clearForm();
    })

    function clearForm() {
        $(':input', '#employeeForm')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .prop('checked', false);

        $("#employeeType").val($("#employeeType option:first").val());
    }
})