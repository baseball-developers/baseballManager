<%@ include file="/header.jsp" %>
<script type="text/javascript" src="/js/userManage.js"></script>
<body>
<form id="form">
<input type="hidden" name="userId" value="${userInfo.userId}"/>

<p>ユーザID:${userInfo.userId}</p>
<p>パスワード:<input type="password" name="password"/></p>
<p>名前<input type="text" name="name" value="${userInfo.name}"/></p>
<p>メール<input type="text" name="email" value="${userInfo.email}"/></p>
<p>権限<input type="checkbox" name="isAdmin"  <c:if test="${userInfo.admin}">checked</c:if> /></p>

<input type="button" value="更新" onclick="saveItem();"/>
</form>
</body>
<%@ include file="/footer.jsp" %>
