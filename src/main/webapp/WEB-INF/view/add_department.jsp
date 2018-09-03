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
    <h1> Add new department</h1>
    <h2>

        <button type="button" onclick="window.location.href = '/'"> Back</button>

    </h2>
    <form action="${pageContext.request.contextPath}/addDepartment" method="post">
        <label> Name </label>
        <input name="name" placeholder="Name">
        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>