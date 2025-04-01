package com.n7ws.back.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.n7ws.back.beans.Device;
import com.n7ws.back.beans.Status;

@RestController
public class DeviceController {
	private Device[] devices = new Device[] {
		new Device("iode", Status.ONLINE, "c202", null),
		new Device("argon", Status.ONLINE, "c202", null),
		new Device("albator", Status.OFFLINE, "c203", null),
	};

	@GetMapping({"/devices", "/devices/{name}"})
	public Device[] devices(@PathVariable(value = "name", required = false) String name) {
		if (name == null) {
			return devices;
		} else {
			for (Device device : devices) {
				if (device.name().equals(name)) {
					return new Device[] { device };
				}
			}
			return null; // TODO : Return error instead
		}
	}
}
