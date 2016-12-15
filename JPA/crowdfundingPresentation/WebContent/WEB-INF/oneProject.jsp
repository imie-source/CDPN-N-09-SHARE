<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<c:if test="${mode=='edit'}">
		<form method="POST">
			<div class="tableContainer">


				<div class="tableRow bigText">
					<div>
						<label for="nameInput">nom</label>
					</div>
					<div>
						<input type="text" value="${project.name}" id="nameInput"
							name="nameInput">
					</div>
				</div>
				<div class="tableRow bigText">
					<div>
						<label for="goalInput">objectif</label>
					</div>
					<div>
						<input type="number" value="${project.goal}" id="goalInput"
							name="goalInput">
					</div>

				</div>
				<div class="tableRow bigText">

					<div>
						<label for="descriptionInput">description</label>
					</div>
					<div>
						<input type="text" value="${project.description}"
							id="descriptionInput" name="descriptionInput">
					</div>

				</div>
				<input type="hidden" value="${projet.id}" name="id">
				<button class="anchorButton" name="saveAction">enregistrer</button>
			</div>
		</form>
	</c:if>
	<c:if test="${mode=='read'}">


		<div class="horizontalFlexContainer" style="flex-wrap:nowrap">
			<div class="verticalFlexContainer">
				<div class="veryBigText">
					<c:out value="${project.name}"></c:out>
				</div>

				<div>
					<c:out value="${project.description}"></c:out>
				</div>



				<c:url value="oneProject" var="url">
					<c:param name="id" value="${project.id}" />
					<c:param name="action" value="edit" />
				</c:url>
				<div class="horizontalFlexContainer">
					<a class="anchorButton" href="${url}">editer</a>
				</div>
			</div>
			<div class="verticalFlexContainer">
				<div class="bigText">
					<c:out value="${project.goal}"></c:out>
					<span>€</span>
					<meter min="0" max="${project.goal}" value="${project.sumOfGifts}"
						style="width: 100%"></meter>
				</div>

				<form method="post">
					<div class="horizontalFlexContainer">
						<div>
							<input type="number" name="giftAmountInput" id="giftAmountInput">
						</div>
						<input type="hidden" value="${projet.id}" name="id">
						<div>
							<button class="anchorButton" name="giveAction">donner</button>
						</div>
					</div>
				</form>

				<div class="tableContainer">
					<c:forEach items="${project.gifts}" var="gift">
						<div class="tableRow">
							<div>
								<c:out value="${gift.user.firstname}"></c:out>
							</div>
							<div>
								<c:out value="${gift.amount}"></c:out>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
		</div>











	</c:if>

</t:template>