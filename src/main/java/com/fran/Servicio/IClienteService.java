package com.fran.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fran.Entidad.Clientes;


public interface IClienteService {
	public List<Clientes>listar();			//Crear.
	public Optional<Clientes>listarId(long id);	//Mostrar.
	public int save(Clientes p);			//Actualizar
	public void delete(long id);				//Eliminar
}
