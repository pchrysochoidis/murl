$(document).ready(function(){
	if(typeof url_token != "undefined" && url_token.length >0){
		$.ajax({
			url: '/myUrlRest/api/url/getToken/',
			type: 'post',
			data: JSON.stringify({
                token: url_token
            }),
            dataType: 'json',
            contentType: 'application/json',
            success: function(jsonRes){
            	console.log(jsonRes);
            }
		});
	}else{
		showError(ERROR.INVALID_TOKEN);
	}
	
	$("#tryagainBtn").click(function(){
		location.reload();
	});
	
	function showError(error){
		var message = "";
		switch (error) {
		case ERROR.INVALID_TOKEN:
			message = "It seems that μUrl link is invalid."
			break;

		default:
			break;
		}
		$("#messagescontainer").html(
							'<div role="alert" class="alert alert-danger alert-dismissible fade in">' +
						      '<button aria-label="Close" data-dismiss="alert" class="close" type="button"><span aria-hidden="true">×</span></button>' +
						      '<strong>Redirect error. </strong> ' + message +
						    '</div>'
						);
	}
});

var ERROR = {};
ERROR.INVALID_TOKEN = 0;