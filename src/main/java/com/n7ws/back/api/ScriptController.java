package com.n7ws.back.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.mapper.ScriptMapper;
import com.n7ws.back.model.ScriptModel;
import com.n7ws.back.repository.ScriptRepository;


@RestController
@RequestMapping("/scripts")
public class ScriptController {

	@Autowired
    ScriptRepository repository;

	@GetMapping
	public Collection<ScriptModel> scripts() {
		return repository.findAll().stream()
			.map(script -> ScriptMapper.toDomain(script))
            .map(script -> ScriptMapper.toModel(script))
            .collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public ScriptModel script(@PathVariable String uid) {
		return repository.findAll().stream()
			.map(script -> ScriptMapper.toDomain(script))
			.filter(script -> script.uid().equals(uid))
			.findFirst()
			.map(script -> ScriptMapper.toModel(script))
			.orElse(null);
	}
}
