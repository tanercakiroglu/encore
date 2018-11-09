$(document).ready(function() {
	var button = $("#btn");

    var prodId = $("#prodId").val();
    localStorage.setItem('token', prodId);

    $("#btn").click(function () {
    	localStorage.removeItem('token');
    	console.log("asdasd");
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/app/secured/user/home",
            contentType: "application/json",
            dataType: 'json',
            success: function (resp) {
                console.log("sdbj");

            },
            error: function () {

            }
        });
    })

})

