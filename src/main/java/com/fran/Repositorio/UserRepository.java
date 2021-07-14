package com.fran.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fran.Entidad.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);
User findByEmail(String email);
}

