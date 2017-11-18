<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es-PE">

	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Departamento Acad&eacute;mico</title>
	    <tiles:insertAttribute name="resources"/>
	    <script type="text/javascript">
	    	var contextPath = "${pageContext.servletContext.contextPath}";
	    </script>
	</head>
	
	<body>
	<div></div>
		<div id="preloader" class="preloader" style="display:none;"></div>
	   	<div id="status" class="preloader" style="display:none">&nbsp;</div>
	    
		<div class="container">			
			<tiles:insertAttribute name="body" />
		</div>
	</body>
</html>