package com.n7ws.back.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.mapper.SessionMapper;
import com.n7ws.back.model.SessionModel;
import com.n7ws.back.repository.SessionRepository;


@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    SessionRepository repository;

	@GetMapping
	public Collection<SessionModel> sessions() {
		return repository.findAll().stream()
			.map(session -> SessionMapper.toDomain(session))
			.map(session -> SessionMapper.toModel(session))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public SessionModel session(@PathVariable String uid) {
		return repository.findAll().stream()
			.map(session -> SessionMapper.toDomain(session))
			.filter(session -> session.uid().equals(uid))
			.findFirst()
			.map(session -> SessionMapper.toModel(session))
			.orElse(null);
	}
}
