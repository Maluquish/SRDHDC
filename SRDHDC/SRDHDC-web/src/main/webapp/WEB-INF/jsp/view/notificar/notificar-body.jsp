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
	    <h1 align="center">Notificar a Docentes</h1>
	    
	    <div class="row">
		    <div class="col-md-4">
				<div class="form-group">
					<label class="col-form-label">Docentes que aun no registran su disponibilidad horaria</label>
					<input id="txtNombres" type="text" class="form-control" placeholder="Apellidos/Nombres">
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label">&nbsp;</label>
					<div>					
						<button id="btnBuscar" class="btn btn-primary" type="button">
							<i class="icon_search"></i> Buscar
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<hr color="black" size=1 width="100%">
		
		<h2>Notificar a todos <button id="btnNotificarTodos" class="btn btn-info"><i class="icon_mail"></i></button></h2>
		
		<table id="tablaNotificaciones" class="table table-striped">
            <thead>
                <tr>
                    <th>C&oacute;digo</th>
                    <th>Apellidos y nombres</th>
                    <th>Notificar</th>
                    <th>Registrar</th>
                </tr>
            </thead>
        </table>
	    
	</section>
</section>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/notificar/notificar.js"></script>