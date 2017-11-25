var ES_EDICION = false;
var listaDocentes;

$(document).ready(function() {
	
	$('#tablaDocentes').DataTable({
		ordering : true,
		info : false,
		bLengthChange : false,
		bFilter : false,
		iDisplayLength : 10,
		columns : [
			{ data : 'dni', orderable : true },
			{ data : 'apellidos', orderable : true, className : "dt-left" },
			{ data : 'nombres', orderable : true, className : "dt-left" },
			{ data : 'dni', orderable : false, className : "dt-left" },
			{ data : 'categoria', orderable : false, className : "dt-left" },
			{ data : 'clase', orderable : false, className : "dt-left" },
			{ data : 'num_horas', orderable : false, className : "dt-left" },
			{ data : 'clase', orderable : false, className : "dt-left" },
			{
				data : 'clase', 
				orderable : false, 
				className : "dt-left",
				render: function (data, type, row, meta) {
					return '<button onclick="editarDocente(' + row.dni + ')" class="btn btn-primary btn-xs" type="button"><i class="icon_pencil"></i></button> ' + 
						'<button onclick="eliminarDocente(' + row.dni + ')" class="btn btn-danger btn-xs" type="button"><i class="icon_close"></i></button>';
				}
			}
		]
	});
	
	$('#btnBuscar').click(function() {
		obtenerListaDocentes();
	});
	
	$('#btnRegistrar').click(function() {
		registrarDocente();
	});
	
	$('#btnCancelar').click(function() {
		limpiarFormulario();
	});
});

function obtenerListaDocentes() {
	var request = {
			nombres : $('#txtNombresApellidos').val()
	};
	consultarAjax("POST", contextPath + "/gestion-docentes/lista", JSON.stringify(request), function(respuesta) {
		var tablaDocentes = $('#tablaDocentes').DataTable();
		tablaDocentes.clear().rows.add(respuesta).draw();
		listaDocentes = respuesta;
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
			departamento : $('#cmbDepartamento').val(),
			dni : $('#txtDni').val(),
			esEdicion : ES_EDICION
	};
	consultarAjax("POST", contextPath + "/gestion-docentes/registrar-docente", JSON.stringify(request), function(respuesta) {
		obtenerListaDocentes();
		limpiarFormulario();
	});
}

function eliminarDocente(numeroDni) {
	if (confirm("Esta seguro de eliminar al docente?")) {
		consultarAjax("DELETE", contextPath + "/gestion-docentes/eliminar-docente/" + numeroDni, null, function(respuesta) {
			obtenerListaDocentes();
		});
	}
}

function editarDocente(numeroDni) {
	for (var i = 0; i < listaDocentes.length; i++) {
		if (listaDocentes[i].dni == numeroDni) {
			ES_EDICION = true;
			$('#txtDni').prop('disabled', true);
			
			$('#txtNombres').val(listaDocentes[i].nombres);
			$('#txtApellidos').val(listaDocentes[i].apellidos);
			$('#txtCorreo').val(listaDocentes[i].correo);
			$('#numHoras').val(listaDocentes[i].num_horas);
			$('#txtDni').val(listaDocentes[i].dni);
		}
	}
}

function limpiarFormulario() {
	$('#txtNombres').val('');
	$('#txtApellidos').val('');
	$('#txtCorreo').val('');
	$('#numHoras').val('');
	$('#txtDni').val('');
	ES_EDICION = false;
	$('#txtDni').prop('disabled', false);
}