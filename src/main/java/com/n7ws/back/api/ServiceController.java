package com.n7ws.back.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.domain.ServiceDomain;
import com.n7ws.back.mapper.ServiceMapper;
import com.n7ws.back.model.ServiceModel;


@RestController
@RequestMapping("/services")
public class ServiceController {
	private Collection<ServiceDomain> services;

	public ServiceController() {
		services = new ArrayList<>();
	}

	@GetMapping
	public Collection<ServiceModel> services() {
		return services.stream()
			.map(service -> ServiceMapper.toServiceModel(service))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public ServiceModel service(@PathVariable String uid) {
		return services.stream()
			.filter(service -> service.uid().equals(uid))
			.findFirst()
			.map(service -> ServiceMapper.toServiceModel(service))
			.orElse(null);
	}
}
