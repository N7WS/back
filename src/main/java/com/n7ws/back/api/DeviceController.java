package com.n7ws.back.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.domain.DeviceConfigDomain;
import com.n7ws.back.domain.DeviceDomain;
import com.n7ws.back.domain.HealthInfoDomain;
import com.n7ws.back.domain.ScriptDomain;
import com.n7ws.back.domain.ServiceDomain;
import com.n7ws.back.enums.DeviceState;
import com.n7ws.back.mapper.DeviceMapper;
import com.n7ws.back.model.DeviceModel;


@RestController
@RequestMapping("/devices")
public class DeviceController {
	private Collection<DeviceDomain> devices;

	public DeviceController() {
		Collection<ScriptDomain> scripts = new ArrayList<>();
		scripts.add(new ScriptDomain("001", "apache", "./apache.sh"));
		scripts.add(new ScriptDomain("002", "build php", "./php/build.sh"));
		Collection<ServiceDomain> services = new ArrayList<>();
		services.add(new ServiceDomain("001", "apache", 3000, scripts));
        services.add(new ServiceDomain("002", "nginx", 8080, new ArrayList<>()));
        services.add(new ServiceDomain("003", "mysql", 3306, new ArrayList<>()));
		Collection<HealthInfoDomain> healthInfos = new ArrayList<>();
		healthInfos.add(new HealthInfoDomain("001", Arrays.asList(50,55,20), Arrays.asList(3000, 3150, 2960), Arrays.asList(70, 75, 60)));
		healthInfos.add(new HealthInfoDomain(
			"002",
			Arrays.asList(10, 8, 11, 11, 9, 10, 12, 7, 8, 9),
			Arrays.asList(3000, 3100, 2900, 2950, 3050, 3150, 3250, 2850, 2900, 3000),
			Arrays.asList(50, 55, 60, 65, 70, 75, 80, 85, 90, 95)
		));
		Collection<DeviceConfigDomain> deviceConfigs = new ArrayList<>();
		deviceConfigs.add(new DeviceConfigDomain("001", "intel i7 8th gen", 8, 324, 16, 400));
		devices = new ArrayList<>();
		devices.add(new DeviceDomain("iode", DeviceState.ONLINE, "c202", services, new ArrayList<>(), deviceConfigs));
		devices.add(new DeviceDomain("argon", DeviceState.ONLINE, "c202", new ArrayList<>(), healthInfos, new ArrayList<>()));
		devices.add(new DeviceDomain("albator", DeviceState.OFFLINE, "c203", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
	}

	@GetMapping
	public Collection<DeviceModel> devices() {
		return devices.stream()
			.map(device -> DeviceMapper.toDeviceModel(device))
			.collect(Collectors.toList());
	}

	@GetMapping("/{name}")
	public DeviceModel device(@PathVariable String name) {
		return devices.stream()
			.filter(device -> device.name().equals(name))
			.findFirst()
			.map(device -> DeviceMapper.toDeviceModel(device))
			.orElse(null);
	}
}
