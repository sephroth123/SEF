<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Manager</title>
</head>
<body>

	<div class="main" style="margin-top: 200px;">
		<form action="login" method="post">
			<table border="0" align="center">
				<tr>
					<td align="right">Student ID:</td>
					<td><input type="text" name="sid" /></td>
				</tr>


				<tr>
					<td align="right">GPA you want to set:</td>
					<td><input type="text" name="GPA" /></td>
				</tr>




				<tr>
					<td align="right">Personality you want to set:</td>
					<td><input type="text" name="Personality" /></td>
				</tr>




				<input type="button" onclick="turn to valid Team page" value="跳转" />
				<script>
						function test(){
						 var url = "要跳转的路径";
						 window.location.href= url;
						}
						</script>
			</table>



		</form>

	</div>

</body>
</html>