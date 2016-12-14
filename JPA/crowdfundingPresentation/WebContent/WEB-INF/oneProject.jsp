<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<c:if test="${mode=='edit'}">
		<form method="POST">
			<div class="verticaleFlexContainer">


				<div>
					<label for="nameInput">nom</label> <input type="text"
						value="${project.name}" id="nameInput" name="nameInput">
				</div>
				<div>
					<label for="goalInput">objectif</label> <input type="text"
						value="${project.goal}" id="goalInput" name="goalInput">
				</div>
				<div>
					<label for="descriptionInput">description</label> <input
						type="text" value="${project.description}" id="descriptionInput"
						name="descriptionInput">
				</div>
				<input type="hidden" value="${projet.id}" name="id">
				<button>enregistrer</button>
			</div>
		</form>
	</c:if>
	<c:if test="${mode=='read'}">
		<div class="horizontalFlexContainer">
			<div class="verticalFlexContainer">
				<div>
					<c:out value="${project.name}"></c:out>
				</div>
				<div>
					<c:out value="${project.description}"></c:out>
				</div>
				<c:url value="oneProject" var="url">
					<c:param name="id" value="${project.id}" />
					<c:param name="action" value="edit" />
				</c:url>
				<a href="${url}">editer </a>
			</div>

			<div class="verticalFlexContainer">
				<c:out value="${project.goal}"></c:out>
				<span>€</span>
			</div>
		</div>
	</c:if>

</t:template>