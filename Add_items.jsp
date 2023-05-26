<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="UTF-8">
<title>Shopkeeper Register</title>
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
	background-color:#E9967A;
}

input[type=text], input[type=url],input[type=number],select{
	width: 45%;
	padding: 12px;
	border: 1px solid blue;
	border-radius: 0px;
	resize: vertical;
}


h1 {
	font-size: 50px;
	font-style: normal;
	font-weight: bold;
	text-align: left;
	color:Green;
	margin:15px;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
	color: blue;
	font-size:18px;
	font-weight:bold;
}

input[type=submit] {
	background-color: red;
	color: yellow;
	padding: 12px 20px;
	border: none;
	border-radius: 0px;
	font-size:29px;
	cursor: pointer;
	float: left;
	margin-top: 50px;
}

input[type=submit]:hover {
	background-color: #32a336;	
}

.container {
	border-radius: 5px;
	margin-left: 550px;
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
.form-container
{
margin-right : 600px;

}
.row
{
 margin:10px;
 padding : 10px;
}
.form-error
{
   font-size : 18px;
   color : red;
}




</style>

<body>
	<h1>Add Items</h1>
	<div class="form-container">
		<form method="post" action="Items_New" onsubmit="return validateAddItemForm()" id="add-form" class="add">
			<div class="row">
				<div class="email">
					<label for="item_name"> Name:</label>
				</div>
				<div class="email-1">
					<input type="text" id="item_name" name="item_name"
						placeholder="Enter Item Name">
				</div>
			</div>
			<div class=row>
			 <div class="email">
			  <label for="item_category">Category</label>
			  </div>
               <div class="email-1">
                <select name="item_category" id="Category">
                 <option value="vegetable">Vegetable</option>
                    <option value="fruit">Fruit</option>
                    <option value="dairy">Dairy</option>
                    <option value="cleaners">Cleaners</option>
                    <option value="snacks">Snacks</option>
                </select>
               </div>
            </div>
			<div class="row">
				<div class="email">
					<label for="item_price">Price:</label>
				</div>
				<div class="email-1">
					<input type="number" id="item_price" name="item_price">
				</div>
			</div>
			<div class="row">
				<div class="email">
					<label for="item_img">Image :</label>
				</div>
				<div class="email-1">
					<input type="url" id="item_img" name="item_img">
				</div>
			</div>
			<div class="row">
				<div class="email">
					<label for="stock">Qty :</label>
				</div>
				<div class="email-1">
					<input type="number" id="stock" name="stock">
				</div>
			</div>
			<div class="row">
			<p class="form-error" id="error-para"></p>
				<input type="submit" value="Add Item" onsubmit="return validateAddItemForm()">
			</div>
		</form>
	</div>
</body>
<%@ include file="Footer.jsp" %>
</html>