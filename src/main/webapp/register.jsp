<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电信资费管理系统</title>
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="styles/global_color.css" />
<style type="text/css">
#a1 {
	border: 1px solid gray;
	front-size: 25px;
	text-decoration: null;
	color: white;
	background-color: gray;
}
</style>
</head>
<body class="index">
	<div class="login_box">
		<form action="/java-web1/register" method="post">
			${info }
			<table>
				<tr>
					<td class="login_info">账号：</td>
					<td colspan="2"><input name="username" type="text"
						class="width150" /></td>
					<td class="login_error_info"></td>
				</tr>
				<tr>
					<td class="login_info">密码：</td>
					<td colspan="2"><input name="password" type="password"
						class="width150" /></td>
					<td></td>
				</tr>
				<tr>
					<td class="login_info">住址：</td>
					<td colspan="2"><input name="address" type="text"
						class="width150" /></td>
					<td></td>
				</tr>
				<tr>
					<td class="login_info">电话：</td>
					<td colspan="2"><input name="tel" type="text" class="width150" /></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td class="login_button" colspan="2">
						<button type="submit">点&nbsp;击&nbsp;注&nbsp;册</button>
					</td>
					<td><span class="required"></span></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
