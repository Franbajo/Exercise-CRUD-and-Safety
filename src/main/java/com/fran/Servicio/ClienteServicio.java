package com.fran.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fran.Entidad.Clientes;
import com.fran.Repositorio.IClientesRepositorio;
@Service
public class ClienteServicio implements  IClienteService{
	@Autowired
	private IClientesRepositorio data;

	@Override
	public List<Clientes> listar() {
		return (List<Clientes>)data.findAll();
	}

	@Override
	public Optional<Clientes> listarId(long id) {
		return data.findById(id);
	}

	@Override
	public int save(Clientes p) {
		int res=0;
		Clientes persona=data.save(p);
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
