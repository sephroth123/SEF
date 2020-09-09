<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
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
		<form action="login" method="post">
			<table border="0" align="center">
				<tr>
					<td colspan="2">
						<h1>Student Project Distribution System</h1>

					</td>
				</tr>
				<tr>
					<td align="right">student number:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td align="right">password:</td>
					<td><input type="text" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" style="width: 100px; height: 50px;"><span
						id="msg"><%=message%></span> <input type="submit" value="login"
						style="width: 100px" /></td>
				</tr>
				<tr>
					<td colspan="2"><img
						src="https://mytestdbgx.s3.amazonaws.com/download.jpeg" /></td>
				</tr>
				
			</table>



		</form>

	</div>

</body>
</html>