$(document).ready(function() {
	
	$('#tablaDocentes').DataTable({
		ordering : true,
		info : false,
		bLengthChange : false,
		bFilter : false,
		iDisplayLength : 10,
		columns : [
			{ data : 'dni', orderable : true },
			{ data : 'apellidos', orderable : false, className : "dt-left" },
			{ data : 'nombres', orderable : false, className : "dt-left" },
			{ data : 'dni', orderable : false, className : "dt-left" },
			{ data : 'categoria', orderable : false, className : "dt-left" },
			{ data : 'clase', orderable : false, className : "dt-left" },
			{ data : 'num_horas', orderable : false, className : "dt-left" },
			{ data : 'clase', orderable : false, className : "dt-left" },
			{ data : 'clase', orderable : false, className : "dt-left" }
		]
	});
	
	$('#btnBuscar').click(function() {
		obtenerListaDocentes();
	});
	
	$('#btnRegistrar').click(function() {
		registrarDocente();
	});
});

function obtenerListaDocentes() {
	var request = {
			nombres : $('#txtNombresApellidos').val()
	};
	consultarAjax("POST", contextPath + "/gestion-docentes/lista", JSON.stringify(request), function(respuesta) {
		var tablaDocentes = $('#tablaDocentes').DataTable();
		tablaDocentes.clear().rows.add(respuesta).draw();
	});
}

function registrarDocente() {
	var request = {
			nombres : $('#txtNombres').val(),
			apellidos : $('#txtApellidos').val(),
			correo : $('#txtCorreo').val(),
			num_horas : $('#numHoras').val(),
			condicion : $('#cmbCondicion').val(),
			clase : $('#cmbClase').val(),
			categoria : $('#cmbCategoria').val(),
			departamento : $('#cmbDepartamento').val()
	};
	consultarAjax("POST", contextPath + "/gestion-docentes/registrar-docente", JSON.stringify(request), function(respuesta) {
		obtenerListaDocentes();
	});
}