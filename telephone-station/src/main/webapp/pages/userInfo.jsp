<html>
<head>
<%@ include file="../includes/includes.jspf"%>
<title><fmt:message key="user.page.title" /></title>
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
				<tr>
					<td><b><fmt:message key="services.page.id" /></b></td>
					<td><b><fmt:message key="services.page.name" /></b></td>
				</tr>
				<c:forEach var="service" items="${services}">
					<tr>
						<td>${service.id}</td>
						<td>${service.serviceName}</td>
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