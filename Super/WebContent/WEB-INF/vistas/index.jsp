<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/cabecera.jsp"%>
<h1>Listado de productos</h1>
<form action="AgregarCarrito" method="get">
	<button class="btn btn-primary btn-block mb-3">Agregar todos las cantidades a carrito</button>
	<div class="row ml-0">
	<c:forEach items="${producto}" var="producto">
	  <div class="col-12 col-sm-6 col-md-4 col-lg-3 col-xl-2 px-0">
	    <div class="card rounded-0 h-100">
	    <img src="http://placeimg.com/640/480/tech?1" class="card-img-top rounded-0" alt="imagen">
	      <div class="card-body">
	      <c:if test="${producto.oferta != 0}">
	      <p class="bg-danger text-white w-50 text-center px-2 rounded-0 font-weight-bold">OFERTA TOP</p>
	      </c:if>
	        <h5 class="card-title">${producto.precio }€</h5>
	        <c:if test="${producto.oferta != 0}">
	        	<p class="card-text">${producto.oferta }%</p>
	        </c:if>
	        <p class="card-text">${producto.desc }</p>
	        <p class="card-text">
							<div class="input-group mx-auto" style="width: 9rem">
								<div class="input-group-prepend">
									<button class="btn btn-secondary btn-menos" type="button">
										<i class="fas fa-minus"></i>
									</button>
								</div>
								<input type="number"
									class="form-control text-center font-weight-bold" placeholder=""
									aria-label="Cantidad" value="0" name="${producto.id}"
									min="0" />
								<div class="input-group-append">
									<button class="btn btn-secondary btn-mas" type="button">
										<i class="fas fa-plus"></i>
									</button>
								</div>
							</div>
						</p>
	      </div>
	      <a href="#" class="btn btn-block btn-primary align-self-center mb-2 w-50">Añadir a la cesta</a>
	    </div>
	  </div>
	</c:forEach>
	</div>
</form>
<%@ include file="include/pie.jsp"%>