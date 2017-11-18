<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<section id="main-content">
	<section class="wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <ol class="breadcrumb">
	                <li><i class="fa fa-home"></i><a href="${pageContext.servletContext.contextPath}/principal/inicio">Inicio</a></li>
	                <li><i class="fa fa-laptop"></i><a href="${pageContext.servletContext.contextPath}/principal/inicio">Datos Personales</a></li>
	            </ol>
	        </div>
	    </div>
	    <h1 align="center">Perfil de Usuario</h1>
	    
	    <div class="profile-widget profile-widget-info">
	        <div class="panel-body">
	            <div class="col-lg-2 col-sm-2">
	              <!--  ============================En esta parte cargar el nombre del usuario =================-->
	                <div class="follow-ava">
	                    <img src="${pageContext.servletContext.contextPath}/resources/img/profile-widget-avatar.jpg" alt="">
	                </div>
	                                                   
	            </div>
	            <div class="col-lg-4 col-sm-4 follow-info">
	                <p align="center">BIENVENIDO</p>
	                <h4>
	                    <span>Docente</span><br/>
	                    <span>Luzmila Pro Concepcion</span><br/>
	                    <span>Categoría Principal</span><br/>
	                    <span>Dedicación Exclusiva - 40 Horas</span><br/>
	                </h4>
	            </div>
	        </div>
	    </div>
	    
	    <div class="container">
            <img src="${pageContext.servletContext.contextPath}/resources/img/logoprincipal.png">
            <div class="tituloSis" align="center">Sistema de Registro de Disponibilidad</div>
        </div>
	</section>
	<div class="text-right">
	    <div class="credits">
	    </div>
	</div>
</section>