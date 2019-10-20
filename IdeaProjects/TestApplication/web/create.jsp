<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
<h3>New user</h3>
<form name = "Registration" method="post" >
    <form onSubmit="return check()";>
    <label>Name</label><br>
    <label>
        <input name ="name" id="username" />
    </label><br><br>
    <label>Login</label><br>
    <input login name="login" id= "login"/><br><br>
    <label>Password</label><br>
    <input password name="password" id="password"/><br><br>
    <input type="submit" value="Register" />
    </form>>
</form>
<p><a href='<c:url value="/" />'>Back</a></p>
</body>
</html>