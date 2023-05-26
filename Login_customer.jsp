<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html lang="en-us">
    <head>
        <meta charset="UTF-8">
        <title>Customer Login</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
    </head>
    <style>
    *{box-sizing: border-box;
   
}
body
{
font-family: 'Ubuntu', sans-serif;	
}

input[type=email],input[type=password]
{
    width: 45%;
    padding: 12px;
    border: 1px solid rgb(168, 166, 166);
    border-radius: 4px;
    resize: vertical;
   
}
h1{
   
    font-size: 40px;
    font-style: normal;
    font-weight: bold;
    text-align: center;
    color: 	blue;
    margin:16px;
  
}
label{
    padding: 12px 12px 12px 0;
    display: inline-block;
    color:#800000;
    font-size:25px;
    font-weight:bold;
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
.container{
    border-radius: 5px;
  	margin-right:550px;
  	margin-top:50px;
    padding: 20px;
     font-family: 'Ubuntu', sans-serif;	
     border-color:#808000;
   
}
.email{
    float: left;
    width:10%;
    margin-top: 6px;
}
.email-1{
    float: left;
    width: 90%;
    margin-top: 10px;
}
.row:after{
    content: "";
    display: table;
    clear: both;
}
.row
{
margin:10px 0;
padding : 10px 0;
}
.newuser
{
    margin-top: 10px;
margin-left: 100px;
font-size:40px;
color:#00FFFF;
}
.form-error
{
  font-size : 18px;
  color : red;
}
.bg{
background-image:url("https://static.vecteezy.com/system/resources/thumbnails/007/979/122/small/men-typing-on-keyboard-to-sign-in-computer-network-laptop-screen-showing-login-for-security-system-concept-work-at-home-with-computers-and-internet-notebook-computer-on-white-table-blur-background-photo.jpg");
height:100vh;
background-size:cover;
}

    </style>
    
       
    <body>
    <div class="bg">
    <br>
        <h1>Buyer Login</h1>
        
        <div class="container">
            <form method="get" action="Use_Login_customer" id="customer-login-form" onsubmit="return validateCustomerLogin()">
            <div class="row">
                <div class="email">
                    <label for="email">Email:</label>
                </div>
                <div class="email-1">
                    <input type="email" id="email" name="email">
                </div>
            </div>
             <div class="row">
                <div class="email">
                    <label for="password">Password:</label>
                </div>
                <div class="email-1">
                    <input type="password" id="password" name="password" maxlength="8">
                </div>
            </div>
             <div class="row">
               <p class="form-error" id="error-para"></p>
                <input type="submit" value="Login" onclick="">
            </div>  
            </form>
            
            
        </div>  
    </body>
</html>
<%@ include file="Footer.jsp"%>



