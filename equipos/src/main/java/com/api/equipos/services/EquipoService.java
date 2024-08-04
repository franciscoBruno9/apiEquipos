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
        equipoActual.setNombre(equipo.getNombre());
        equipoActual.setLiga(equipo.getLiga());
        equipoActual.setPais(equipo.getPais());
        return iEquipoRepository.save(equipoActual);
    }

}
