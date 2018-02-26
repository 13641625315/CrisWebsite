<%@  tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="headerTop">
	<div class="container">
		<div class="headerWeather">
			<div class="headerWeatherDetail">
				<div class="headerWeatherDetailText">${heWeather.heWeather5[0].basic.city}&nbsp;&nbsp;</div>
				<img
					src="image/hfweather/${heWeather.heWeather5[0].now.cond.code}.png"
					alt="${heWeather.heWeather5[0].now.cond.txt}"
					class="headerWeatherDetailImage">
				<div class="headerWeatherDetailText">${heWeather.heWeather5[0].now.cond.txt}&nbsp;&nbsp;&nbsp;${heWeather.heWeather5[0].now.tmp}℃&nbsp;&nbsp;</div>
			</div>
		</div>
		<div class="headerAccount">
			<div class="headerAccountDetail">
				<sec:authorize access="hasAnyRole('ROLE_ANONYMOUS')">
					<span class="headerAccountDetailLink"><a
						href="/CrisWebsite/loginPage">登录</a></span>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_USER')">
					<span class="headerAccountDetailLink"><a href="#">充值</a></span>
					<span class="headerAccountDetailLink"><a
						href="/CrisWebsite/logout">注销</a></span>
				</sec:authorize>
			</div>
		</div>
	</div>
</div>

<form name='logoutForm' action='/CrisWebsite/logout' method='post'>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>