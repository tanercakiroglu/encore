$(document).ready(function () {


    $(function () {
        $('#proposalForm').validate({
            rules: {
                proposedBy: {
                    required: true

                },

                propName: {
                    required: true
                },
                startDate:{
                    required: true,
                    date:true
                },
                endDate:{
                    required: true,
                    date:true
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
            }

        });
    })


});

