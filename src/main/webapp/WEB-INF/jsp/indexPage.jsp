<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="addon/owl-carousel/owl.carousel.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/zerogrid.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">

<link rel="stylesheet" type="text/css"
	href="addon/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="addon/owl-carousel/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<link rel="stylesheet" type="text/css" href="css/indexPage.css" />

<title>克里斯咨询站-首页</title>
</head>
<body>
	<header:header />
	<div>
		<div id="cssmenu">
			<ul>
				<li><a href="#"><span>首页</span></a></li>
				<li><a href="#"><span>天涯明月刀</span></a></li>
			</ul>
		</div>
		<div class="owl">
			<div id="owl-slide" class="owl-carousel">
				<div class="item">
					<img src="image/indexSlider/slider1.jpg" width="100%" />
				</div>
				<div class="item">
					<img src="image/indexSlider/slider2.jpg" width="100%" />
				</div>
				<div class="item">
					<img src="image/indexSlider/slider3.jpg" width="100%" />
				</div>
			</div>
		</div>
	</div>
	<footer:footer />
</body>
</html>