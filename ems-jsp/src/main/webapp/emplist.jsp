<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1> 员工列表</h1>
<table>
    <tr>
        <td>员工ID</td>
        <td>员工姓名</td>
        <td>出生年月</td>
        <td>工资</td>
        <td>性别</td>
    </tr>
    <c:forEach items="${requestScope.employees}" var = "employee">
        <tr>
            <td>${employe.id}</td>
            <td>${employee.name}</td>
            <td><fmt:formatDate value="${employee.birthday}" pattern="yyyy-MM-dd"/></td>
            <td>${employee.salary}</td>
            <td>${employee.gender?'男':'女'}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>