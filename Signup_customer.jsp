<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="UTF-8">
<title>Customer Register</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap"
	rel="stylesheet">
</head>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: 'Ubuntu', sans-serif;
}

input[type=text], input[type=email], input[type=number], input[type=password],
	input[type=tel] {
	width: 45%;
	padding: 12px;
	border: 1px solid rgb(168, 166, 166);
	border-radius: 4px;
	resize: vertical;
	margin:10px;
}

textarea {
	width: 45%;
	padding: 12px;
	border: 1px solid pink;
	border-radius: 4px;
	resize: vertical;
}

h1 {
	font-size: 40px;
	font-style: normal;
	font-weight: bold;
	text-align: center;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
	color: red;
	font-size:25px;
		
}

input[type=submit] {
	background-color: red;
    color: yellow;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float:left;
    font-size:30px;
    margin-top: 50px;
margin-left: 100px;
}

input[type=submit]:hover {
	background-color: lime;
}

.container {
	border-radius: 5px;
	margin-right: 550px;
	margin-top: 50px;
	padding: 20px;
	font-family: 'Ubuntu', sans-serif;
}

.email {
	float: left;
	width: 10%;
	margin-top: 6px;
}

.email-1 {
	float: left;
	width: 90%;
	margin-top: 10px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}


.form-error
{
  font-size : 18px;
  color : red;
}
.bg{
background-image:url("https://cdn.woorise.com/template/wp-content/uploads/sites/62/2021/02/online-registration-background.png");
height:100vh;
background-size:cover;
}

</style>

<body>
	  <div class="bg">
	<h1>SignUp as Customer </h1>
	<div class="container">
		<form method="post" action="Signup_Customer" onsubmit="return validateCustomerRegister()" id="customer-register-form">
			<div class="row">
				<div class="email">
					<label for="name"> Name:</label>
				</div>
				<div class="email-1">
					<input type="text" id="name" name="name"
						placeholder="Enter your Name">
				</div>
			</div>
			<div class="row">
				<div class="email">
					<label for="email">Email:</label>
				</div>
				<div class="email-1">
					<input type="email" id="email" name="email"
						placeholder="It should contain @,.">
				</div>
			</div>
			<div class="row">
				<div class="email">
					<label for="password">Password:</label>
				</div>
				<div class="email-1">
					<input type="password" id="password" name="password">
				</div>
			</div>
			
			<div class="row">
			<p class="form-error" id="error-para"></p>
			
				<input type="submit" value="SignUp" onsubmit = "return validateCustomerRegister()">
			</div>
		</form>
		
		</div>
		</div>
	
	

</body>
</html>
<%@ include file="Footer.jsp"%>


