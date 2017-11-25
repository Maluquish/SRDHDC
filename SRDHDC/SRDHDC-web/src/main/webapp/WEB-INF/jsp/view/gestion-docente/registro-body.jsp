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
		
		<h1 align="center">Gestionar registro de docentes</h1>
		
		<h2>Regitrar docente</h2>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<input id="txtNombres" type="text" class="form-control" placeholder="Nombres">
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<input id=txtApellidos type="text" class="form-control" placeholder="Apellidos">
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<input id="txtCorreo" type="text" class="form-control" placeholder="Correo@unmsm.edu.pe">
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<input id="numHoras" type="number" class="form-control" placeholder="Número de horas">
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label">Condici&oacute;n</label>
					<select id="cmbCondicion" class="form-control">
						<OPTION VALUE="Nombrado">Nombrado</OPTION>
						<OPTION VALUE="Contratado">Contratado</OPTION>
					</select>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label">Clase</label>
					<select id="cmbClase" class="form-control">
						<OPTION VALUE="Principal">Principal</OPTION>
                        <OPTION VALUE="Asociado">Asociado</OPTION>
                        <OPTION VALUE="Auxiliar">Auxiliar</OPTION>
                        <OPTION VALUE="Jefe de Prácticas">Jefe de Prácticas</OPTION>
					</select>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label">Categor&iacute;a</label>
					<select id="cmbCategoria" class="form-control">
						<OPTION VALUE="Tiempo Completo">Tiempo Completo</OPTION>
                        <OPTION VALUE="Tiempo Parcial">Tiempo Parcial</OPTION>
                        <OPTION VALUE="Dedicación Exclusiva">Dedicación Exclusiva</OPTION>
					</select>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label">Departamento</label>
					<select id="cmbDepartamento" class="form-control">
						<OPTION VALUE="01">Ciencias de la Computación</OPTION>
                     	<OPTION VALUE="02">Ingeniería de Software</OPTION>
					</select>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label">DNI</label>
					<input id="txtDni" type="text" class="form-control" placeholder="Documento nacional de indentidad">
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label">&nbsp;</label>
					<div>
						<button id="btnRegistrar" class="btn btn-primary" type="button">
							<i class="icon_plus_alt"></i> Registrar
						</button>
						
						<button id="btnCancelar" class="btn btn-primary" type="button">
							<i class="icon_close_alt"></i> Cancelar
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<hr color="black" size=1 width="100%">
		
		<h2>Lista de docentes registrados</h2>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<input id="txtNombresApellidos" type="text" class="form-control" placeholder="Apellidos/Nombres">
				</div>
			</div>
			
			<div class="col-md-3">
				<button id="btnBuscar" class="btn btn-primary" type="button">
					<i class="icon_search"></i> Buscar
				</button>
			</div>
		</div>
		
        <table id="tablaDocentes" class="table table-striped">
            <thead>
                <tr>
                    <th>C&oacute;digo</th>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>Condici&oacute;n</th>
                    <th>Categor&iacute;a</th>
                    <th>Horas</th>
                    <th>Departamento</th>
                    <th>Cursos</th>
                    <th>Editar</th>
                </tr>
            </thead>
        </table>
	</section>
</section>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/gestion-docentes/registro.js"></script>