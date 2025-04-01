package com.n7ws.back.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.beans.Service;

@RestController
public class ServiceController {
	private Service[] services = new Service[] {
		new Service("service1", "Apache", 8000, null),
	};

	@GetMapping({"/services", "/services/{uid}"})
	public Service[] services(@PathVariable(value = "uid", required = false) String uid) {
		if (uid == null) {
			return services;
		} else {
			for (Service service : services) {
				if (service.uid().equals(uid)) {
					return new Service[] { service };
				}
			}
			return null; // TODO : Return error instead
		}
	}
}
