package com.fran.Servicio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fran.Entidad.Alumno;
import com.fran.Entidad.Role;
import com.fran.Entidad.User;
import com.fran.Repositorio.RoleRepository;
import com.fran.Repositorio.UserRepository;
@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 

	@Override
	public List<User> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> listarId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(User p) {
		 int res=0;	
		  p.setPassword(bCryptPasswordEncoder.encode(p.getPassword()));
		  p.setEnabled(true);

		  HashSet<Role> hola=new HashSet<Role>();
		
		  Role userRole = roleRepository.findByRole("ADMIN");
		 
				  hola.add(userRole);

		  Role userRole2 = roleRepository.findByRole("USER");
		  hola.add(userRole2);
		  
		  p.setRoles(hola);
		 User persona= userRepository.save(p);
			if(!persona.equals(null)) {
				res=1;
			}
		return res;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
