<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<div class="horizontalFlexContainer">
		<c:forEach items="${projects}" var="project">
			<div class="projectCard">
				<div>
					<c:out value="${project.name}" />
				</div>
				<div>
					<c:out value="${project.goal}" />
				</div>
				<div>
					<c:out value="${project.description}" />
				</div>
			</div>
		</c:forEach>
	</div>

</t:template>