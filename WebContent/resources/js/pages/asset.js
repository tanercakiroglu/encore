



$(document).ready(function() {
	


	var plate= $("#plate");
	var nick_name= $("#nick_name");
	var model= $("#model");
	var model_year= $("#model_year");
	var color= $("#color");
	var tov= $("#tov");
	var active= $("#active");
	var brand= $("#brand");
	var sad=$(".close");


	
	   $('#vehicle_table').dataTable({
		   	 sorting :false,
			 searching: false, 
			 paging: false,
			 bInfo: false,
			 language: {
			      emptyTable: " "
			    }
	   })

$(document).on('click','.close',function(){
	
	$.ajax({
		url : "removeAsset",
		type : "POST",
		contentType : "application/json",
		data : this.id,
		dataType : 'json',
		supressError: true,
		success : function(result) {
		
			if(result!= undefined && result.tag=="SUCCESSFUL OPERATION"){
				var data =result.returnDataObject;
				var table = $('#vehicle_table').DataTable();
				table.destroy();
				$('#vehicle_table').dataTable({
					 searching: false, 
					 paging: true,
					 bInfo: false,
					 language: {
					      emptyTable: " "
					    },
					 data: data,
					 aoColumns: [
						 					{ 'mData': "plateNumber" },
					        	            { 'mData': "nickName" },
					        	            { 'mData': "brand" },
					        	            { 'mData': "model" },
					        	            { 'mData': "modelYear" },
					        	            { 'mData': "color" },
					        	            { 'mData': "typeOfVehicle" },
					        	            { 'mData': "active" },
					        	            { 'mRender': function ( data, type, row ) {
					                        return '<button type="button" class="close" id="'+row.plateNumber+'" aria-label="Close">	<span aria-hidden="true">&times;</span> 				</button>';
					                        	}
					        	            }
					        	        ]
				 });
			}else{
				alert("Bir hata oluştu");
			}
			
		},
		error: function(result) {
			alert("Bir hata oluştu");
		}
	
	})
});


$("#btnSbmt").click(function(){
	
	if(validate()){
	 var vehicle= {};
	
	
	vehicle["plateNumber"]=plate.val();
	vehicle["nickName"]=nick_name.val();
	vehicle["brand"]=brand.val();
	vehicle["model"]=model.val();
	vehicle["modelYear"]=model_year.val();
	vehicle["color"]=color.val();
	vehicle["active"]=active.prop("checked");
	vehicle["typeOfVehicle"]=tov.val();
	
	$.ajax({
		url : "saveAsset",
		type : "POST",
		contentType : "application/json",
		data : JSON.stringify(vehicle),
		dataType : 'json',
		supressError: true,
		success : function(result) {
		
			if(result!= undefined && result.tag=="SUCCESSFUL OPERATION"){
				var data =result.returnDataObject;
				var table = $('#vehicle_table').DataTable();
				table.destroy();
				$('#vehicle_table').dataTable({
					 searching: false, 
					 paging: true,
					 bInfo: false,
					 language: {
					      emptyTable: " "
					    },
					 data: data,
					 aoColumns: [
						 					{ 'mData': "plateNumber" },
					        	            { 'mData': "nickName" },
					        	            { 'mData': "brand" },
					        	            { 'mData': "model" },
					        	            { 'mData': "modelYear" },
					        	            { 'mData': "color" },
					        	            { 'mData': "typeOfVehicle" },
					        	            { 'mData': "active" },
					        	            { 'mRender': function ( data, type, row ) {
					                        return '<button type="button" class="close" id="'+row.plateNumber+'" aria-label="Close">	<span aria-hidden="true">&times;</span> 				</button>';
					                        	}
					        	            }
					        	        ]
				 });
			}
			else{
				alert("Bir hata oluştu");
			}
			
		},
		error: function(result) {
			alert("Bir hata oluştu");
		}
	
	})
	}else{
		
	}
	
})

function validate() {
			
			var response = $("#g-recaptcha-response").val();
			$.ajax({
			  type: "POST",
			  url: "checkCaptcha",
				contentType : "application/json",
				data : response,
				dataType : 'json',
			  success: function(resp) {
					if(resp == "OK") {
						document.getElementById("message").innerHTML = "Perfect!";
						return true;
					}
					else {
						document.getElementById("message").innerHTML = "Incorrect Recaptcha! Please try again!";
						reloadRecaptcha();
					}
			  }
			});
			return false;
		}



});

