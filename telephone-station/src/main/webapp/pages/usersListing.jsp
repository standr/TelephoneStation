<html>
<head>
<%@ include file="../includes/includes.jspf"%>

<title><fmt:message key="users.page.title" /></title>
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="header-info">
				<fmt:message key="header.info" />
			</div>
		</div>
		<div id="left-column"><%@ include
				file="../includes/menus/adminMenu.jspf"%></div>
		<div id="content">
			<h2><fmt:message key="admin.menu.users_list" /></h2>
			<table border=1>
				<tr>
					<td><b><fmt:message key="users.page.id" /></b></td>
					<td><b><fmt:message key="users.page.login" /></b></td>
					<td><b><fmt:message key="users.page.email" /></b></td>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.id}</td>
						<td><a
							href="${pageContext.request.contextPath}/BaseController?page=get_user&id=${user.id}">${user.login}</a></td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>

			</table>
			<p>
				<span>${errors.error}</span>
			</p>
		</div>
	</div>
</body>
</html>