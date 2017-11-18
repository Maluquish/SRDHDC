package pe.unmsm.srdhdc.domain.constantes;

public class ConstantesApp {
	private ConstantesApp() {
		super();
	}

	// CONSTANTES DE CONFIGURACION DEL PROYECTO
	public static final String PAQUETE_DOMINIO = "pe.unmsm.srdhdc";
	public static final String PAQUETE_DOMINIO_CONFIGURACION = PAQUETE_DOMINIO + ".core.config";
	public static final String PAQUETE_DOMINIO_CONTROL_ADVICE = PAQUETE_DOMINIO + ".core.controller";
	public static final String DISPATCHER_SERVLET = "DispatcherServlet";
	public static final String DISPATCHER_MAPPING = "/";
	public static final String MAPPING_FOR_URL_PATTERNS = "/*";
	public static final String RESOURCE_HANDLER = "/**";
	public static final String RESOURCE_LOCATION = "/resources";
	public static final String WEB_INF_TILES_XML = "/WEB-INF/**/tiles.xml";
	public static final String PROPERTY_SOURCE_SPRINGSRV = "classpath:springsrv.properties";
	public static final String PROPERTY_SOURCE_SPRINGSRV_ACTIVE = "classpath:${spring.profiles.active}.configuracion.properties";
	public static final String SESSION_FILTER = "session-filter";
	public static final String SESSION_ID = "sessionId";
	public static final String PAQUETE_DOMINIO_BD_ENTITY = PAQUETE_DOMINIO + ".domain.model";
	public static final String PAQUETE_DOMINIO_BD_REPOSITORY = PAQUETE_DOMINIO + ".bd.repository";
	
	public static final String USUARIO_SESSION = "usuario";
}
