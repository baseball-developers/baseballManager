<%@ include file="/header.jsp" %>
<script type="text/javascript" src="/js/userManage.js"></script>
<body>
<form id="form">
<p>ユーザID:<input type="text" name="userId"/></p>
<p>パスワード:<input type="password" name="password"/></p>
<p>名前<input type="text" name="name"/></p>
<p>メール<input type="text" name="email"/></p>
<p>権限<input type="checkbox" name="isAdmin"/></p>
</form>
</body>
<%@ include file="/footer.jsp" %>