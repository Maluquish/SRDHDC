/**
 * Componente que permite realizar peticiones de tipo Ajax al servidor.
 * 
 * @param {string}
 *            metodoEnv - Metodo de envio. Puede ser POST o GET.
 * @param {string}
 *            direccionUrl - Url del controlador que gestionara la peticion.
 * @param {string}
 *            jsonString - Objeto en formato Json que contiene los datos de la
 *            peticion.
 * @param {requestCallback}
 *            callback - Nombre de la funcion que se ejecutara al finalizar el
 *            proceso. De indicarse null, se omite su uso.
 */
function consultarAjax(metodoEnv, direccionUrl, jsonString, callback) {
	$.ajax({
		type : metodoEnv,
		data : jsonString,
		async : true,
		url : direccionUrl,
		timeout: 120000,
		contentType : "application/json",
		success : function(respuesta) {
			callback(respuesta);
		},
		error : function(respuesta) {
			if (respuesta.status == "404") {
				$.notify("El recurso solicitado no existe (HTTP: 404).", "error");
			} else if (respuesta.status == "401") {
				$.notify("Acceso no autorizado (HTTP: 401).", "error");
			} else {
				$.notify("(HTTP: " + respuesta.status + ").\n" + respuesta.responseText, "error");
			}
		}
	});
}

/**
 * Obtener todos los valores de los campos del formulario como objeto JSON
 * @returns {String}
 */
$.fn.serializeObject = function(){
    var self = this,
        json = {},
        push_counters = {},
        patterns = {
            "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
            "key":      /[a-zA-Z0-9_]+|(?=\[\])/g,
            "push":     /^$/,
            "fixed":    /^\d+$/,
            "named":    /^[a-zA-Z0-9_]+$/
        };
    this.build = function(base, key, value){
        base[key] = value;
        return base;
    };
    this.push_counter = function(key){
        if(push_counters[key] === undefined){
            push_counters[key] = 0;
        }
        return push_counters[key]++;
    };
    $.each($(this).serializeArray(), function(){
        if(!patterns.validate.test(this.name)){
            return;
        }
        var k,
            keys = this.name.match(patterns.key),
            merge = this.value,
            reverse_key = this.name;
        while((k = keys.pop()) !== undefined){
            reverse_key = reverse_key.replace(new RegExp("\\[" + k + "\\]$"), '');
            if(k.match(patterns.push)){
                merge = self.build([], self.push_counter(reverse_key), merge);
            }
            else if(k.match(patterns.fixed)){
                merge = self.build([], k, merge);
            }
            else if(k.match(patterns.named)){
                merge = self.build({}, k, merge);
            }
        }
        json = $.extend(true, json, merge);
    });
    return json;
};