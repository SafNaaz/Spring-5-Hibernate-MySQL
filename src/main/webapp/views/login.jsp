<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Portal</title>
</head>
<body>

	<h1>Administrator Authentication</h1>
	<h4>Login Form</h4>

    
    <c:if test="${param.error != null}">
    		<p style='color:red'>
    			Invalid username and password.
    		</p>
    	</c:if>
    	  <c:if test="${param.logout != null}">
    		<p style='color:green'>
    			Logged out successfully
    		</p>
    	</c:if>
	
	<form action='<spring:url value="/loginAction"/>' method="post">
    <table>
      <tr>
        <td>Username</td>
        <td><input type="text" name="username">
      
        </td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="password">
       </td>
      </tr>
      <tr>
        <td><button type="submit">Login</button></td>
      </tr>
    </table>
  </form>
  <br/>
</body>
</html>