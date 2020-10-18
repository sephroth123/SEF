<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>managment</title>
<style type="text/css">
#span {
	color: red;
	font-wight: bold;
}

.main {
	text-align: center;
	/*让div内部文字居中*/
	background-color: #fff;
	/* border-radius: 20px; */
	/* width: 300px;
            height: 350px;
            margin: auto; */
	/* position: absolute; */
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
}
</style>
</head>
<body>
	<%
		String message = "";
		String error = (String) request.getAttribute("error");
		if (message != null) {
			if (error != null) {
				message = error;
			}

		}
	%>

	<div class="main" style="margin-top: 200px;">

		<table border="0" align="center">

			<tr>
				<td>project:</td>
			</tr>
			<c:forEach items="${projectList}" var="project">
				<tr>
					<td align="center">${project.pid}</td>
					<td align="center">${project.description}</td>
				</tr>
			</c:forEach>

			<td>
			<tr>
				<form action="ProjectDiscardServlet" method="post">

					<input type="submit" value="Discard" style="width: 100px" />

				</form>

			</tr>
			</td>


			<tr>
				<td>student:</td>
			</tr>
			<c:forEach items="${studentList}" var="user">
				<tr>
					<td align="center">${user.sid}</td>
					<td align="center">${user.personalityType}</td>
					<td align="center">${user.experience}</td>
					<td align="center">${user.gpa}</td>
				</tr>
			</c:forEach>

			<form action="BuildTeamSevlet" method="post">
				<tr>
					<td align="right">student:</td>
					<td><input type="text" name="s1" /></td>
					<td><input type="text" name="s2" /></td>
					<td><input type="text" name="s3" /></td>
					<td><input type="text" name="s4" /></td>
				</tr>
				<tr>
					<td align="right">project Id:</td>
					<td><input type="text" name="projectId" /></td>
				</tr>

				<input type="submit" value="build team" style="width: 100px" />

			</form>


		</table>

		<table align="center">

			<form action="weightServlet" method="post">
				<c:forEach items="${weightList}" var="weight">
					<tr>
						<td align="center"><input type="text" name="wId"
							value="${weight.wId}" /></td>
						<td align="center"><input type="text" name="constraint"
							value="${weight.constraint}" /></td>
						<td align="center"><input type="text" name="weight"
							value="${weight.weight}" /></td>
					</tr>

				</c:forEach>
				<input type="submit" value="update weight" style="width: 100px" />
			</form>
		</table>

	</div>
	<form action="swap.jsp">
		<input type="submit" value="swapStudent" style="margin-left: 850px;">
	</form>



</body>

</html>