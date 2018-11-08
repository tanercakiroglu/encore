$(document).ready(function(){


   // validate contactForm form
    $(function() {
        $('#loginForm').validate({
            rules: {
            	password: {
                    required: true,
                    minlength: 6
                },
               
                email: {
                    required: true,
                    email: true
                }
            },
            messages: {
            	password: {
                    required: "come on, you have a name, don't you?",
                    minlength: "your name must consist of at least 2 characters"
                },
                email: {
                    required: "no email, no message"
                }
            },
            submitHandler: function(form) {
                $(form).ajaxSubmit({
                    type:"POST",
                    data: $(form).serialize(),
                    url:"/app/loginSubmit",
                    success: function() {
                        $('#loginForm :input').attr('disabled', 'disabled');
                        $('#loginForm').fadeTo( "slow", 1, function() {
                            $(this).find(':input').attr('disabled', 'disabled');
                            $(this).find('label').css('cursor','default');
                            $('#success').fadeIn()
                            $('.modal').modal('hide');
		                	$('#success').modal('show');
                        })
                    },
                    error: function() {
                        $('#loginForm').fadeTo( "slow", 1, function() {
                            $('#error').fadeIn()
                            $('.modal').modal('hide');
		                	$('#error').modal('show');
                        })
                    }
                })
            }
        })
    })
    
})