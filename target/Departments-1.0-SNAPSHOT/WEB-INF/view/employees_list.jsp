<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%--<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>--%>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }

        table {
            width: 100%;
            background-color: #f1f1c1;
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <h1> EMPLOYEES LIST</h1>
    <h2> ${departmentName}</h2>
    <h2>

        <button type="button" onclick="window.location.href = '/addEmployee?id=${department_id}'"> Add new employee
        </button>

    </h2>
    <h2>

        <button type="button" onclick="window.location.href = '/'"> Back</button>

    </h2>
    <c:if test="${employeesList.isEmpty()}">
        <label style="color: red"> Employees do not exist. Add a new employee.</label>
    </c:if>
    <table>
        <thead>

        <tr>
            <th>First name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Age</th>
            <th>Created on</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <form action="${pageContext.request.contextPath}/employees" method="post">
            <c:forEach items="${employeesList}" var="employee">
                <tr>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>${employee.age}</td>
                    <td>${employee.createdOn}</td>
                    <td>
                        <button type="submit" name="edit" value="${employee.id}">Edit</button>
                        <button type="submit" name="delete" value="${employee.id}">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </form>
        </tbody>

    </table>
</div>

</body>
</html>