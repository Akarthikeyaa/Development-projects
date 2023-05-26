<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style>
	.form-error
	{
	  color:red;
	  font-size:30px;
	  
	}
	
	</style>
<h1 class="form-error" align="center"><%=request.getAttribute("error")%></h1>
<%@ include file="Footer.jsp"%>