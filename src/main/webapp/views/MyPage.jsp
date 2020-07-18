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

 <h2>This is My jsp Page</h2>
 
   
   <s:form action="${pageContext.request.contextPath}/testcontrol/viewmypage" method="post" modelAttribute="userdetails">
   
       Id   :  <s:input path="id"/>  <br>
       
       
       Name  : <s:password path="name"/> <br>
   
      
        <button type="submit">Submit</button>
   
   </s:form>

</body>
</html>