<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="head.jsp"%>

<body>
	<div class="container">
		<header>
			<%@ include file="nav.jsp"%>
			<h3>Listado de Estudiantes</h3>
			</h4>
		</header>
		<main>
			<div class="row">
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/estudiante?op=new">Nuevo
					Estudiante</a>
			</div>
			<table class="table" id="estudiantes">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Rut</th>
						<th>Nacimiento</th>
						<th>Ingresos</th>
						<th>Acción</th>
					</tr>
				</thead>
				
				<%

					System.out.println("Holanda que talca... ");
				
				%>
				
				<tbody>
					<c:forEach var="estudiante" items="${estudiantes}">
						<tr>
							<th><c:out value="${estudiante.getId()}"></c:out></th>
							<td><c:out value="${estudiante.getNombre()}"></c:out></td>
							<td><c:out value="${estudiante.getApellido()}"></c:out></td>
							<td><c:out value="${estudiante.getRut()}"></c:out></td>
							<td><fmt:formatDate value="${estudiante.getNacimiento()}"></fmt:formatDate>

							</td>
							<td><fmt:formatNumber type="currency" currencySymbol="$"
									maxFractionDigits="0" groupingUsed="true"
									value="${estudiante.getIngresos()}"></fmt:formatNumber></td>
							<td><a
								href="${pageContext.request.contextPath}/estudiante?op=edit&id=${estudiante.getId()}"><i
									class="fa-solid fa-pen-to-square"></i></a> | <a
								href="${pageContext.request.contextPath}/estudiante?op=del&id=${estudiante.getId()}"><i
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
			$('#estudiantes').DataTable();
		});
	</script>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>