$(document).ready(function() {
	$('#btnBuscar').click(function() {
		obtenerListaDocentesSinDisponibilidad();
	});
	
	$('#tablaNotificaciones').DataTable({
		ordering : true,
		info : false,
		bLengthChange : false,
		bFilter : false,
		iDisplayLength : 10,
		columns : [
			{ data : 'dni', orderable : true },
			{
				data : 'apellidos', 
				orderable : true, 
				className : "dt-left",
				render: function (data, type, row, meta) {
					return row.apellidos + ' ' + row.nombres;
				}
			},
			{
				data : 'dni', 
				orderable : true, 
				className : "dt-left",
				render: function (data, type, row, meta) {
					return '<button onclick="notificarDocente(' + row.dni + ')" class="btn btn-info btn-xs" type="button"><i class="icon_mail"></i></button> ';
				}
			},
			{
				data : 'clase', 
				orderable : false, 
				className : "dt-left",
				render: function (data, type, row, meta) {
					return '<button onclick="registrarDisponibilidad(' + row.dni + ')" class="btn btn-primary btn-xs" type="button"><i class="icon_pencil"></i></button> ';
				}
			}
		]
	});
});

function obtenerListaDocentesSinDisponibilidad() {
	var request = {
			nombres : $('#txtNombres').val()
	};
	consultarAjax("POST", contextPath + "/notificacion/lista-docentes-sin-disponibilidad", JSON.stringify(request), function(respuesta) {
		var tablaDocentes = $('#tablaNotificaciones').DataTable();
		tablaDocentes.clear().rows.add(respuesta).draw();
	});
}

function notificarDocente(dni) {
	consultarAjax("GET", contextPath + "/notificacion/notificar/" + dni, null, function(respuesta) {
		alert("Se ha enviado un correo electronico al docente");
		var tablaDocentes = $('#tablaNotificaciones').DataTable();
		tablaDocentes.clear().rows.add(respuesta).draw();
	});
}