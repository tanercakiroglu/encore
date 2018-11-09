$(document).ready(function() {
	
function getToken() {
	   return window.localStorage.getItem('token');
}	

$.ajaxSetup({
    beforeSend: function(xhr, settings) {
        xhr.setRequestHeader("Authorization", " " +getToken());
        xhr.setRequestHeader("faces-request", "partial/ajax");
     }
   });

})