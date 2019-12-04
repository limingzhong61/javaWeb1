<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>达内－NetCTOSS</title>
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global_color.css" />
</head>
<body class="index">
	<div class="login_box">
		<form action="/java-web1/login" method="post">
			${info}
			<table>
				<tr>
					<td class="login_info">账号：</td>
					<td colspan="2"><input name="username" type="text" class="width150" /></td>
					<td class="login_error_info"></td>
				</tr>
				<tr>
					<td class="login_info">密码：</td>
					<td colspan="2"><input name="password" type="password"
						class="width150" /></td>
					<td></td>
				</tr>
				<tr>
					<td class="login_info">验证码：</td>
					<td class="width70"><input name="" type="text" class="width70" /></td>
					<td><img src="images/valicode.jpg" alt="验证码" title="点击更换" /></td>
					<td><span class="required"></span></td>
				</tr>
				<tr>
					<td></td>
					<td class="login_button" colspan="2"><button type="submit">
							<img src="images/login_btn.png" />
						</button></td>
					<td><span class="required"></span></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
