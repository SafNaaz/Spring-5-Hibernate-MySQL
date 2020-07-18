<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h1>Customer Page</h1>
   
   <s:form action="${pageContext.request.contextPath}/mycontrol/submitdata" method="post" modelAttribute="userdetails">
   
       Username  :  <s:input path="username"/>  <br>
       
       
       Password  : <s:password path="password"/> <br>
   
      
        <button type="submit">Submit</button>
   
   </s:form>
   
   
</body>
</html>