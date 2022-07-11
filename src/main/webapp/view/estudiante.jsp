<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="head.jsp"%>

<body>
	<div class="container">
		<header>
			<%@ include file="nav.jsp"%>
			<h3>Crear Estudiante</h3>
		</header>
		<main>


			<form action="${pageContext.request.contextPath}/estudiante?op=new" method="post" class="form">
				<div class="mb-3">
					<label for="nombre" class="form-label">Nombre</label> 
					<input type="text" class="form-control" id="nombre" name="nombre"  
						placeholder="Rigoberta">
				</div>
				<div class="mb-3">
					<label for="apellido" class="form-label">Apellido</label> <input
						type="text" class="form-control" id="apellido" name="apellido"
						placeholder="Manchú">
				</div>
				<div class="mb-3">
					<label for="rut" class="form-label">Rut</label> <input type="text"
						class="form-control" id="rut" name="rut" placeholder="11111111-1">
				</div>
				<div class="mb-3">
					<label for="nacimiento" class="form-label">Nacimiento</label> <input
						type="date" class="form-control" id="nacimiento" name="nacimiento">
				</div>
				<div class="mb-3">
					<label for="ingresos" class="form-label">Ingresos</label> <input
						type="number" class="form-control" id="ingresos" name="ingresos">
				</div>
				<div class="mb-3">
					<div>
						<button type="submit" class="btn btn-primary">Enviar</button>
					</div>
					<div>
						<button type="reset" class="btn btn-secondary">Limpiar</button>
					</div>
				</div>


			</form>


		</main>
	</div>



	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>