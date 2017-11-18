package pe.unmsm.srdhdc.domain.exception;

public class ExcepcionGeneral extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExcepcionGeneral(){
		super();
	}
	
	public ExcepcionGeneral(String message){
		super(message);
	}
}
