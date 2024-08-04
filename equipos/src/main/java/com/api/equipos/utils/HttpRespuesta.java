package com.api.equipos.utils;

public class HttpRespuesta {
	private String mensaje;
	private int codigo;
	
	public HttpRespuesta(String mensaje, int codigo) {
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
