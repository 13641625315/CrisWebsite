<%@  tag pageEncoding="UTF-8"%>

<div class="headerTop">
	<div class="headerWeather">
		<div class="headerWeatherDetail">
			<div class="headerWeatherDetailText">${heWeather.heWeather5[0].basic.city}&nbsp;&nbsp;</div>
			<img
				src="image/hfweather/${heWeather.heWeather5[0].now.cond.code}.png"
				alt="${heWeather.heWeather5[0].now.cond.txt}"
				class="headerWeatherDetailImage"><div
				class="headerWeatherDetailText">${heWeather.heWeather5[0].now.cond.txt}&nbsp;&nbsp;&nbsp;${heWeather.heWeather5[0].now.tmp}℃&nbsp;&nbsp;</div>
		</div>
	</div>
	<div class="headerAccount">
		<div class="headerAccountDetail">
			<span class="headerAccountDetailLink"><a href="#">注册</a></span>
			<span class="headerAccountDetailLink"><a href="#">登录</a></span>
			<span class="headerAccountDetailLink"><a href="#">充值</a></span>
		</div>
	</div>
</div>
<div class="headerNav">
	<ul>
		<li><a href="#"><span>首页</span></a></li>
	</ul>
</div>
