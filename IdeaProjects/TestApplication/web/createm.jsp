<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create message</title>
    <script type="text/javascript"></script>
</head>
<body>
<h3>Send message</h3>
<form name = "Registration" method="post" >
    <label>Message</label><br>
    <label>
        <input message name="message"/>
    </label><br><br>
    <input type="submit" value="Send" />
</form>
<p><a href='<c:url value="/getm" />'>Get random message</a></p>
<p><a href='<c:url value="/" />'>Back</a></p>
</body>
</html>