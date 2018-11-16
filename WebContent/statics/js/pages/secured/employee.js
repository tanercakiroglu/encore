$(document).ready(function () {
    var table = $('#employees').DataTable({
        responsive: true
    });
    new $.fn.dataTable.FixedHeader( table );

    $(function () {
        $('#employeeForm').validate({
            rules: {
                employeeId: {
                    required: true
                },
                employeeName: {
                    required: true
                },
                employeeSurname: {
                    required: true
                },
                employeeType: {
                    required: true,
                    valueNotEquals: "-1"
                },
                employeeBirthDay: {
                    required: true,
                    date:true
                }
            },
            messages: {
                employeeId: {
                    required: "Kimlik numarası alanı zorunludur."
                },
                employeeName: {
                    required: "Çalışanını adı alanı zorunludur."
                },
                employeeSurname: {
                    required: "Çalışanını soyadı alanı zorunludur."
                },
                employeeType: {
                    required: "Çalışanını tipi alanı zorunludur."
                },
                employeeBirthDay: {
                    required: "Çalışanını doğum günü alanı zorunludur."
                }
            },
            errorPlacement: function (error, element) {
                element.attr('title', error.text());
                $(".error").tooltip(
                    {
                        tooltipClass: "ttError"
                    });
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit({
                    type: "GET",
                    data: $(form).serialize(),
                    url: "/app/login",
                    success: function () {
                        $('#loginForm :input').attr('disabled', 'disabled');
                        $('#loginForm').fadeTo("slow", 1, function () {
                            $(this).find(':input').attr('disabled', 'disabled');
                            $(this).find('label').css('cursor', 'default');
                            $('#success').fadeIn()
                            $('.modal').modal('hide');
                            $('#success').modal('show');
                        })
                    },
                    error: function () {
                        $('#loginForm').fadeTo("slow", 1, function () {
                            $('#error').fadeIn()
                            $('.modal').modal('hide');
                            $('#error').modal('show');
                        })
                    }
                })
            }
        });
    })

})