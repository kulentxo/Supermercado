<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/" />
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- FontAwesome -->
<link rel="stylesheet" type="text/css" href="css/all.min.css">
<title>Supermercado</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
  <a class="navbar-brand" href="#">Supermercado</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Productos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="carrito">Ver carrito</a>
      </li>
    </ul>
	  <ul class="navbar-nav">
	  	
	  	<c:choose>
	  		<c:when test="${sessionScope.usuario == null}">
	  			<li class="nav-item">
	  				<a class="nav-link" href="login">Login</a>
	  			</li>
	  		</c:when>
	  		<c:otherwise>
	  			<li class="nav-item">
	  				<a class="navbar-text">${usuario.email }</a>
	  			</li>
	  			<li class="nav-item">
	  				<a class="nav-link" href="logout">Cerrar sesion</a>
	  			</li>
	  		</c:otherwise>
	  	</c:choose>
		
	  </ul>
  </div>
</nav>
<main class="container-fluid pt-3">