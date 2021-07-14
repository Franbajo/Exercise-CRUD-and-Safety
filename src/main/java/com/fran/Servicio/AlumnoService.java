package com.fran.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fran.Entidad.Alumno;
import com.fran.Entidad.Clientes;
import com.fran.Repositorio.IAlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService{
	@Autowired
	private IAlumnoRepository data;

	@Override
	public List<Alumno> listar() {
		return (List<Alumno>)data.findAll();
	}

	@Override
	public Optional<Alumno> listarId(long id) {
		return data.findById(id);
	}

	@Override
	public int save(Alumno p) {
		int res=0;
		Alumno persona=data.save(p);
		if(!persona.equals(null)) {
			res=1;
		}
		return res;

	}

	@Override
	public void delete(long id) {
		data.deleteById(id);	
	}

}
