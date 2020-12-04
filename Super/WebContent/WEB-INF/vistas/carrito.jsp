<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/cabecera.jsp"%>
<h1>Carrito</h1>
<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<th>${producto.value.id}</th>
				<th>${producto.value.desc}</th>
				<th>${producto.value.precio}</th>
				<th>${producto.value.cantidad}</th>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="include/pie.jsp"%>