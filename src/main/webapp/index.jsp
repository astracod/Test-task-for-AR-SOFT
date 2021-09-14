<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Test on Java EE</title>
</head>
<body>
<h1>First Task</h1>
<br>
<form action="${pageContext.request.contextPath}/first " method="post">
    <p><b>Enter your text:</b></p>
    <p><textarea rows="10" cols="45" name="text"></textarea></p>
    <p><input type="submit" value="Send"></p>
</form>
<br>
<pre>Name: ${name}</pre>
<pre>Num: ${num}</pre>
<br>
<h1>Second Task</h1>
<br>
<form action="${pageContext.request.contextPath}/bank" method="post">
    <p><textarea rows="10" cols="45" name="payments"></textarea></p>
    <p><input type="submit" value="Send"></p>
</form>

</body>
</html>