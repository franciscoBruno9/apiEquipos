package com.api.equipos.dtos;


public class DtoAuthRespuesta {
    private String accessToken;

    public DtoAuthRespuesta(String accessToken) {
        this.accessToken = accessToken;
    }

	public DtoAuthRespuesta() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
    
    
}
