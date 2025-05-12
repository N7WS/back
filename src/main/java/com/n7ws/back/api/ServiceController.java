package com.n7ws.back.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.mapper.ServiceMapper;
import com.n7ws.back.model.ServiceModel;
import com.n7ws.back.repository.ServiceRepository;

/**
 * This class is a REST controller that handles HTTP requests related to services.
 * It provides endpoints to retrieve all services and a specific service by its UID.
 * Routes:
 * - GET /services: Retrieve all services
 * - GET /services/{uid}: Retrieve a specific service by its UID
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    ServiceRepository repository;

	@GetMapping
	public Collection<ServiceModel> services() {
		return repository.findAll().stream()
			.map(service -> ServiceMapper.toDomain(service))
			.map(service -> ServiceMapper.toModel(service))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public ServiceModel service(@PathVariable String uid) {
		return repository.findAll().stream()
			.map(service -> ServiceMapper.toDomain(service))
			.filter(service -> service.uid().equals(uid))
			.findFirst()
			.map(service -> ServiceMapper.toModel(service))
			.orElse(null);
	}
}
