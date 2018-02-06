<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="bootstrap/dist/js/bootstrap.min.js"></script>
<link rel="icon" type="img/x-ico" href="image/icon/favicon_32x32.ico" />
<link rel="stylesheet" type="text/css"
	href="bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="stylesheet" type="text/css" href="css/loginPage.css">

<title>${pageTitle}</title>
</head>
<body>
	<div class="loginPageContent">
		<header:header />
		<div class="container">
			<div class="loginMainContent">
				<div class="registDiv">
					<form class="registForm">
						<div class="registFormInner">
							<input class="regisInput" type="text" name="phoneNum"
								placeholder="手机号"><br> <input class="regisInput"
								type="text" name="id" placeholder="用户名"><br> <input
								class="regisInput" type="text" name="pass" placeholder="设置密码"><br>
							<input class="regisInput" type="text" name="repass"
								placeholder="确认密码"><br> <input
								class="regisInputIdCode" type="text" name="idCode"
								placeholder="验证码"><input class="regisButIdCode"
								type="button" value="获取验证码"><br> <input
								class="registSubmit" type="submit" value="注册会员">
						</div>
					</form>
				</div>
				<div class="loginDiv">
					<form class="loginForm">
						<div class="loginFormInner">
							<input class="loginInput" type="text" name="phoneNum"
								placeholder="手机号"><br> <input class="loginInputIdCode"
								type="text" name="loginButIdCode" placeholder="验证码"><input
								class="loginButIdCode" type="button" value="获取验证码"><br>
							<input class="loginSubmit" type="submit" value="登入">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="loginFooterDiv">
			<footer:footer />
		</div>
	</div>
</body>
</html>