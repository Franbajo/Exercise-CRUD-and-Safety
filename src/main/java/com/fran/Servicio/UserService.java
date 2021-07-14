package com.fran.Servicio;

import java.util.List;
import java.util.Optional;


import com.fran.Entidad.User;

public interface UserService {
	public List<User>listar();			    //Crear.
	public Optional<User>listarId(long id);	//Mostrar.
	public int save(User p);			        //Actualizar
	public void delete(long id);				//Eliminar
	
}
