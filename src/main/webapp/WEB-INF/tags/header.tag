<%@  tag pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="css/menu.css" />

<div class="headerTop">
	<div class="headerWeather">
		<p class="headerWeatherDetail">
			${heWeather.heWeather5[0].basic.city}&nbsp;&nbsp;<img
				src="image/weather/${heWeather.heWeather5[0].now.cond.code}.png"
				alt="${heWeather.heWeather5[0].now.cond.txt}" width="20px"
				height="17px" style="vertical-align: middle">${heWeather.heWeather5[0].now.cond.txt}&nbsp;&nbsp;&nbsp;${heWeather.heWeather5[0].now.tmp}℃&nbsp;&nbsp;
		</p>
	</div>
	<div class="headerAccount">
		<p class="headerAccountDetail">
			<span class="headerAccountDetailLogin"><a href="#">登录</a></span>
		</p>
	</div>
</div>
<div id="cssmenu">
	<ul>
		<li><a href="#"><span>首页</span></a></li>
		<li><a href="#"><span>天涯明月刀</span></a></li>
	</ul>
</div>

