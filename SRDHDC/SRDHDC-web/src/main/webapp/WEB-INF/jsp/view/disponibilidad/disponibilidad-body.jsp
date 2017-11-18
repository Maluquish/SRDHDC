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
		
		<h1 align="center">Dipsonibilidad Horaria</h1>
		<br>
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label" for="fechaInicio">Disponibilidad Horaria</label>
					<select class="form-control">
						<option VALUE="link pagina 1">2016 - cerrado</option>
                        <option VALUE="link pagina 2">2017 - cerrado</option>
                        <option VALUE="link pagina 1">2018 - abierto</option>
					</select>
				</div>
			</div>
			
			<div class="col-md-3">
				<div class="form-group">
					<label class="col-form-label" for="fechaInicio">Docentes que registraron su disponibilidad horaria</label>
					<input type="text" class="form-control" placeholder="Apellidos/Nombres">
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
                    <th>Código</th>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>Día</th>
                    <th>Hora de Inicio</th>
                    <th>Hora Fin</th>
                    <th>Número de Horas</th>
                    <th>Año</th>
                    <th>Periodo</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Código</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Código</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Código</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        <br/> 
        <hr color="black" size=1 width="100%">
        <h2>Total de Docentes</h2>
        <progress value="70" max="100">70 %</progress>  
	</section>
</section>