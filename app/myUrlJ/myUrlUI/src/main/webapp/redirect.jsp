<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		 <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"> 
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" type="image/png" href="images/favicon.png">
		<title>MicroUrl. Make your links shorter!</title>
	</head>
	<body>
	<h1>Redirecting...</h1>
	<%
	   // New location to be redirected
	   System.out.println(request.getPathInfo());
	   String site = new String("http://www.in.gr");
	   response.setStatus(response.SC_MOVED_TEMPORARILY);
	   response.setHeader("Location", site); 
	%>
	</body>
</html>