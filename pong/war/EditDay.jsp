<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<title>Edit Day</title>
</head>
<body class="body">
	<div class="container">
		<div class="navbar navbar-default navbar-inverse navbar-fixed-top"
			role="navigation">
			<div class="container-fluid navbar-white">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#collapse">
						<span class="sr-only">Toggle Navigation</span> <span
							class="glyphicon glyphicon-arrow-down"></span> MENU
					</button>
					<a class="navbar-brand" href="controller?action=logout"><span
						class="glyphicon glyphicon-cutlery"></span> PONG</a>
				</div>
				<div class="collapse navbar-collapse" id="collapse">
					<ul class="nav navbar-nav">
						<li><a href="controller?action=dayView">My Menus</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Edit<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="controller?action=replace">Replace Menu</a></li>
								<li><a href="controller?action=copy">Copy Menu</a></li>
								<li><a href="controller?action=delete">Delete Menu</a></li>
								<li><a href="controller?action=paste">Paste Menu</a></li>
							</ul></li>
						<li><a href="#">My Archive (tbd)</a></li>
						<li><a href="#">Instructions (tbd)</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-print"></span>
								Print Menu (tbd)</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">My Profile <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#" data-toggle="modal"
									data-target="#nutrition-targets">Personal Nutrition Targets</a></li>
								<li><a href="#">Account Information (tbd)</a></li>
								<li><a href="#">Edit Profile (tbd)</a></li>
							</ul></li>
						<li><a href="controller?action=logout">Logout</a></li>
					</ul>
					<div class="modal fade black" id="nutrition-targets" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Nutrition
										Targets</h4>
								</div>
								<div class="modal-body">
									<c:forEach var="userItem" items="${userInfo}">
										<h6>
											<c:out value="${userItem.label}"></c:out>
											= <strong><c:out value="${userItem.targetValue}"></c:out>
												<c:out value="${userItem.units}"></c:out></strong>
										</h6>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="text-center calendar-group">
				<div class="btn-group">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">
						<span class="glyphicon glyphicon-calendar"></span>
						<c:out value="${date}"></c:out>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="controller?action=dayView">Day</a></li>
						<li><a href="controller?action=calendar">Month</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Breakfast panel -->
			<div class="col-md-4">
				<div class="${meal.icon}" id="accordian">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordian" href="#b-one"
								aria-expanded="true" aria-controls="b-one"> Breakfast and
								Snacks </a>
						</h3>
					</div>
					<div id="b-one" class="panel-collapse collapse in" role="tabpanel"
						aria-labelledby="b-one">
						<div class="panel-body">
							<div class="list-group">
								<c:forEach var="breakfastItem" items="${breakfast}"
									varStatus="loop">
									<a href="#" class="list-group-item" data-toggle="modal"
										data-target="#b${loop.index}"><c:out
											value="${breakfastItem.item}"></c:out></a>
								</c:forEach>
							</div>
							<c:forEach var="breakfastItem" items="${breakfast}"
								varStatus="loop">
								<div class="modal fade" id="b${loop.index}" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-sm">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">Editing Options</h4>
											</div>
											<div class="modal-body text-center">
												<div class="list-group">
													<a href="#" class="list-group-item list-group-item-info">Delete (tbd)</a>
													<a href="#" class="list-group-item">Add New Item (tbd)</a> <a
														href="#" class="list-group-item list-group-item-info">Replace (tbd)</a>
													<a href="#" class="list-group-item">Select Larger
														Portion (tbd)</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!-- Lunch panel -->
			<div class="col-md-4">
				<div class="${meal.icon}" id="accordian">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordian" href="#l-one"
								aria-expanded="true" aria-controls="l-one">Lunch and Snacks</a>
						</h3>
					</div>
					<div id="l-one" class="panel-collapse collapse in" role="tabpanel"
						aria-labelledby="l-one">
						<div class="panel-body">
							<div class="list-group">
								<c:forEach var="lunch" items="${lunch}">
									<a href="#" class="list-group-item" data-toggle="modal"
										data-target="${lunch.item}"><c:out value="${lunch.item}"></c:out></a>
								</c:forEach>
							</div>
							<c:forEach var="lunch" items="${lunch}">
								<div class="modal fade" id="${lunch.item}" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-sm">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">Editing Options</h4>
											</div>
											<div class="modal-body text-center">
												<div class="list-group">
													<a href="#" class="list-group-item list-group-item-info">Delete (tbd)</a>
													<a href="#" class="list-group-item">Add New Item (tbd)</a> <a
														href="#" class="list-group-item list-group-item-info">Replace (tbd)</a>
													<a href="#" class="list-group-item">Select Larger
														Portion (tbd)</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!--Dinner panel -->
			<div class="col-md-4">
				<div class="${meal.icon}" id="accordian">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordian" href="#d-one"
								aria-expanded="true" aria-controls="d-one">Dinner and Snacks</a>
						</h3>
					</div>
					<div id="d-one" class="panel-collapse collapse in" role="tabpanel"
						aria-labelledby="d-one">
						<div class="panel-body">
							<div class="list-group">
								<c:forEach var="dinner" items="${dinner}">
									<a href="#" class="list-group-item" data-toggle="modal"
										data-target="${dinner.item}"><c:out value="${dinner.item}"></c:out></a>
								</c:forEach>
							</div>
							<c:forEach var="dinner" items="${dinner}">
								<div class="modal fade" id="${dinner.item}" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-sm">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">Editing Options</h4>
											</div>
											<div class="modal-body text-center">
												<a href="#" class="list-group-item list-group-item-info">Delete (tbd)</a>
												<a href="#" class="list-group-item">Add New Item (tbd)</a> <a
													href="#" class="list-group-item list-group-item-info">Replace (tbd)</a>
												<a href="#" class="list-group-item">Select Larger
													Portion (tbd)</a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer class="row">
		<p>
			<small>Copyright &copy; 2015 Martin Kohlmeier Nutrigen</small>
		</p>
		</footer>
	</div>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>