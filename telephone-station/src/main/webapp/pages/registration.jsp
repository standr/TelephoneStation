<html>
<head>
<%@ include file="../includes/includes.jspf"%>
<title><fmt:message key="registration.page.title" /></title>
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="header-info">
				<fmt:message key="header.info" />
			</div>
		</div>
		<div id="left-column">TEST</div>
		<div id="content">
			<h2>
				<fmt:message key="registration.page.req_user_info" />
			</h2>

			<form action="BaseController" method="get">
				<input type="hidden" name="page" value="registration" />
				<table>
					<tr>
						<td><fmt:message key="registration.page.login" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="login"></td>
					</tr>
					<tr>
						<td><fmt:message key="registration.page.email" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="email"></td>
					</tr>
					<tr>
						<td><fmt:message key="registration.page.password" /></td>
					</tr>
					<tr>
						<td><input class="field" type="password" name="password"></td>
					</tr>
					<tr>
						<td><input type="submit"
							value="<fmt:message key="sign_up" />" name="submit"><span>${errors.error}</span></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>