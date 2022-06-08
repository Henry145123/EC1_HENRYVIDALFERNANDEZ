package com.idat.EC1Servicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EC1Servicio.model.Universidad;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer>  {

}
