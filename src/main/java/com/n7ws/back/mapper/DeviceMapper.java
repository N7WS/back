package com.n7ws.back.mapper;

import com.n7ws.back.domain.DeviceDomain;
import com.n7ws.back.entity.DeviceEntity;
import com.n7ws.back.model.DeviceModel;

public interface DeviceMapper extends Mapper {
    static DeviceDomain toDomain(DeviceEntity deviceEntity) {
        return new DeviceDomain(
            deviceEntity.getName(),
            deviceEntity.getStatus(),
            deviceEntity.getRoom(),
            deviceEntity.getServices()
                .stream()
                .map(ServiceMapper::toDomain)
                .toList(),
            deviceEntity.getHealthInfos()
                .stream()
                .map(HealthInfoMapper::toDomain)
                .toList(),
            deviceEntity.getDeviceConfigs()
                .stream()
                .map(DeviceConfigMapper::toDomain)
                .toList()
        );
    }

    static DeviceModel toModel(DeviceDomain deviceEntity) {
        return new DeviceModel(
            deviceEntity.name(),
            deviceEntity.status(),
            deviceEntity.room(),
            deviceEntity.services()
                .stream()
                .map(ServiceMapper::toModel)
                .toList(),
            deviceEntity.healthInfos()
                .stream()
                .map(HealthInfoMapper::toModel)
                .toList(),
            deviceEntity.deviceConfigs()
                .stream()
                .map(DeviceConfigMapper::toModel)
                .toList()
        );
    }
}
