<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

      <H2>User Details</H2>
      
      <table>
           <tr>
              <td>UserName</td>
              <td>${userdetails.username }</td>
           </tr>
           <tr>
              <td>Password</td>
              <td>${userdetails.password }</td>
           </tr>
      
      </table>

</body>
</html>