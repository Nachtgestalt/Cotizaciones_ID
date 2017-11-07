package com.loschidos.cotizaciones.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.loschidos.cotizaciones.entity.User;
import com.loschidos.cotizaciones.repository.UserRepository;
import com.loschidos.cotizaciones.service.UsuarioService;

@Service
public class UserServiceImpl implements UsuarioService {
	
	@Autowired
	@Qualifier("userRepository")
	
	private UserRepository userRepository;

	@Override
	public User login(String user, String pass) {
		return userRepository.findByUsernameAndPassword(user, pass);		
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.delete(id);
		
	}

//	@Override
//	public User login(String username, String password) {
//		if(userRepository.findByUsernameAndPassword(username, password) != null) 
//			return userRepository.findByUsernameAndPassword();
//		return null;
//	}
	
	

}
