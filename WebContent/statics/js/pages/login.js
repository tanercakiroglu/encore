$(document).ready(function(){


    // validate contactForm form
    $(function() {
        $('#loginForm').validate({
            rules: {
                password: {
                    required: true

                },

                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
                password: {
                    required: "password is required"
                },
                email: {
                    required: "email is required"
                }
            },
            errorPlacement: function(error, element)
            {
                element.attr('title', error.text());
                $(".error").tooltip(
                    {
                        position:
                            {
                                my: "left+5 ",
                                at: "right "
                            },
                        tooltipClass: "ttError"
                    });
            }

        });
    })
    
})