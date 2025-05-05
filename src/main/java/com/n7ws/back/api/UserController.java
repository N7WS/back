package com.n7ws.back.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.domain.UserDomain;
import com.n7ws.back.mapper.UserMapper;
import com.n7ws.back.model.UserModel;


@RestController
@RequestMapping("/users")
public class UserController {
	private Collection<UserDomain> users;

	public UserController() {
		users = new ArrayList<>();
        users.add(new UserDomain("001", "Doe", "John", "password", true));
        users.add(new UserDomain("002", "Smith", "Jane", "password", false));
        users.add(new UserDomain("003", "Brown", "Charlie", "password", false));
        users.add(new UserDomain("004", "Johnson", "Emily", "password", true));
        users.add(new UserDomain("005", "Williams", "Michael", "password", false));
	}

	@GetMapping
	public Collection<UserModel> users() {
		return users.stream()
			.map(user -> UserMapper.toUserModel(user))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public UserModel user(@PathVariable String uid) {
		return users.stream()
			.filter(user -> user.uid().equals(uid))
			.findFirst()
			.map(user -> UserMapper.toUserModel(user))
			.orElse(null);
	}
}
