<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="slider" tagdir="/WEB-INF/tags/"%>

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
<link rel="stylesheet" type="text/css" href="css/slider.css" />
<link rel="stylesheet" type="text/css" href="css/indexPage.css" />

<title>${pageTitle}</title>
</head>
<body>
	<header:header />
	<slider:slider />
	<div class="indexSubscribeContent">
		<div class="container">
			<h2>Subscribe to our newsletter</h2>
			<br clear="all">
			<form method="post">
				<input type="email" placeholder="请输入你的Email"> <input
					type="submit" value="订阅">
			</form>
		</div>
	</div>
	<footer:footer />
</body>
</html>