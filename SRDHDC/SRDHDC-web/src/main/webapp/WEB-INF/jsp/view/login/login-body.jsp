<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/style.css">

<div class="row justify-content-center">
	<img src="${pageContext.servletContext.contextPath}/resources/img/logo.png">
	
	<div class="col-md-12">
		<div class="tituloSis">Sistema de Registro de Disponibilidad</div>
		<form id="formLogin" onsubmit="return false">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="form-group">
						<input name="usuario" type="text" class="form-control" placeholder="Usuario" required />
					</div>
					<div class="form-group">
						<input name="password" type="password" class="form-control" placeholder="Contraseña" required />
					</div>
					<div class="text-center">
						<button id="btnAceptar" class="btn btn-primary btn-enviar" type="button">
							<span class="oi oi-circle-check"></span> Aceptar
						</button>
					</div>
					<a href="#">¿Olvidó su Clave?</a>
				</div>
				<div class="col-md-3"></div>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/login/login.js"></script>