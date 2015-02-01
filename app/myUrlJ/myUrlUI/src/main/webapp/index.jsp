<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="js/script.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
Url:<input name="url">
<button type="submit" onclick="getUrl()">Submit Value</button>

 <script type="text/javascript">
 //var data = JSON.stringify({url :'http://www.w3schools.com/jsref/event_onclick.asp'});
 function  getUrl() {
	 jQuery.ajax({
         cache: true,
       //  data: data ,
         dataType: 'json',
         contentType: 'application/json',
         type: 'get',
         url: '/myUrlRest/api/url/getUrl/',
         success: function ( text_status, xhr) {
             // jQuery treats 0 as success, but this is what some browsers return when the XHR failed due to a 
             // network error
             if (xhr.status === 0) {
                 alert('Error');
             } else {
                // success(data);
             }
         },
         error: function () {
           
         }
     });
 };
 </script>
</body>
</html>