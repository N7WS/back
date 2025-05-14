package com.n7ws.back.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.config.JwtUtils;
import com.n7ws.back.entity.UserEntity;
import com.n7ws.back.mapper.UserMapper;
import com.n7ws.back.model.UserModel;
import com.n7ws.back.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is a REST controller that handles HTTP requests related to users.
 * It provides endpoints to retrieve all users and a specific user by its UID.
 * Routes:
 * - GET /users: Retrieve all users
 * - GET /users/{uid}: Retrieve a specific user by its UID
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository repository;

	//private final ?
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authentificationManager;


	@GetMapping
	public Collection<UserModel> users() {
		return repository.findAll().stream()
			.map(user -> UserMapper.toDomain(user))
			.map(user -> UserMapper.toModel(user))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public UserModel user(@PathVariable String uid) {
		return repository.findAll().stream()
			.map(user -> UserMapper.toDomain(user))
			.filter(user -> user.uid().equals(uid))
			.findFirst()
			.map(user -> UserMapper.toModel(user))
			.orElse(null);
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody UserModel user) {		
		if (repository.findByUid(UserMapper.toEntity(user).getUid()) != null) {
			return ResponseEntity.badRequest().body("Username already exists");
		}
		
		// Si on a pas déjà un utilisateur avec le même uid, on peut l'enregistrer
		UserEntity userEntity = UserMapper.toEntity(user);
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword())); // Hash du mot de passe
		return ResponseEntity.ok(repository.save(userEntity)); // Enregistrement de l'utilisateur
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserModel user) {
		// User entity
		UserEntity userEntity = UserMapper.toEntity(user);

		try {
			Authentication authentication = authentificationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userEntity.getUid(), userEntity.getPassword()));

			if (authentication.isAuthenticated()) {
				// Si l'utilisateur est authentifié, on génère un token JWT

				Map<String, Object> authData = new HashMap<>();
				authData.put("token", jwtUtils.generateToken(userEntity.getUid()));
				authData.put("type", "Bearer");
				return ResponseEntity.ok(authData);
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email ou password");
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");			
		}
	}
	
}
