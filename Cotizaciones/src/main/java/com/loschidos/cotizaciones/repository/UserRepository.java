package com.loschidos.cotizaciones.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loschidos.cotizaciones.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	public abstract User findByUsernameAndPassword(String username, String password);
	
//	User findByUsernameAndPassword(String username, String password);

}
