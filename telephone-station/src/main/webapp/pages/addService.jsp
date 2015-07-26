<html>
<head>
<%@ include file="../includes/includes.jspf"%>
<%@ include file="../includes/access.jspf"%>
<title><fmt:message key="add_service.page.title" /></title>
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
			<h2>
				<fmt:message key="admin.menu.add_service" />
			</h2>
			<form action="BaseController" method="post">
				<input type="hidden" name="page" value="add_service" />
				<table class="leftcol">
					<tr>
						<td><fmt:message key="add_service.page.service_name" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="service_name"></td>
					</tr>
					<tr>
						<td><fmt:message key="add_service.page.price" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="price"></td>
					</tr>
					<tr>
						<td><fmt:message key="add_service.page.duration" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="duration"></td>
					</tr>
					<tr>
						<fmt:message key="add_service.page.add_button" var="add_service" />
						<td><input type="submit" value="${add_service}"	name="addservice"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>