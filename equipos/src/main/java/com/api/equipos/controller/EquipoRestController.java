package com.api.equipos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.equipos.model.Equipo;
import com.api.equipos.services.EquipoService;
import com.api.equipos.utils.Constantes;
import com.api.equipos.utils.HttpRespuesta;

@RestController
@RequestMapping("/api")
public class EquipoRestController {
	
	@Autowired
	private EquipoService equipoService;
	
	@GetMapping("/equipos")
	  public ResponseEntity<?> listarTodos() {
	    List<Equipo> equipos = equipoService.listarTodos();
	    if(!equipos.isEmpty()) {
        	return ResponseEntity.ok(equipos);
        }else {
        	 return new ResponseEntity<>(crearRespuesta(Constantes.SIN_DATOS, 404), HttpStatus.NOT_FOUND);
        }
	}
	
	@GetMapping("/equipos/{id}")
	  public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Equipo equipo = equipoService.buscarPorId(id);
		if(equipo!=null) {
			return new ResponseEntity<>(equipo, HttpStatus.OK);
		}else {
	   	 	return new ResponseEntity<>(crearRespuesta(Constantes.NO_ENCONTRADO, 404), HttpStatus.NOT_FOUND);
	   }
	}
	
	@GetMapping("/equipos/buscar")
    public ResponseEntity<?> buscarPorNombre(@RequestParam(name = "nombre", required = false) String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return new ResponseEntity<>(crearRespuesta(Constantes.PARAM_REQ, Constantes.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        List<Equipo> equipos = equipoService.buscarPorNombre(nombre);
        if (equipos.isEmpty()) {
            return new ResponseEntity<>(crearRespuesta(Constantes.NO_ENCONTRADO, Constantes.NOT_CONTENT), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }
	
	@PostMapping("/equipos")
	  public ResponseEntity<?> altaEquipo(@RequestBody Equipo equipo) {
		try {
			Equipo equipoCreado = equipoService.altaEquipo(equipo);
		    return new ResponseEntity<>(equipoCreado, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(crearRespuesta(Constantes.SOL_INVALIDA, Constantes.BAD_REQUEST), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value = "/equipos/{id}")
	public ResponseEntity<?> bajaEquipo(@PathVariable Integer id) {
		 Boolean respuesta = equipoService.bajaEquipo(id);
		  if(respuesta) {
			  return new ResponseEntity<>(crearRespuesta("", Constantes.NOT_CONTENT), HttpStatus.NO_CONTENT);
		  }else {
			  return new ResponseEntity<>(crearRespuesta(Constantes.NO_ENCONTRADO, Constantes.NOT_FOUND), HttpStatus.NOT_FOUND);
		  }
		  
    }
	
	@PutMapping(value = "/equipos/{id}")
	public ResponseEntity<?> modificarEquipo(@PathVariable Integer id, @RequestBody Equipo equipo) {
		try {
			Equipo equipoActualizado = equipoService.actualizarEquipo(id,equipo);
	        return ResponseEntity.ok(equipoActualizado);
	    }catch (Exception e) {
	        return new ResponseEntity<>(crearRespuesta(Constantes.NO_ENCONTRADO, Constantes.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
    }
	
	private HttpRespuesta crearRespuesta(String mensaje, int codigo) {
	    return new HttpRespuesta(mensaje, codigo);
	}

}
