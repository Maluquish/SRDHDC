<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es-PE">

	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Unidad: Departamento Acad&eacute;mico de Ciencias de la Computaci&oacute;n</title>
	    <tiles:insertAttribute name="resources"/>
	    
	    <link href="${pageContext.servletContext.contextPath}/resources/css/elegant-icons-style.css" rel="stylesheet" />
        <link href="${pageContext.servletContext.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" />
        <link href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
        
        <!-- easy pie chart-->
        <link href="${pageContext.servletContext.contextPath}/resources/css/style_bs.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/resources/css/style-responsive.css" rel="stylesheet" />
	    
	    <script type="text/javascript">
	    	var contextPath = "${pageContext.servletContext.contextPath}";
	    </script>
	</head>
	
	<body>
	<div></div>
		<div id="preloader" class="preloader" style="display:none;"></div>
	   	<div id="status" class="preloader" style="display:none">&nbsp;</div>
	   	
   		<header class="header dark-bg">
			<div class="toggle-nav">
				<div class="icon-reorder tooltips" data-placement="bottom"><i class="icon_menu"></i></div>
			</div>

			<!--logo start-->
			<a href="#" class="logo">SISTEMA DE REGISTRO DE DISPONIBILIDAD HORARIA DE DOCENTES Y CURSOS</a>
			<!--logo end-->
               
            <div class="top-nav notification-row">
                <ul class="nav pull-right top-menu">
                    <!-- -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="username">${usuario.nombres} ${usuario.apellidos}</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <li class="eborder-top">
                                <a href="#"><i class="icon_profile"></i> Mi Perfil</a>
                            </li>
                            <li>
                                <a href="${pageContext.servletContext.contextPath}/login/logout"><i class="icon_key_alt"></i> Cerrar Sesion</a>
                            </li>
                            <li>
                            </li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->
                </ul>
                <!-- notificatoin dropdown end-->
            </div>
		</header>
		
		<!--Comienzo de la barra de navegacion -->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu">
	                <li class="sub-menu">
	                    <a href="javascript:;" class="">
	                        <i class="icon_house_alt"></i>
	                        <span>Gestionar Docentes</span>
	                        <span class="menu-arrow arrow_carrot-right"></span>
	                    </a>
	                    <ul class="sub">
	                        <li><a href="${pageContext.servletContext.contextPath}/gestion-docentes/registro">Registro de Docente</a></li>
	                        <li><a href="${pageContext.servletContext.contextPath}/gestion-docentes/historial">Historial Docente</a></li>
	                    </ul>
	                </li>
	                <li class="sub-menu">
	                    <a href="javascript:;" class="">
	                        <i class="icon_document_alt"></i>
	                        <span>Disponibilidad</span>
	                        <span class="menu-arrow arrow_carrot-right"></span>
	                    </a>
	                    <ul class="sub">
	                        <li><a class="" href="${pageContext.servletContext.contextPath}/disponibildad/inicio">Ver Disponibilidad</a></li>
	                    </ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;" class="">
                            <i class="icon_document_alt"></i>
                            <span>Notificar</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="" href="${pageContext.servletContext.contextPath}/notificacion/inicio">Notificar Docentes</a></li>
                        </ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;" class="">
							<i class="icon_document_alt"></i>
							<span>Mantenimiento</span>
							<span class="menu-arrow arrow_carrot-right"></span>
						</a>
						<ul class="sub">
							<li><a class="" href="${pageContext.servletContext.contextPath}/mantenimiento/cuentas-usuario">Gestionar Cuentas de Usuario</a></li>
							<li><a class="" href="${pageContext.servletContext.contextPath}/mantenimiento/periodo-academico">Gestion de Periodo Académico</a></li>
						</ul>
					</li>
					<li class="sub-menu">
						<a href="javascript:;" class="">
							<i class="icon_table"></i>
							<span>Cerrar Sesion</span>
							<span class="menu-arrow arrow_carrot-right"></span>
						</a>
						<ul class="sub">
							<li><a href="${pageContext.servletContext.contextPath}/login/logout"><i class="icon_key_alt"></i>Salir</a></li>
						</ul>
					</li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--======Fin de la barra de navegacion============================================================================= -->
	    
		<div class="container-fluid">
            	
			<tiles:insertAttribute name="body"/>
		</div>
	</body>
</html>