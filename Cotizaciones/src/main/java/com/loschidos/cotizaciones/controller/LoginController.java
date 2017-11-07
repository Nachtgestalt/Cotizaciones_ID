package com.loschidos.cotizaciones.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loschidos.cotizaciones.entity.User;
import com.loschidos.cotizaciones.service.UsuarioService;

@RestController
public class LoginController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UsuarioService userService;

	private static final Log LOGGER = LogFactory.getLog(LoginController.class);

	@PostMapping(value = "/logincheck")
	public ResponseEntity<User> autenticar(@RequestBody User user) {
		User usuario = userService.login(user.getUsername(), user.getPassword());
		LOGGER.info("User = " + user);
		LOGGER.info("usuario = " + usuario);
		if (usuario != null)
			// if(userService.login(user.getUsername(), user.getPassword()) !=
			// null)
			return new ResponseEntity<User>(usuario, HttpStatus.OK);
		else
			return new ResponseEntity<User>(usuario, HttpStatus.NOT_FOUND);

	}
	
	@PostMapping(value = "/usuarios/nuevo")
	public ResponseEntity<User> crearProducto(@RequestBody User user){
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(value= "/usuarios")
	public ResponseEntity<List<User>> listAll(){
		List<User> users = userService.listAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/usuarios/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getProduct(@PathVariable("id") int id){
		User user = userService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<User> deleteProduct(@PathVariable("id") int id){
		User user = userService.findById(id);
		if(user == null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
