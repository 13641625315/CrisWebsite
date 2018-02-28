<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
<%@ taglib prefix="slider" tagdir="/WEB-INF/tags/slider"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="/CrisWebsite/js/jquery.min.js"></script>
<script type="text/javascript" src="/CrisWebsite/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="/CrisWebsite/bootstrap/dist/js/bootstrap.min.js"></script>
<link rel="icon" type="img/x-ico"
	href="/CrisWebsite/image/icon/favicon_32x32.ico" />
<link rel="stylesheet" type="text/css"
	href="/CrisWebsite/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/CrisWebsite/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="/CrisWebsite/css/header.css" />
<link rel="stylesheet" type="text/css"
	href="/CrisWebsite/css/footer.css">
<link rel="stylesheet" type="text/css"
	href="/CrisWebsite/css/slider.css" />
<link rel="stylesheet" type="text/css"
	href="/CrisWebsite/css/indexPage.css" />

<title>${pageTitle}</title>
</head>
<body>
	<header:header />
	<slider:slider />
	<div class="indexSubscribeContent">
		<div class="crisContainer">
			<div class="crisindexSubscribe">
				<h2>订阅最新最酷的资讯</h2>
				<br clear="all">
				<form method="post">
					<input id="indexSubscribeContentEmail" type="email"
						placeholder="请输入你的Email"> <input
						id="indexSubscribeContentSubmit" type="submit" value="订阅">
				</form>
			</div>
		</div>
	</div>
	<footer:footer />
</body>
</html>