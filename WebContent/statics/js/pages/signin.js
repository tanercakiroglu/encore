/**
 * 
 */

$(document).ready(function() {
	
	$("#btnSbmt").click(function() {
		var email =$("#email").val();

		$.ajax({
			url : "signin",
			type : "POST",
			contentType : "application/json",
			data:email,
			dataType : 'json',
			supressError: true,
			success : function(result) {
			
			},
			error: function(result) {
				alert("Bir hata oluştu");
			}
		
		})
	})
})