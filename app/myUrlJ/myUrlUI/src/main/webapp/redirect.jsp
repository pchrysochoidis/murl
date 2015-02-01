<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		 <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"> 
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" type="image/png" href="../images/favicon.png">
		<title>MicroUrl. Make your links shorter!</title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
		<script type="text/javascript"	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/redirect.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">μUrl</a>
				</div>
			</div>
		</nav>
		<div class="container-fluid">
		  <div class="row">
		    <div class="jumbotron">
			  <h1>Redirecting to your link...</h1>
			  <p>In a few seconds you will be redirected to your link! If it fails please <button id="tryagainBtn" class="btn btn-link btn-lg" type="button">try again...</button></p>
			  <p id="messagescontainer"></p>
			</div>
		  </div>
		</div>
		<script type="text/javascript">
			var url_token = "<%= request.getPathInfo().replace("/", "") %>";
		</script>
	</body>
</html>