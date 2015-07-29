<%@ page pageEncoding="UTF-8" %>
<%@include file="/header.jsp" %>
<script type="text/javascript" src="/js/userManage.js"></script>
<body>
<form id="form">
	<input type="hidden" name="selectUserId"/>
	<input type="button" value="新規登録" onclick="move('edit');"/>
	<table border="1">
		<tr>
			<th>ログインID</th>
			<th>パスワード</th>
			<th>利用者(氏名)</th>
			<th>メールアドレス</th>
			<th>権限</th>
			<th>操作</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.password}</td>
				<td>${user.name}</td>
				<td>${user.email.email}</td>
				<td>
					<c:if test="${user.admin}" >
						有
					</c:if>
				</td>
				<td>
					<input type="button" value="編集" onclick="moveEdit('${user.userId}');"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
<%@ include file="/footer.jsp" %>