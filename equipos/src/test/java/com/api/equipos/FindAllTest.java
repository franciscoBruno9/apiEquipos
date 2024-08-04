package com.api.equipos;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.api.equipos.model.Equipo;
import com.api.equipos.repositories.IEquipoRepository;
import com.api.equipos.services.EquipoService;

class FindAllTest {
	
	@Mock
	private IEquipoRepository iEquipoRepository;
	
	@InjectMocks
	private EquipoService equipoService;
	
	private Equipo equipo;

	@BeforeEach
	 void setup() {
		 MockitoAnnotations.openMocks(this);
		 equipo = new Equipo();
		 equipo.setId(1);
		 equipo.setNombre("Nombre Prueba");
		 equipo.setLiga("Liga Prueba");
		 equipo.setPais("Pais Prueba");
	 }

	 @Test
	 void findAll() {
		 when(iEquipoRepository.findAll()).thenReturn(Arrays.asList(equipo));
		 assertNotNull(equipoService.listarTodos());
	 }
}
