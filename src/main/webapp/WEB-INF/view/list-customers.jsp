<%--
  Created by IntelliJ IDEA.
  User: mansoura
  Date: 23/05/2020
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css"
        rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <form:form action="searchCustomer" modelAttribute="search" method="GET">
        <table>
            <tr>
                <td><form:input path="searchValue"/></td>
                <td><input type="submit" value="Search" class="save"/></td>
            </tr>
        </table>
    </form:form>

    <div id="container">
        <div id="content">

            <input class="add-button" type="button" value="Add Customer"
                   onclick="window.location.href='saveCustomerForm'; return false"/>
            
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td><a href="${pageContext.request.contextPath}/customer/updateCustomerForm?customerId=${customer.id}">Update</a> |
                            <a href="${pageContext.request.contextPath}/customer/deleteCustomerForm?customerId=${customer.id}"
                            onclick="if (!confirm('Are you sure you want to delete?')) return false">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>
