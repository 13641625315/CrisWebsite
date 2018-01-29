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
		<div class="loginMainContent">
			<div class="registDiv">11</div>
			<div class="loginDiv">22</div>
		</div>
		<div class="loginFooterDiv">
			<footer:footer />
		</div>
	</div>
</body>
</html>