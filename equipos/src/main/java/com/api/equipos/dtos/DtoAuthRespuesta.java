package com.api.equipos.dtos;


public class DtoAuthRespuesta {
    private String token;

    public DtoAuthRespuesta(String token) {
        this.token = token;
    }

	public DtoAuthRespuesta() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
    
}
