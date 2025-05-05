package com.n7ws.back.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.domain.SessionDomain;
import com.n7ws.back.domain.UserDomain;
import com.n7ws.back.mapper.SessionMapper;
import com.n7ws.back.model.SessionModel;


@RestController
@RequestMapping("/sessions")
public class SessionController {
	private Collection<SessionDomain> sessions;

	public SessionController() {
		List<UserDomain> users = new ArrayList<>();
		users.add(new UserDomain("001", "Doe", "John", "password", true));
        users.add(new UserDomain("002", "Smith", "Jane", "password", false));
        users.add(new UserDomain("003", "Brown", "Charlie", "password", false));
        users.add(new UserDomain("004", "Johnson", "Emily", "password", true));
        users.add(new UserDomain("005", "Williams", "Michael", "password", false));
		sessions = new ArrayList<>();
		sessions.add(new SessionDomain("001", users.get(3), LocalDate.now()));
        sessions.add(new SessionDomain("002", users.get(3), LocalDate.now()));
        sessions.add(new SessionDomain("003", users.get(3), LocalDate.now()));
	}

	@GetMapping
	public Collection<SessionModel> sessions() {
		return sessions.stream()
			.map(session -> SessionMapper.toSessionModel(session))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public SessionModel session(@PathVariable String uid) {
		return sessions.stream()
			.filter(session -> session.uid().equals(uid))
			.findFirst()
			.map(session -> SessionMapper.toSessionModel(session))
			.orElse(null);
	}
}
