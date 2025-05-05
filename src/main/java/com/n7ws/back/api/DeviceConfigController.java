package com.n7ws.back.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.domain.DeviceConfigDomain;
import com.n7ws.back.mapper.DeviceConfigMapper;
import com.n7ws.back.model.DeviceConfigModel;


@RestController
@RequestMapping("/deviceConfigs")
public class DeviceConfigController {
	private Collection<DeviceConfigDomain> deviceConfigs;

	public DeviceConfigController() {
		deviceConfigs = new ArrayList<>();
	}

	@GetMapping
	public Collection<DeviceConfigModel> deviceConfigs() {
		return deviceConfigs.stream()
			.map(deviceConfig -> DeviceConfigMapper.toDeviceConfigModel(deviceConfig))
			.collect(Collectors.toList());
	}

	@GetMapping("/{uid}")
	public DeviceConfigModel deviceConfig(@PathVariable String uid) {
		return deviceConfigs.stream()
			.filter(deviceConfig -> deviceConfig.uid().equals(uid))
			.findFirst()
			.map(deviceConfig -> DeviceConfigMapper.toDeviceConfigModel(deviceConfig))
			.orElse(null);
	}
}
