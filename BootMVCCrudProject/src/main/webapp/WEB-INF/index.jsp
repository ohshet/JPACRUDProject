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
						<option value="Title">Title</option>
						<option value="Character">Character</option>
						<option value="Text">Text</option>
						<option value="ID">ID</option>
					</select> <br> <br> <input type="text" name="searchstring"
						style='width: 85%' /> <input type="submit" value="Go" />
				</form>
				<c:if test="${not empty searchstatus}">
					<div>${searchstatus}</div>
				</c:if>
			</div>
			<div class="col">
				<h3>Search Results</h3>
				<form action="geturl.do" method="GET">
					<select id="searchresults" name="searchresults" size="8"
						style='width: 90%'>
						<c:if test="${not empty meatlist}">
							<c:forEach var="redmeat" items="${meatlist}">
								<option>${redmeat.title}</option>
							</c:forEach>
						</c:if>
					</select> <input type="submit" value="Show" />
				</form>
			</div>
			<div class="col">
				<h3>Add/Delete/Modify</h3>
				<form action="crud.do" method="POST">
					Title: <br> <input type="title" name="title" value="${title}"
						style='width: 95%' /><br> Characters: <br> <input
						type="characters" name="characters" value="${characters}"
						style='width: 95%' /><br> Text: <br> <input type="text"
						name="text" value="${text}" style='width: 95%' /> <br> URL:<input
						type="imgurl" name="imgurl" value="${imgurl}" style='width: 95%' />
					<input type="hidden" name="id" value="${id}" /> <br> <select
						id="crud" name="crud">
						<option value=modify>Modify This Record</option>
						<option value=delete>Delete This Record</option>
						<option value=add>Add Fresh Meat!</option>
					</select> <input type="submit" value="Go" />
				</form>
				<c:if test="${not empty status}">
					<div>${status}</div>
				</c:if>
			</div>
		</div>
	</div>
	<div class="container">
		<c:if test="${not empty imgurl}">
			<img src="${imgurl}" alt="Red Meat" width="90%" class="center">
		</c:if>
	</div>



	<jsp:include page="bootstrapFoot.jsp" />
</body>
</html>


