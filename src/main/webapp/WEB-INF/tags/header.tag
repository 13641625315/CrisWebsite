<%@  tag pageEncoding="UTF-8"%>

<div class="header">
	<div class="headerWeather">
		<p class="headerWeatherDetail">
			<span class="headerWeatherDetailCity">${heWeather.heWeather5[0].basic.city}&nbsp;&nbsp;</span><img
				src="image/weather/${heWeather.heWeather5[0].now.cond.code}.png"
				alt="${heWeather.heWeather5[0].now.cond.txt}" width="20px"
				height="20px" style="vertical-align: middle">${heWeather.heWeather5[0].now.cond.txt}&nbsp;&nbsp;&nbsp;${heWeather.heWeather5[0].now.tmp}℃&nbsp;&nbsp;
		</p>
	</div>
	<div class="headerAccount">
		<p class="headerAccountDetail">
			<span class="headerAccountDetailLogin"><a
				href="#">登录</a></span>
		</p>
	</div>
</div>