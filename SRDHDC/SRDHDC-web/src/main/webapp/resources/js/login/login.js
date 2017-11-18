$(document).ready(function() {
	$('#btnAceptar').click(function() {
		var request = JSON.stringify($('#formLogin').serializeObject());
		consultarAjax("POST", contextPath + "/login/validar", request, function(respuesta) {
			location.href = contextPath + "/principal/inicio";
		});
	});
});