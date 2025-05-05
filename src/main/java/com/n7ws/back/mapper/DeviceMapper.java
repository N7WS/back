package com.n7ws.back.mapper;

import com.n7ws.back.domain.DeviceDomain;
import com.n7ws.back.entity.DeviceEntity;
import com.n7ws.back.model.DeviceModel;

public interface DeviceMapper {
    static DeviceDomain toDeviceDomain(DeviceEntity deviceEntity) {
        return new DeviceDomain(
            deviceEntity.getName(),
            deviceEntity.getStatus(),
            deviceEntity.getRoom(),
            deviceEntity.getServices()
                .stream()
                .map(ServiceMapper::toServiceDomain)
                .toList(),
            deviceEntity.getHealthInfos()
                .stream()
                .map(HealthInfoMapper::toHealthInfoDomain)
                .toList(),
            deviceEntity.getDeviceConfigs()
                .stream()
                .map(DeviceConfigMapper::toDeviceConfigDomain)
                .toList()
        );
    }

    static DeviceModel toDeviceModel(DeviceDomain deviceEntity) {
        return new DeviceModel(
            deviceEntity.name(),
            deviceEntity.status(),
            deviceEntity.room(),
            deviceEntity.services()
                .stream()
                .map(ServiceMapper::toServiceModel)
                .toList(),
            deviceEntity.healthInfos()
                .stream()
                .map(HealthInfoMapper::toHealthInfoModel)
                .toList(),
            deviceEntity.deviceConfigs()
                .stream()
                .map(DeviceConfigMapper::toDeviceConfigModel)
                .toList()
        );
    }
}
