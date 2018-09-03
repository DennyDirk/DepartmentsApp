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
    <h1> DEPARTMENTS LIST</h1>
    <h2>

        <form action="${pageContext.request.contextPath}/addDepartment">
            <button type="submit"> Add new department</button>
        </form>

    </h2>
    <c:if test="${departmentList.isEmpty()}">
        <label style="color: red"> Departments do not exist. Add a new department.</label>
    </c:if>
    <table>
        <thead>
        <col width=70% valign="top">
        <col width=30% valign="top">
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <form action="${pageContext.request.contextPath}/" method="post">
            <c:forEach items="${departmentList}" var="department">
                <tr>
                    <td>${department.name}</td>
                    <td>
                        <button type="submit" name="edit" value="${department.id}">Edit</button>
                        <button type="submit" name="delete" value="${department.id}">Delete</button>
                        <button type="button" name="employees" onclick="window.location.href = '/employees?id=${department.id}'">Employees List</button>
                    </td>
                </tr>
            </c:forEach>
        </form>
        </tbody>

    </table>
</div>

</body>
</html>