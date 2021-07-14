package com.fran.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fran.Entidad.Alumno;
@Repository
public interface IAlumnoRepository extends CrudRepository<Alumno, Long>{

}
