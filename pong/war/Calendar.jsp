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
<title>Calendar</title>
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
							class="glyphicon glyphicon-arrow-down white"></span> MENU
					</button>
					<a class="navbar-brand" href="controller?action=logout"><span
						class="glyphicon glyphicon-cutlery"></span> PONG</a>
				</div>
				<div class="collapse navbar-collapse" id="collapse">
					<ul class="nav navbar-nav">
						<li><a href="controller?action=dayView">My Menus</a></li>
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
				<a href="controller?action=previousMonth"><button type="button"
						class="btn btn-primary">
						<span class="glyphicon glyphicon-menu-left"></span>
					</button></a>
				<div class="btn-group">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">
						<span class="glyphicon glyphicon-calendar"></span>
						<c:out value="${month}"></c:out>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="controller?action=dayView">Day</a></li>
						<li><a href="#">Month</a></li>
					</ul>
				</div>
				<a href="controller?action=nextMonth"><button type="button"
						class="btn btn-primary">
						<span class="glyphicon glyphicon-menu-right"></span>
					</button></a>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<!-- <table class="fill table table-hover"> -->
				<table class="fill table table-hover">
					<thead class="head">
						<tr>
							<th>Sun</th>
							<th>Mon</th>
							<th>Tue</th>
							<th>Wed</th>
							<th>Thu</th>
							<th>Fri</th>
							<th>Sat</th>
						</tr>
					<thead>
					<tbody>
						<tr class="month-height">
							<c:forEach var="meals" items="${monthlySchedule}"
								varStatus="loop">
								<c:if test="${not loop.first and loop.index % 7 == 0 }">
						</tr>
						<tr>
							</c:if>
							<c:if test="${loop.index < offset}">
								<td></td>
							</c:if>
							<c:if test="${loop.index >= offset}">
								<td><c:out value="${loop.index - (offset-1)}"></c:out><a
									href="controller?action=selectDay&day=${loop.index - (offset-1)}"><span
										class="${meals.icon}"></span></a></td>
							</c:if>
							</c:forEach>
						</tr>
					</tbody>
				</table>
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