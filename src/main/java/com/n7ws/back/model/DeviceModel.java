package com.n7ws.back.model;

import java.util.Collection;

import com.n7ws.back.enums.DeviceState;

public record DeviceModel(
    String name,
    DeviceState status,
    String room,
    Collection<ServiceModel> services,
    Collection<HealthInfoModel> healthInfos,
    Collection<DeviceConfigModel> deviceConfigs
) {}
