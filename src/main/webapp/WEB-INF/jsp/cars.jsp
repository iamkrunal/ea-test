<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>EA Test</title>
		<link href="bootstrap-4.3.1-dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	</head>
	<body>
		<p>${msg}</p>
		<div class="container" style="margin-top:30px;">
		    <div class="row">
		        <div class="col-md-4">
		            <ul class="list-group">
		            	<c:forEach var="makeEntry" items="${makeMap}">
			                <li class="list-group-item">${makeEntry.key}
			                	<c:forEach var="modelEntry" items="${makeEntry.value}">
				                    <ul class="list-group">
				                        <li class="list-group-item">${modelEntry.key}
			                        		<ul class="list-group">
			                        			<c:forEach var="show" items="${modelEntry.value}">
				                        			<li class="list-group-item">${show}</li>
				                        		</c:forEach>
			                        		</ul>
				                        </li>
				                    </ul>
			                    </c:forEach>
			                </li>
		                </c:forEach>
		            </ul>
		        </div>
			</div>
		</div>
	</body>
</html>