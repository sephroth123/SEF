<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<%
	String projectIdString = (String) request.getAttribute("projectIdString");
	if (projectIdString == null) {
		projectIdString = "";

	}
%>


<body>
	<div class="main" style="margin-top: 200px;">
		<form action="ProjectDiscardServlet" method="post">
			<table border="0" align="center">
				<tr>
					<td colspan="2">Project Discard</td>
				</tr>

				<tr>
					<td align="right">Before Project List:</td>
					<td><%=projectIdString%></td>
				</tr>

			</table>
			<input type="submit" value="discard"
				style="width: 100px; height: 50px;" />
		</form>
	</div>
</body>
</html>