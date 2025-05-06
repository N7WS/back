package com.n7ws.back.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.entity.DeviceEntity;
import com.n7ws.back.enums.DeviceState;
import com.n7ws.back.mapper.DeviceMapper;
import com.n7ws.back.model.DeviceModel;
import com.n7ws.back.repository.DeviceRepository;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    DeviceRepository repository;

    @GetMapping
    public Collection<DeviceModel> devices() {
        return repository.findAll().stream()
			.map(device -> DeviceMapper.toDeviceDomain(device))
            .map(device -> DeviceMapper.toDeviceModel(device))
            .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public DeviceModel device(@PathVariable String name) {
        return repository.findAll().stream()
			.map(device -> DeviceMapper.toDeviceDomain(device))
            .filter(device -> device.name().equals(name))
            .findFirst()
            .map(device -> DeviceMapper.toDeviceModel(device))
            .orElse(null);
    }

	@PostConstruct
	public void populate() {
		Collection<DeviceEntity>seedDevices = new ArrayList<>();

		seedDevices.add(
                    new DeviceEntity(
                        "argon",
                        DeviceState.OFFLINE,
                        "c202",
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>()
                    )
                );

        repository.saveAll(seedDevices);
	}
}