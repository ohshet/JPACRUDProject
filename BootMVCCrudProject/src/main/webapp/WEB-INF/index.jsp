<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="bootstrapHead.jsp" />


<meta charset="UTF-8">
<title>RedMeat Comics Database</title>
</head>
<body>
	<div class="container">

		<h1>Red Meat Database</h1>
		<div class="row">
			<div class="col">
				<h3>Search for Red Meat!</h3>
				<h4>Search by:</h4>
				<form action="search.do" method="GET">
					<select id="searchby" name="searchby">
						<option value="ID">ID</option>
						<option value="Title">Title</option>
						<option value="Character">Character</option>
						<option value="Text">Text</option>
					</select> <input type="text" name="searchstring" style='width: 85%' /> <input
						type="submit" value="Go" />
				</form>
			</div>
			<div class="col">
				<h3>Search Results</h3>
				<form action="geturl.do" method="GET">>
				<select id="searchresults" name="searchresults" size="4" style='width: 90%'>
					<c:if test="${not empty meatlist}">
									<c:forEach var="redmeat" items="${meatlist}">
								<option>${redmeat.title}</option>
							</c:forEach>
					</c:if>
				</select>
				<input type="submit" value="Show" />
				</form>
			</div>
			<div class="col">
				<h3>Add/Delete/Modify</h3>
				<form>
					<input type="submit" value="Add fresh meat" />
				</form>

				<form>
					<input type="submit" value="Modify this comic" />
				</form>

				<form>
					<input type="submit" value="Delete this comic" />
				</form>
			</div>
		</div>
	</div>
	<div class="container">
	<c:if test="${not empty imgurl}">
		<img
			src="${imgurl}"
			alt="Red Meat" width="90%" class="center">
			</c:if>
	</div>



	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>


