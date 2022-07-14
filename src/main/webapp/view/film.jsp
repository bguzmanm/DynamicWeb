<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="head.jsp"%>

<body>
	<div class="container">
		<header>
			<%@ include file="nav.jsp"%>
			<c:if test="${op == 'new'}">
				<h3>Crear Película</h3>
			</c:if>
			<c:if test="${op == 'edit'}">
				<h3>Editar Película</h3>
			</c:if>
			
		</header>
		<main>
			
				<form action="${pageContext.request.contextPath}/films?op=${op}" method="post" class="form">
			
				<input type="hidden" id="film_id" name="film_id" value="${film.getFilm_id()}">
			
				<div class="mb-3">
					<label for="title" class="form-label">Titulo</label> 
					<input type="text" class="form-control" id="title" name="title"  
						placeholder="Rocky VIII" value="${film.getTitle()}">
				</div>
				<div class="mb-3">
					<label for="description" class="form-label">Descripción</label> 
					<input type="text" class="form-control" id="description" name="description"
						value="${film.getDescription()}">
				</div>
				<div class="mb-3">
					<label for="release_year" class="form-label">Lanzamiento</label> 
					<input type="number" class="form-control" id="rutrelease_year" name="release_year" 
					value="${film.getRelease_year()}">
				</div>
				<div class="mb-3">
					<label for="rating" class="form-label">Zensura</label> 
					<input type="text" class="form-control" id="rating" name="rating" value="${film.getRating()}">
				</div>
				<div class="mb-3">
					<label for="special_features" class="form-label">Características</label> 
					<input type="text" class="form-control" id="special_features" name="special_features" value="${film.getSpecial_features()}">
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