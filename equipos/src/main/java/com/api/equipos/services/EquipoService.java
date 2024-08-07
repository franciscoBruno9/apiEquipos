package com.api.equipos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.equipos.model.Equipo;
import com.api.equipos.repositories.IEquipoRepository;

@Service
public class EquipoService {

	@Autowired
	private IEquipoRepository iEquipoRepository;
	
	public List<Equipo> listarTodos(){
		return iEquipoRepository.findAll();
	}
	
	public Equipo buscarPorId(Integer id) {
	    return iEquipoRepository.findById(id).orElse(null);
	 }
	
	public List<Equipo> buscarPorNombre (String nombre){
		return iEquipoRepository.findByNombreContainingIgnoreCase(nombre);
	}
	
	public Equipo altaEquipo(Equipo equipo) {
		/*
		 * if (equipo.getNombre() == null || equipo.getLiga() == null ||
		 * equipo.getPais() == null) { throw new
		 * NullPointerException("No se permiten valores nulos"); } if
		 * (equipo.getNombre().trim().isEmpty()) { throw new
		 * IllegalArgumentException("El nombre del equipo no puede estar vacío"); } if
		 * (equipo.getLiga().trim().isEmpty()) { throw new
		 * IllegalArgumentException("La liga del equipo no puede estar vacía"); } if
		 * (equipo.getPais().trim().isEmpty()) { throw new
		 * IllegalArgumentException("El país del equipo no puede estar vacío"); }
		 */
	    return iEquipoRepository.save(equipo);
	}
	
	public Boolean bajaEquipo(Integer id) {
		try {
	        return iEquipoRepository.findById(id).map(e -> {
	        	iEquipoRepository.deleteById(id);
	            return true;
	        }).orElse(false);
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public Equipo actualizarEquipo(Integer id, Equipo equipo) {
        Equipo equipoActual = iEquipoRepository.findById(id).get();
        if (equipo.getNombre() != null) {
            equipoActual.setNombre(equipo.getNombre());
        }
        if (equipo.getLiga() != null) {
            equipoActual.setLiga(equipo.getLiga());
        }
        if (equipo.getPais() != null) {
            equipoActual.setPais(equipo.getPais());
        }
        return iEquipoRepository.save(equipoActual);
    }

}
