package com.api.equipos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.equipos.model.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer> {
	List<Equipo> findByNombreContainingIgnoreCase(String nombre);
}
