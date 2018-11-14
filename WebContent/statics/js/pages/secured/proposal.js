$(document).ready(function () {
    $(document).ready(function() {
        $('#example').DataTable();
    } );

    $(function () {
        $('#proposalForm').validate({
            rules: {
                proposedBy: {
                    required: true

                },
                propName: {
                    required: true
                },
                startDate: {
                    required: true,
                    date: true
                },
                endDate: {
                    required: true,
                    date: true,
                    greaterThan: "#startDate"
                }
            },
            messages: {
                proposedBy: {
                    required: "password is required"
                },
                propName: {
                    required: "email is required"
                },
                startDate: {
                    required: "startDate is required"
                },
                endDate: {
                    required: "endDate is required"
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
});

