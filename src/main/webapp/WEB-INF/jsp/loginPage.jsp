<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/footer"%>
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
	href="/CrisWebsite/css/loginPage.css">

<title>${pageTitle}</title>
<script>
	function checkRegistForm() {
		var hasError = document.getElementsByClassName("has-error");
		if (0 != hasError.length) {
			for (var i = 0, length = hasError.length; i < length; i++) {
				hasError[i].classList.remove("has-error");
			}
		}
		//校验PhoneNum
		if (!isPhoneNumAvailable($("#registFormPhoneNum").val())) {
			$("#registFormPhoneNumControl").addClass("has-error");
			return false;
		}
		//校验NickName
		if (!isNickNameAvailable($("#registFormNickName").val())) {
			$("#registFormNickNameControl").addClass("has-error");
			return false;
		}
		//校验Pass&Repass

		//校验验证码
		return false;
	}

	function isPhoneNumAvailable(phoneNum) {
		if (phoneNum.trim() == "") {
		       return false;
		}
		//11为数字
		var reg = /^[1][0-9]{10}$/;
		if (!reg.test(phoneNum)) {
			return false;
		} else {
			return true;
		}
	}

	function isNickNameAvailable(nickName) {
	     if (nickName.trim() == "") {
	       return false;
	     }
	     var reg = /^[\u4e00-\u9fa5A-Za-z0-9_]*$/;
	     if (reg.test($.trim(nickName))) {
	     	var count = 0;
	        var chinese = /^[\u4e00-\u9fa5]$/;
	        for ( var i = 0; i < nickName.length; i++) {
	        	var temp = nickName[i];
	        	if (chinese.test(temp)) {
	        		count = count + 2;
	        	} else {
	        		count = count + 1;
	       		}
	       	}
	       	if (count < 4 || count > 16) {
	    		return false;
	       	} else {
	    		return true;
	       	}
	     } else {
	     	return false;
	     }
	}
</script>
</head>
<body>
	<div class="loginPageContent">
		<header:header />
		<div class="crisContainer">
			<div class="loginMainContent">
				<div class="registDiv">
					<form class="registForm" action="/CrisWebsite/userRegist"
						method="post" onsubmit="return checkRegistForm()">
						<div class="registFormInner">
							<div id="registFormPhoneNumControl">
								<input class="regisInput form-control" type="text"
									id="registFormPhoneNum" name="phoneNum" placeholder="手机号">
							</div>
							<div id="registFormNickNameControl">
								<input class="regisInput form-control" type="text"
									id="registFormNickName" name="nickName" placeholder="用户名">
							</div>
							<div id="registFormPassControl">
								<input class="regisInput form-control" type="text"
									id="registFormPass" name="pass" placeholder="设置密码">
							</div>
							<div id="registFormRepassControl">
								<input class="regisInput form-control" type="text"
									id="registFormRepass" name="repass" placeholder="确认密码">
							</div>
							<div id="registFormIdCodeControl">
								<input class="regisInputIdCode form-control" type="text"
									id="registFormIdCode" name="idCode" placeholder="验证码">
								<input class="regisButIdCode" id="registFormGetIdCodeBut"
									name="getIdCodeBut" type="button" value="获取验证码">
							</div>
							<input class="registSubmit" type="submit" value="注册会员"> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
					</form>
				</div>
				<div class="loginDiv">
					<form class="loginForm" action="/CrisWebsite/login" method="post">
						<div class="loginFormInner">
							<div id="loginFormPhoneNumControl">
								<input class="loginInput form-control" type="text"
									name="phoneNum" placeholder="手机号">
							</div>
							<div id="loginFormPassControl">
								<input class="loginInput form-control" type="password"
									name="pass" placeholder="密码">
							</div>
							<input name="remember-me" type="hidden" checked="checked" /><input
								class="loginSubmit" type="submit" value="登入"> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
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