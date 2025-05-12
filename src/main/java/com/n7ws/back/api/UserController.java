package com.n7ws.back.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.mapper.UserMapper;
import com.n7ws.back.model.UserModel;
import com.n7ws.back.repository.UserRepository;

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
public class UserController {

    @Autowired
    UserRepository repository;

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
}
