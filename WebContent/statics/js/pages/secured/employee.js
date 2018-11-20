$(document).ready(function () {
    var table = $('#employees').DataTable({
        responsive: true
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
                element.next().removeClass("error");
                if (element.is("select")) {
                    element.next().addClass("error");
                }
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
                    success: function (resp) {
                        response = JSON.parse(resp);
                        var data = response.data;
                        bindTable(data);
                        clearForm();
                        openModal(response.message);
                    },
                    error: function (resp) {
                        var response;
                        if (resp.status === 400) {
                            response = JSON.parse(resp.responseJSON);
                        } else {
                            response = JSON.parse(resp.responseText);
                        }
                        openModal(response.message);
                    }
                })
            }
        });
    })

    $(document).on('click', '.fa-edit', function () {
        var data = table.row($(this).parents('tr')).data();
        $("#employeeId").val(data[0]);
        $("#employeeName").val(data[1]);
        $("#employeeSurname").val(data[2]);
        $("#employeeType").val(data[3]);
        $('#employeeBirthDay').datepicker("setDate", convertFromTimeStampToDate(data[4]));
        $("#employeePassportId").val(data[5]);
        $("#employeePhone").val(data[6]);
        $("#employeeMail").val(data[7]);
        $("#employeeAddress").val(data[8]);
    })

    $(document).on('click', '.fa-remove', function () {
        var id = this.id;

        $.ajax({
            type: "POST",
            data: id,
            dataType: 'json',
            url: webContextPath + "/secured/admin/employee/remove",
            contentType: "application/json; charset=utf-8",
            success: function (resp) {
                response = JSON.parse(resp);
                var data = response.data;
                bindTable(data);
                openModal(response.message);
            },
            error: function (resp) {
                var response;
                if (resp.status === 400) {
                    response = JSON.parse(resp.responseJSON);
                } else {
                    response = JSON.parse(resp.responseText);
                }
                openModal(response.message);
            }
        })
    });

    function bindTable(data) {
        table.destroy();
        table = $('#employees').DataTable({
            responsive: true,
            searching: true,
            paging: true,
            bInfo: false,
            language: 'tr',
            data: data,
            aoColumns: [
                {'mData': "employeeId"},
                {'mData': "employeeName"},
                {'mData': "employeeSurname"},
                {'mData': "employeeType"},
                {'mData': "employeeBirthDay"},
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

        $("select").val($("#employeeType option:first").val());
    }
})