
<%@ page import="java.io.*"%>
<%@ page import="jakarta.servlet.*"%>
<%@ page import="jakarta.servlet.http.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
<title>SunRiseMart</title>
</head>
<style>
body
{

font-family: 'Ubuntu', sans-serif;	
}
.navigation 
{
border:1px solid black;
height:70x;
display : flex;
width:100%;	
border-radius:0px;	
margin:auto;
background-color:#00FF00;
}

.navigation img
{
padding-left:2rem;
height:60px;
width : 110px;
}

.navigation ul
{
 display : flex;
 align-items:center;
 justify-content:center;
 margin-left : 157px;	
}
.navigation ul li
{
margin: 0 14px;
padding :0 19px;
list-style:none;
color : black;
font-size:30px;
font-weight:bold;

}
.navigation ul li:hover
{
cursor:pointer;
}
a
{
text-decoration:none;
}

.dropdown .dropbtn {
  font-size: 22px;
  border: none;
  outline: none;
  color: pink;
  padding: 14px 16px;
  background-color:black;
  font-family: "Roboto"; 
  margin: 0; 
}

.dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: orange;
  min-width: 160px;
}
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  
 
}

.dropdown-content a:hover {
  background-color: #ddd;
}
.dropdown:hover .dropdown-content {
  display: block;
}


</style>
<body>
<%
Cookie[] cks = null;
	Cookie ck = null;
	cks = request.getCookies();
	if (cks != null) {
		String cookieName1 = "userType";
		String cookieName2 = "username";
		boolean username = false;
		String userType = null;
		for (int i = 0; i < cks.length; i++) {
			ck  = cks[i];
			if (ck.getName().equals(cookieName1)) {
		userType = ck.getValue();
			} else if (ck.getName().equals(cookieName2)) {
		username = true;
			}
		}
		%>
<nav class=navigation>

<ul>
<li><a href="Homepage.jsp">Home</a></li>
<li class="pro"><a href="Product_ser">Shop</a></li>
<li><a href="Order_Buy">Orders</a></li>				




<li class="cart" style="margin-left: 35px;
margin-right: 13px;"><a href="Display_cart">Cart</a></li>
<li>
<%
if (userType != null && userType.equals("shopkeeper")) {
%>
	<li><a href="Add_items.jsp">Add Item</a></li>
<%
}	
%>
       <%
          if (!username && userType == null) {
       %>
       <li>
<div class="dropdown">
    <button class="dropbtn">Login
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Login_customer.jsp">Buyer</a>
      <a href="Login_shopkeeper.jsp">Shopkeeper</a>
    </div>
  </div>
</li>
<li>
<div class="dropdown">
    <button class="dropbtn">SignUp
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Signup_customer.jsp">Buyer</a>
      <a href="signup_shopkeeper.jsp">Shopkeeper</a>
    </div>
  </div>
</li>
       <%
        } 
      else {
       %>
	<li><a href="LOgOut">Logout</a></li>
<%
     }
} 
else {
	
%>
<li>
<div class="dropdown">
    <button class="dropbtn">User Login
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Login_customer.jsp">Buyer</a>
      <a href="Login_shopkeeper.jsp">Shopkeeper</a>
    </div>
  </div>
</li>

       <li>
<div class="dropdown">
    <button class="dropbtn">User Login
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="Login_customer.jsp">Buyer</a>
      <a href="Login_shopkeeper.jsp">Shopkeeper</a>
    </div>
  </div>
</li>

<%
			}
			%>	
			
	

</ul>
</nav>



</body>

</html>