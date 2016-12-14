<%@ tag language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/main.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div class="horizontalFlexContainer" id="mainContainer">
		<div class="menuContainer">
			<div>
				<img class="logo" alt=""
					src="https://upload.wikimedia.org/wikipedia/commons/f/f5/Geefunding_crowdfunding.png" />
			</div>
			<a class="clearLink" href="./CrowdFundingListController">
				<div class=buttonMenu>tous les projets</div>
			</a>
		</div>
		<div class="generalContainer verticaleFlexContainer">
			<jsp:doBody />
		</div>
		<div class="asideContainer"></div>
	</div>

</body>
</html>