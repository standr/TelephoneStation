<html>
<head>
<%@ include file="includes/includes.jspf"%>
<title><fmt:message key="index.page.title" /></title>
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="header-info">
				<fmt:message key="header.info" />
			</div>
		</div>
		<div id="left-column">
			<form action="BaseController" method="post">
				<input type="hidden" name="page" value="authentication" />
				<table class="leftcol">
					<tr>
						<td><fmt:message key="auth.form.login" /></td>
					</tr>
					<tr>
						<td><input class="field" type="text" name="login"></td>
					</tr>
					<tr>
						<td><fmt:message key="auth.form.password" /></td>
					</tr>
					<tr>
						<td><input class="field" type="password" name="password"></td>
					</tr>
					<tr>
						<fmt:message key="sign_in" var="sign_in" />
						<td><input type="submit" value="${sign_in}" name="submit">
							or <a
							href="${pageContext.request.contextPath}/BaseController?page=get_registration"><fmt:message
									key="sign_up" /></a></td>
					</tr>
					<tr>
						<td><span>${errors.error}</span><span>${errors.ban}</span></td>
					</tr>
				</table>
			</form>
		</div>
		<c:set var="nameOfProject"
			value="ittc.by Java Pro course project 2014" />
		<div id="footer">
			<c:out value="${nameOfProject}" />
		</div>
	</div>
</body>
</html>