<%@  tag pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/header/"%>

<header>
	<c:choose>
		<c:when test="${pageID eq 'loginPage'}">
			<header:headerLogin />
		</c:when>
		<c:otherwise>
			<div class="topBackground">
				<header:headerTop />
				<header:headerNav />
			</div>
		</c:otherwise>
	</c:choose>
</header>
