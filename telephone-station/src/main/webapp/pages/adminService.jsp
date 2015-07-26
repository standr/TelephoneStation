<html>
<head>
<%@ include file="../includes/includes.jspf"%>

<title><fmt:message key="services.page.title" /></title>
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
			<h2><fmt:message key="admin.menu.services_list" /></h2>
			<table border=1>
				<tr>
					<td><b><fmt:message key="services.page.id" /></b></td>
					<td><b><fmt:message key="services.page.name" /></b></td>
					<td><b><fmt:message key="services.page.price" /></b></td>
					<td><b><fmt:message key="services.page.duration" /></b></td>
					<td colspan="2"><b><fmt:message key="services.page.action" /></b></td>
				</tr>
				<c:forEach var="service" items="${services}">
					<tr>
						<td>${service.id}</td>
						<td>${service.serviceName}</td>
						<td>${service.price}</td>
						<td>${service.duration}</td>
						<td><a
							href="${pageContext.request.contextPath}/BaseController?page=get_service&id=${service.id}"><fmt:message
									key="services.page.edit_service" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/BaseController?page=delete_service&id=${service.id}"><fmt:message
									key="services.page.delete_service" /></a></td>
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