package com.n7ws.back.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.mapper.DeviceConfigMapper;
import com.n7ws.back.model.DeviceConfigModel;
import com.n7ws.back.repository.DeviceConfigRepository;

/**
 * This class is a REST controller that handles HTTP requests related to device configurations.
 * It provides endpoints to retrieve all device configurations and a specific device configuration by its UID.
 * Routes:
 * - GET /deviceConfigs: Retrieve all device configurations
 * - GET /deviceConfigs/{uid}: Retrieve a specific device configuration by its UID
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/deviceConfigs")
public class DeviceConfigController {

    @Autowired
    DeviceConfigRepository repository;

	/**
	 * This method retrieves all device configurations from the repository and maps them to the DeviceConfigModel.
	 *
	 * @return A collection of DeviceConfigModel objects representing all device configurations.
	 */
	@GetMapping
	public Collection<DeviceConfigModel> deviceConfigs() {
		return repository.findAll().stream()
			.map(deviceConfig -> DeviceConfigMapper.toDomain(deviceConfig))
			.map(deviceConfig -> DeviceConfigMapper.toModel(deviceConfig))
			.collect(Collectors.toList());
	}

	/**
	 * This method retrieves a specific device configuration by its UID from the repository and maps it to the DeviceConfigModel.
	 *
	 * @param uid The UID of the device configuration to retrieve.
	 * @return A DeviceConfigModel object representing the device configuration with the specified UID, or null if not found.
	 */
	@GetMapping("/{uid}")
	public DeviceConfigModel deviceConfig(@PathVariable String uid) {
		return repository.findAll().stream()
			.map(deviceConfig -> DeviceConfigMapper.toDomain(deviceConfig))
			.filter(deviceConfig -> deviceConfig.uid().equals(uid))
			.findFirst()
			.map(deviceConfig -> DeviceConfigMapper.toModel(deviceConfig))
			.orElse(null);
	}
}
