<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>login Index</title>
</head>
<body>
<form method="post">
<p>ログインID</p>
<input type="text" name="userId"/>
<p>パスワード</p>
<input type="password" name="password"/>

<input type="submit" value="ログイン"/>
</form>
</body>
</html>
