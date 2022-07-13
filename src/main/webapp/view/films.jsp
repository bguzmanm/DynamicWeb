<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="head.jsp"%>

<body>
	<div class="container">
		<header>
			<%@ include file="nav.jsp"%>
			<h3>Listado de Películas</h3>
			</h4>
		</header>
		<main>
			<div class="row">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/films?op=new">Nueva
					Película</a>
			</div>
			<table class="table" id="films">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Titulo</th>
						<th>Descripción</th>
						<th>Lanzamiento</th>
						<th>Censura</th>
						<th>Especiales</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="f" items="${films}">
						<tr>
							<th><c:out value="${f.getFilm_id()}"></c:out></th>
							<td><c:out value="${f.getTitle()}"></c:out></td>
							<td><c:out value="${f.getDescription()}"></c:out></td>
							<td><c:out value="${f.getRelease_year()}"></c:out></td>
							<td><c:out value="${f.getRating()}"></c:out></td>
							<td><c:out value="${f.getSpecial_features()}"></c:out></td>
							
							<td><a
								href="${pageContext.request.contextPath}/estudiante?op=edit&id=${f.getFilm_id()}"><i
									class="fa-solid fa-pen-to-square"></i></a> | <a
								href="${pageContext.request.contextPath}/estudiante?op=del&id=${f.getFilm_id()}"><i
									class="fa-solid fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</main>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>

	<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
		rel="stylesheet" />
	<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#films').DataTable();
		});
	</script>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>