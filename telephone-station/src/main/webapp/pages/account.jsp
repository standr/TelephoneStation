<html>
<head>
<%@ include file="../includes/includes.jspf"%>
<title><fmt:message key="user.page.welcome" /> ${user.login}</title>
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="header-info">
				<fmt:message key="header.info" />
			</div>
		</div>
		<div id="left-column"><%@ include
				file="../includes/menus/userMenu.jspf"%></div>
		<div id="content">
			<table border=1>
				<tr>
					<td><b><fmt:message key="user.page.id" /></b></td>
					<td><b><fmt:message key="user.page.first_name" /></b></td>
					<td><b><fmt:message key="user.page.last_name" /></b></td>
					<td><b><fmt:message key="user.page.balance" /></b></td>
				</tr>
				<tr>
					<td>${subscriber.id}</td>
					<td>${subscriber.firstname}</td>
					<td>${subscriber.lastname}</td>
					<td></td>
				</tr>
			</table>
			<p>
				<span>${errors.error}</span>
			</p>
		</div>
	</div>
</body>
</html>