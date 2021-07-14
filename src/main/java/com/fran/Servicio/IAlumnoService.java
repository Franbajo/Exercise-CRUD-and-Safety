package com.fran.Servicio;

import java.util.List;
import java.util.Optional;

import com.fran.Entidad.Alumno;

public interface IAlumnoService {
	public List<Alumno>listar();			    //Crear.
	public Optional<Alumno>listarId(long id);	//Mostrar.
	public int save(Alumno p);			        //Actualizar
	public void delete(long id);				//Eliminar

}
