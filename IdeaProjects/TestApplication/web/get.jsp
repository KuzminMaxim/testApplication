<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
</head>
<body>
<table>
    <tr><th>Name</th><th>Login</th><th>Password</th><th></th></tr>
    <c:forEach var="User" items="${User}">
        <tr><td>${User.name}</td>
            <td>${User.login}</td>
            <td>${User.password}</td></tr>
    </c:forEach>
</table>
<p><a href='<c:url value="/create" />'>Registration</a></p>
<p><a href='<c:url value="/" />'>Back</a></p>
</body>
</html>
