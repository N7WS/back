package com.n7ws.back.domain;

import java.util.Collection;

import com.n7ws.back.enums.DeviceState;

public record DeviceDomain(
    String name,
    DeviceState status,
    String room,
    Collection<ServiceDomain> services,
    Collection<HealthInfoDomain> healthInfos,
    Collection<DeviceConfigDomain> deviceConfigs
) {}
