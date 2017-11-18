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
		
		<h1 align="center">Gestión de Periodo Académico</h1>
		<br>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label" for="fechaInicio">Periodo</label>
					<select class="form-control">
						<option VALUE="link pagina 1">2018 - I</option>
                        <option VALUE="link pagina 2">2018 - II</option>
					</select>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label" for="fechaInicio">Desde</label>
					<div class="input-group date" data-provide="datepicker">
					    <input type="text" class="form-control" placeholder="dd/mm/aaaa">
					    <div class="input-group-addon">
					        <i class="icon_calendar"></i>
					    </div>
					</div>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label" for="fechaInicio">Hasta</label>
					<div class="input-group date" data-provide="datepicker">
					    <input type="text" class="form-control" placeholder="dd/mm/aaaa">
					    <div class="input-group-addon">
					        <i class="icon_calendar"></i>
					    </div>
					</div>
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
		
		<table class="table table-striped">
	        <thead>
	            <tr>
	                <th>Año</th>
	                <th>Semestre</th>
	                <th>Fecha Apertura</th>
	                <th>Fecha Cierre</th>
	                <th>Editar</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr>
	                <td>Datos</td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	            </tr>
	            <tr>
	                <td>Datos</td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	            </tr>
	            <tr>
	                <td>Datos</td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	            </tr>
	        </tbody>
	    </table>
	</section>
</section>