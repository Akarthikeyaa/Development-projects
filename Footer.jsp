<!DOCTYPE html>
<html>
<script>
const alphabets_regx = new RegExp("^[a-zA-Z ]*$");
const number_comma_regx = new RegExp("^[0-9,]*$");
const number_regx = new RegExp("^[0-9]*$");
const pin_regx = new RegExp("^[0-9]{1,6}$");
const email_regx = new RegExp("/^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/");
function validateAddItemForm() {
	const form = document.querySelector("#add-form");
	const p = document.querySelector("#error-para");
	const name = form["item_name"].value;
	const price = form["item_price"].value;
	const category = form["item_category"].value;
	const image = form["item_img"].value;
	const qty = form["stock"].value;
	console.log(form);
	console.log(p);
	console.log(name);
	console.log(price);
	console.log(category);
	console.log(image);
	console.log(qty);
	let err = "* ";
	if (name == "" && price == "" && category == "" && image == "" && qty == "") {
		err = "Enter All Fields";
	}
	else if (name == "" && !price == "" && !category == "" && !image == "" && !qty == "") {
		err = "Enter Item name";
	}
	else if (!name == "" && price == "" && !category == "" && !image == "" && !qty == "") {
		err = "Enter Item price";
	}
	else if (!name == "" && !price == "" && category == "" && !image == "" && !qty == "") {
		err = "choose category";
	}
	else if (!name == "" && !price == "" && !category == "" && image == "" && !qty == "") {
		err = "Enter Item image url";
	}
	else if (!name == "" && !price == "" && !category == "" && !image == "" && qty == "") {
		err = "Enter Item Stock";
	}else if (name == "" || price == "" || category == "" || image == "" || qty == "") {
		err = "Enter All Fields";
	} 
	else if (!alphabets_regx.test(name)) {
		err = "Enter Valid Name";
	} else if (!number_regx.test(price)) {
		err = "Enter Valid Price";
	} else if (!number_regx.test(qty)) {
		err = "Enter Valid Quantity";
	}
	if (err == "* ") {
		return true
	}
	p.innerText = err;
	return false;
}
function validateCustomerRegister()
{
	const form = document.querySelector("#customer-register-form");
	const p = document.querySelector("#error-para");
	const name = form["name"].value;
	const email = form["email"].value;
	const pass = form["password"].value;
	const mobile = form["mobile"].value;
	const address = form["address"].value;
	const pin = form["pin"].value;
	console.log(form);
	console.log(p);
	console.log(name);
	console.log(email);
	console.log(pass);
	console.log(mobile);
	console.log(address);
	console.log(pin);
	let err = "* ";
	if (name == "" && email == "" && pass == "" && mobile == "" && address == "" && pin=="") {
		err = "Enter All Fields";
	} 
	else if (name == "" && !email == "" && !pass == "" && !mobile == "" && !address == "" && !pin=="") {
		err = "Enter Name";
	}
	else if (!name == "" && email == "" && !pass == "" && !mobile == "" && !address == "" && !pin=="") {
		err = "Enter Email";
	}
	else if (!name == "" && !email == "" && pass == "" && !mobile == "" && !address == "" && !pin=="") {
		err = "Enter Password";
	}
	else if (!name == "" && !email == "" && !pass == "" && mobile == "" && !address == "" && !pin=="") {
		err = "Enter Mobile Number";
	}
	else if (!name == "" && !email == "" && !pass == "" && !mobile == "" && address == "" && !pin=="") {
		err = "Enter Address";
	}
	else if (!name == "" && !email == "" && !pass == "" && !mobile == "" && !address == "" && pin=="") {
		err = "Enter Area pin";
	}
	else if (name == "" || email == "" || pass == "" || mobile == "" || address == "" || pin=="") {
		err = "Enter All Fields";
	} 
	else if (!alphabets_regx.test(name)) {
		err = "Enter Valid Name";
	} 
	else if(!number_regx.test(mobile))
	{
		err ="Enter Valid Mobile number";
	}
	else if(!number_regx.text(pin))
	{
		err ="Enter Valid Area pin with max of 6 digits";
	}
	else if(!email_regx.text(email))
	{
		err="Enter Valid Email"
	}
	if (err == "* ") {
		return true
	}
	p.innerText = err;
	return false;
}
function validateShopkeeperRegister()
{
	const form = document.querySelector("#shopkeeper-register-form");
	const p = document.querySelector("#error-para");
	const name = form["name"].value;
	const email = form["email"].value;
	const pass = form["password"].value;
	const mobile = form["mobile"].value;
	const address = form["address"].value;
	const pin = form["pin"].value;
	console.log(form);
	console.log(p);
	console.log(name);
	console.log(email);
	console.log(pass);
	console.log(mobile);
	console.log(address);
	console.log(pin);
	let err = "* ";
	if (name == "" && email == "" && pass == "" && mobile == "" && address == "" && pin=="") {
		err = "Enter All Fields";
	} 
	else if (name == "" && !email == "" && !pass == "" && !mobile == "" && !address == "" && !pin=="") {
		err = "Enter Name";
	}
	else if (!name == "" && email == "" && !pass == "" && !mobile == "" && !address == "" && !pin=="") {
		err = "Enter Email";
	}
	else if (!name == "" && !email == "" && pass == "" && !mobile == "" && !address == "" && !pin=="") {
		err = "Enter Password";
	}
	else if (!name == "" && !email == "" && !pass == "" && mobile == "" && !address == "" && !pin=="") {
		err = "Enter Mobile Number";
	}
	else if (!name == "" && !email == "" && !pass == "" && !mobile == "" && address == "" && !pin=="") {
		err = "Enter Address";
	}
	else if (!name == "" && !email == "" && !pass == "" && !mobile == "" && !address == "" && pin=="") {
		err = "Enter Area pin";
	}
	else if (name == "" || email == "" || pass == "" || mobile == "" || address == "" || pin=="") {
		err = "Enter All Fields";
	} 
	else if (!alphabets_regx.test(name)) {
		err = "Enter Valid Name";
	} 
	else if(!number_regx.test(mobile))
	{
		err ="Enter Valid Mobile number";
	}
	else if(!number_regx.text(pin))
	{
		err ="Enter Valid Area pin with max of 6 digits";
	}
	else if(!email_regx.text(email))
	{
		err="Enter Valid Email"
	}
	if (err == "* ") {
		return true
	}
	p.innerText = err;
	return false;
}
function validateCustomerLogin()
{
	const form = document.querySelector("#customer-login-form");
	const p = document.querySelector("#error-para");
	const email = form["email"].value;
	const pass = form["password"].value;
	console.log(form);
	console.log(p);
	console.log(email);
	console.log(pass);
	let err = "* ";
	if (email == "" && pass == "") {
		err = "Enter All Fields";
	}  
	else if(email == "")
	{
		err = "Enter Email address";
	}
	else if(pass == "")
	{
		err = "Enter Password"
	}
	else if(!email_regx.text(email))
	{
		err="Enter Valid Email"
	}
	if (err == "* ") {
		return true
	}
	p.innerText = err;
	return false;
	
}
function validateShopkeeperLogin()
{
	const form = document.querySelector("#shopkeeper-login-form");
	const p = document.querySelector("#error-para");
	const email = form["email"].value;
	const pass = form["password"].value;
	console.log(form);
	console.log(p);
	console.log(email);
	console.log(pass);
	let err = "* ";
	if (email == "" && pass == "") {
		err = "Enter All Fields";
	}  
	else if(email == "")
	{
		err = "Enter Email address";
	}
	else if(pass == "")
	{
		err = "Enter Password"
	}
	else if(!email_regx.text(email))
	{
		err="Enter Valid Email"
	}
	if (err == "* ") {
		return true
	}
	p.innerText = err;
	return false;
	
}

</script>
</html>