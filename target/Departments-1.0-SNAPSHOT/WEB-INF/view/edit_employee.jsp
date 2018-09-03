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
    <h1> Edit employee</h1>
    <h2>

        <button type="button" onclick="window.location.href = '/employees?id=${dep_id}'"> Back</button>

    </h2>
    <form action="${pageContext.request.contextPath}/editEmployee" method="post">
        <input type="text" name="firstName" value="${employee.getFirstName()}">
        <input type="text" name="lastName" value="${employee.getLastName()}">
        <input type="email" name="email" value="${employee.getEmail()}">
        <input type="number" name="age" value="${employee.getAge()}">

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>
