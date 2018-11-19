$(document).ready(function () {
    var table = $('#employees').DataTable({
        responsive: true
    });
    new $.fn.dataTable.FixedHeader(table);


    $(function () {
        $('#employeeForm').validate({
            rules: {
                employeeId: {
                    required: true,
                    rangelength:[11,11]
                },
                employeeName: {
                    required: true
                },
                employeeSurname: {
                    required: true
                },
                employeeType : {
                    valueEquals: "Seçiniz"
                },
                employeeBirthDay: {
                    required: true,
                    maxlength: 10
                },
                employeePhone:{
                    required:true,
                    rangelength:[9,11]
                },
                employeeMail:{
                    required:true,
                    email:true
                },
                employeePassportId:{
                    required:true
                },
                employeeAddress :{
                  required:true
                }
            },
            messages: {
                employeeId: {
                    required: "Kimlik numarası alanı zorunludur.",
                    rangelength:"Kimlik numarası 11 haneli olmalıdır."
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
                employeePhone :{
                    rangelength:"Telefon numarası başında 0 olmadan 10 haneli olmalıdır.",
                    required : "Telefonu alanı zorunludur."
                },
                employeeMail:{
                    email: "Geçerli bir mail adresi giriniz.",
                    required:"Mail alanı zorunludur."
                },
                employeePassportId:{
                    required:"Pasaport alanı zorunludur."
                },
                employeeAddress :{
                    required:"Adress alanı zorunludur."
                }
            },
            errorPlacement: function (error, element) {
                element.next().removeClass("error");
                if ( element.is( "select" ) ) {
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
                    "employeeId":form.employeeId.value,
                    "employeeName" :form.employeeName.value,
                    "employeeSurname":form.employeeSurname.value,
                    "employeeBirthDay":form.employeeBirthDay.value,
                    "employeeType":form.employeeType.value,
                    "employeeMail":form.employeeMail.value,
                    "employeePhone":form.employeePhone.value,
                    "employeePassportId":form.employeePassportId.value,
                    "employeeAddress":form.employeeAddress.value
                };

                $.ajax({
                    type: "POST",
                    data: JSON.stringify(request),
                    dataType: 'json',
                    url: form.baseURI +"/add",
                    contentType: "application/json; charset=utf-8",
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