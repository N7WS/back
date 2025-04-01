package com.n7ws.back.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.entities.Script;

@RestController
public class ScriptController {
	private Script[] scripts = new Script[] {
		new Script("script1", "mon script pour apache", "/tmp/apache/deploy.sh")
	};

	@GetMapping({"/scripts", "/scripts/{uid}"})
	public Script[] devices(@PathVariable(value = "uid", required = false) String uid) {
		if (uid == null) {
			return scripts;
		} else {
			for (Script script : scripts) {
				if (script.uid().equals(uid)) {
					return new Script[] { script };
				}
			}
			return null; // TODO : Return error instead
		}
	}
}
