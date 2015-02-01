$(document).ready(function() {
	$("#shorturl_btn").click(function() {
		var linkJQ = $("#link_input"),
			url = linkJQ.val(),
			shortBtnJQ = $(this);
		if (url.length == 0) {
			showLinkError(ERROR.URL.EMPTY, true);
			return;
		}
		if (!re_weburl.test(url)) {
			showLinkError(ERROR.URL.INVALID, true);
			return;
		}
		$.ajax({
			url:'/myUrlRest/api/url/saveUrl/', 
			type:"post",
			data: JSON.stringify({
                url: "http://www.uom.gr"
            }),
			dataType: 'json',
            contentType: 'application/json',
			beforeSend: function(){
				shortBtnJQ.button("loading");
				linkJQ.attr("disabled", "disabled");
			},
			success: function(response){
				response = $.trim(response);
				var jsonRes = $.parseJSON(response);
				if(jsonRes.s){
					linkJQ.val("");
				}
				showServerMessage(jsonRes.s, jsonRes.m, jsonRes.l);
			},
			complete: function(){
				shortBtnJQ.button("reset");
				linkJQ.removeAttr("disabled");
			}
			
		});
		
	});
	
	$("#link_input").keypress(function(){
		clearUrlErrors();
	});

	function showLinkError(error, clearOther){
		var message = null;
		switch (error) {
			case ERROR.URL.EMPTY:
				message = "Please enter your link first!";
				break;
			case ERROR.URL.INVALID:
				message = "Please enter a valid link!";
				break;
	
			default:
				message = null;
				break;
			}
		var errorContainer = $("#urlerrorcontainer");
		if(clearOther){
			clearUrlErrors();
		}
		if(null != message){
			errorContainer.append(
					'<div role="alert" class="alert alert-danger alert-dismissible fade in">' +
				      '<button aria-label="Close" data-dismiss="alert" class="close" type="button"><span aria-hidden="true">×</span></button>' +
				      '<strong>Link error. </strong> ' + message +
				    '</div>');
		}
	}
	
	function clearUrlErrors(){
		var errorContainer = $("#urlerrorcontainer");
		errorContainer.html("");
	}
	
	function showServerMessage(success, message, link){
		$("#servermessagescontainer").html(
				'<div role="alert" class="alert alert-' + (success ? "success" : "danger") + ' alert-dismissible fade in">' +
			      '<button aria-label="Close" data-dismiss="alert" class="close" type="button"><span aria-hidden="true">×</span></button>' +
			      message +
				      '<p>' +(success ? 
				    		  		'<button class="btn btn-default" id="copylinkBtn">Copy μUrl link</button>'
				      		   : '') +
		      		 '</p>' +
			    '</div>');
	}

});

var ERROR = {};
	ERROR.URL = {},
	ERROR.URL.EMPTY = 0,
	ERROR.URL.INVALID = 1;
	

var re_weburl = new RegExp(
		"^" + "(?:(?:https?|http)://)?"
		+ "(?:" + "(?!(?:10|127)(?:\\.\\d{1,3}){3})"
		+ "(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})"
		+ "(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})"
		+ "(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])"
		+ "(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}"
		+ "(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))" + "|"
		+ "(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)"
		+ "(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*"
		+ "(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))" + ")" + "(?::\\d{2,5})?"
		+ "(?:/\\S*)?" + "$", "i");