<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<c:url value="oneProject" var="urlCreate">
		<c:param name="action" value="create" />
	</c:url>
	<a href="${urlCreate}">ajouter</a>

	<div class="horizontalFlexContainer">
		<c:forEach items="${projects}" var="project">

			<c:url value="oneProject" var="url">
				<c:param name="id" value="${project.id}" />
			</c:url>
			<a href="${url}" class="projectCard">
				<div>
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
			</a>
		</c:forEach>
	</div>

</t:template>