package com.n7ws.back.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.domain.ScriptDomain;
import com.n7ws.back.mapper.ScriptMapper;
import com.n7ws.back.model.ScriptModel;


@RestController
@RequestMapping("/scripts")
public class ScriptController {
	private Collection<ScriptDomain> scripts;

	public ScriptController() {
		scripts = new ArrayList<>();
	}

	@GetMapping
	public Collection<ScriptModel> scripts() {
		return scripts.stream()
			.map(script -> ScriptMapper.toScriptModel(script))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public ScriptModel script(@PathVariable String uid) {
		return scripts.stream()
			.filter(script -> script.uid().equals(uid))
			.findFirst()
			.map(script -> ScriptMapper.toScriptModel(script))
			.orElse(null);
	}
}
