<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<section id="main-content">
	<section class="wrapper">
		<div class="row">
		    <div class="col-lg-12">
		        <ol class="breadcrumb">
		            <li><i class="fa fa-home"></i><a href="${pageContext.servletContext.contextPath}/principal/inicio">Inicio</a></li>
		        </ol>
		    </div>
		</div>
		
		<h1 align="center">Regisro de Historial</h1>
		<br>
		
		<div class="row">
			
			<div class="col-md-3">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Apellidos/Nombres">
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<button id="btnBuscar" class="btn btn-primary" type="button">
						<i class="icon_search"></i> Buscar
					</button>
				</div>
			</div>
		</div>
	</section>
</section>