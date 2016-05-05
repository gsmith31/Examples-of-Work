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
		<div class="text-center">
			<a href="controller?action=chooseday">
				<button type="button" class="btn btn-primary">Choose Menu</button>
			</a>
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