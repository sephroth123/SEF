<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Publish project</title>
<style type="text/css">
#span {
	color: red;
	font-wight: bold;
}

.main {
	text-align: center;
	background-color: #fff;
	border-radius: 20px;
	width: 300px;
	height: 350px;
	margin: auto;
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
		String description = "";
		description = (String) request.getAttribute("description");
	%>
	<div class="main" style="margin-top: 200px;">
		<form action="check" method="post">
			<table border="0" align="center">
				<tr>
					<td colspan="2">project detail</td>
				</tr>
				<tr>
					<td align="right">description:</td>
					<td><%=description%></td>
				</tr>

				<tr>
					<td colspan="2" style="width: 100px; height: 50px;"></td>
				</tr>

			</table>



		</form>

	</div>

</body>

</html>