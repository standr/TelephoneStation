<html>
<head>
<%@ include file="../includes/includes.jspf"%>

<title><fmt:message key="update_service.page.title" /></title>
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
			<form action="BaseController" method="post">
				<input type="hidden" name="page" value="update_service" />
				<table>
					<tr>
						<td><fmt:message key="update_service.page.id" /></td>
					</tr>
					<tr>
						<td><input type="hidden" name="service_id"
							value="${service.id}"></td>
					</tr>
					<tr>
						<td><fmt:message key="update_service.page.name" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="service_name"
							value="${service.serviceName}"></td>
					</tr>
					<tr>
						<td><fmt:message key="update_service.page.price" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="price"
							value="${service.price}"></td>
					</tr>
					<tr>
						<td><fmt:message key="update_service.page.duration" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="duration"
							value="${service.duration}"></td>
					</tr>
					<tr>
						<td><input type="submit"
							value=<fmt:message key="update_service.page.update_button"/>
							name="update service"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>