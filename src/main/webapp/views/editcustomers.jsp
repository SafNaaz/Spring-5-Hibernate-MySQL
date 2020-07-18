<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring5 MVC Hibernate Demo</title>
        <style type="text/css">
            .error {
                color: red;
            }
            table {
                width: 50%;
                border-collapse: collapse;
                border-spacing: 0px;
            }
            table td {
                border: 1px solid #565454;
                padding: 20px;
            }
        </style>
        <spring:url value="/resources/css/Test.css" var="mainCss" />
        <link href="${mainCss}" rel="stylesheet" />
    </head>
    <body>
        <h1 class="test">Input Form</h1>
       
       <%--  <form action='<spring:url value="/logout"/>' method="post">
		   <input value="Logout" type="submit">
	   </form> --%>
           <h3 style="color:red">${message}</h3>
          <h3 style="color:green">${successmessage}</h3>
     
     
        <form:form action="addcustomer" method="post" modelAttribute="customer">
            <table>
             <tr>
                    <td>Custid</td>
                    <td>
                        <form:input path="custid" /> <br />
                        <form:errors path="custid" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <form:input path="custname" /> <br />
                        <form:errors path="custname" cssClass="error" />
                    </td>
                </tr>
                 <tr>
                    <td>Age</td>
                    <td>
                        <form:input path="age" /> <br />
                        <form:errors path="age" cssClass="error" />
                    </td>
                </tr>
                 <tr>
                    <td>Phoneno</td>
                    <td>
                        <form:input path="phoneno" /> <br />
                        <form:errors path="phoneno" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <form:input path="email" /> <br />
                        <form:errors path="email" cssClass="error" />
                    </td>
                </tr>
                 <tr>
                    <td>Address</td>
                    <td>
                        <form:input path="address" /> <br />
                        <form:errors path="address" cssClass="error" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Submit</button></td>
                </tr>
            </table>
        </form:form>
      
         
        <h2>Users List</h2> 
        <table> 
           <tr>
                <td><strong>Custid</strong></td> 
                <td><strong>Name</strong></td> 
                <td><strong>Age</strong></td> 
                <td><strong>Email</strong></td> 
                <td><strong>Phone No</strong></td> 
            </tr>
            <c:forEach items="${users}" var="user">
                <tr> 
                       <td>${user.custid}</td>
                       <td>${user.custname}</td>
                       <td>${user.age}</td>
                       <td>${user.email}</td>
                       <td>${user.phoneno}</td>
                       
                </tr>
            </c:forEach>
      </table>  
    </body>
</html>