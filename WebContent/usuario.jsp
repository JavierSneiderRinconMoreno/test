<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" 
   uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicacion de Usuario</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity=" sha384-gg0yROIXCbv3Xipma34MD+dH/1fQ784/j6cY/ITQUOhcWr7×93voR×T2MZwIT" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color : tomato">
			<div>
				<a href="#" class="navbar-brand">Gestion de Usuario</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-list">Usuarios</a></li>
			</ul>		
		
		</nav>	
	
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
			<c:if test="${usuario != null}">
				<from action="update" method="post">
			</c:if>
			
			<c:if test="${usuario == null}">
				<from action="insert" method="post">
			</c:if>
			
			<caption>
				<h2>
					<c:if test="${usuario != null}">
						Editar Usurario
					</c:if>
					<c:if test="${usuario != null}">
						Agregar Nuevo Usuario
					</c:if>
				</h2>
			</caption>

			<c:if test="${usuario != null}">
					<input type="hidden" name="id" value="<: out value="${ usuario.id}"/>" >						
			</c:if>
			
			
			<fielddset class="form-group">
				<label>Nombre de Usuario</label><input type="text" vaue="<c:cout"${usuario.nombre}" class="form-control" name="nombre" required="required">
			</fielddset>
			
			<fielddset class="form-group">
				<label>Email del Usuario</label><input type="text" vaue="<c:cout"${usuario.email}" class="form-control" name="email">
			</fielddset>
			
			<fielddset class="form-group">
				<label>Nombre del Pais</label><input type="text" vaue="<c:cout"${usuario.pais}" class="form-control" name="pais" >
			</fielddset>
			
			<button type="submit" class="btn btn-success">Guardar</button>
			</form>
			</div>		
		</div>
	
	</div>

</body>
</html>