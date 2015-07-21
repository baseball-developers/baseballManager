<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>userManage Edit</title>
</head>
<body>

<p>ユーザID:<input type="text" name="userId"/></p>
<p>パスワード:<input type="password" name="password"/></p>
<p>名前<input type="text" name="name"/></p>
<p>メール<input type="text" name="email"/></p>
<p>権限<input type="checkbox" name="isAdmin"/></p>

</body>
</html>