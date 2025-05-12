package com.n7ws.back.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.mapper.DeviceMapper;
import com.n7ws.back.model.DeviceModel;
import com.n7ws.back.repository.DeviceRepository;

/**
 * This class is a REST controller that handles HTTP requests related to devices.
 * It provides endpoints to retrieve all devices and a specific device by its name.
 * Routes:
 * - GET /devices: Retrieve all devices
 * - GET /devices/{name}: Retrieve a specific device by its name
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    DeviceRepository repository;

    @GetMapping
    public Collection<DeviceModel> devices() {
        return repository.findAll().stream()
			.map(device -> DeviceMapper.toDomain(device))
            .map(device -> DeviceMapper.toModel(device))
            .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public DeviceModel device(@PathVariable String name) {
        return repository.findAll().stream()
			.map(device -> DeviceMapper.toDomain(device))
            .filter(device -> device.name().equals(name))
            .findFirst()
            .map(device -> DeviceMapper.toModel(device))
            .orElse(null);
    }

}