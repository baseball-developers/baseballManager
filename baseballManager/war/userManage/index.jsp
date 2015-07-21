<%@ include file="/header.jsp" %>
<body>
<form id="form">
	<input type="hidden" name="key"/>
	<input type="button" value="新規登録" onclick="move('edit');"/>

	<table border="1">
		<tr>
			<th>ログインID</th>
			<th>パスワード</th>
			<th>利用者(氏名)</th>
			<th>権限</th>
			<th>操作</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.password}</td>
				<td>${user.name}</td>
				<td>
					<c:if test="${user.admin}" >
						有
					</c:if>
				</td>
				<td>
					<input type="button" value="編集"/>
					<input type="button" value="削除" onclick="removeItem();"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
<%@ include file="/footer.jsp" %>