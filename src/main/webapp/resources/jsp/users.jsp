<%@ include file="layout/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>User name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>
						<a href="<spring:url value="/users/${user.userId}.html" />">
							${user.login}
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>