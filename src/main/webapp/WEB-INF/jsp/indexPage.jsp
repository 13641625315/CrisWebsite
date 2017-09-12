<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="addon/owl-carousel/owl.carousel.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<link rel="stylesheet" type="text/css" href="css/global.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<link rel="stylesheet" type="text/css" href="css/indexPage.css" />
<link rel="stylesheet" type="text/css"
	href="addon/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="addon/owl-carousel/owl.carousel.css">

<title>Cris WebSite</title>
</head>
<body>
	<header:header />
	<div>
		<div id="cssmenu">
			<ul>
				<li class="active"><a href="#"><span>首页</span></a></li>
				<li><a href="#"><span>内容1</span></a></li>
				<li><a href="#"><span>内容2</span></a></li>
				<li><a href="#"><span>内容3</span></a></li>
				<li><a href="#"><span>内容4</span></a></li>
				<li><a href="#"><span>内容5</span></a></li>
				<li><a href="#"><span>内容6</span></a></li>
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
</body>
</html>