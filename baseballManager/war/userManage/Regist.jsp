<%@ page pageEncoding="UTF-8" %>
<%@ include file="/header.jsp" %>
<script type="text/javascript" src="/js/userManage.js"></script>
<body>
<form id="form">
<p>ユーザID:<input type="text" name="userId"/></p>
<p>パスワード:<input type="password" name="password"/></p>
<p>名前<input type="text" name="name"/></p>
<p>メール<input type="text" name="email"/></p>
<p>権限<input type="checkbox" name="isAdmin" value="1" /></p>

<input type="button" value="登録" onclick="registItem();"/>
</form>
</body>
<%@ include file="/footer.jsp" %>