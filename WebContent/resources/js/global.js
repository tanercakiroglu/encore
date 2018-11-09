$(document).ready(function() {
	
function getToken() {
	   return window.localStorage.getItem('token');
}	

$.ajaxSetup({
    beforeSend: function(xhr, settings) {
        xhr.setRequestHeader("bearer", " " +getToken());
        xhr.setRequestHeader("faces-request", "partial/ajax");
     }
   });

})