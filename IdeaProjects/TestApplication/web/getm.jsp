<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
</head>
<body>
<table>
    <tr><th>Message</th></tr>
    <c:forEach var="mess" items="${mess}">
        <tr><td>${mess.message}</td>
    </c:forEach>
</table>
<p><a href='<c:url value="/createm" />'>Back</a></p>
<p><a href='<c:url value="/" />'>Home page</a></p>
</body>
</html>