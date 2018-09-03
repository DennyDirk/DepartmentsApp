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
    <h1> Add new employee</h1>
    <h2>

        <button type="button" onclick="window.location.href = '/employees?id=${department_id}'"> Back</button>

    </h2>
    <form action="${pageContext.request.contextPath}/addEmployee" method="post">
        <input type="text" name="firstName" placeholder="First Name">
        <input type="text" name="lastName" placeholder="Last Name">
        <input type="email" name="email" placeholder="E-mail">
        <input type="number" name="age" placeholder="Age">

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>