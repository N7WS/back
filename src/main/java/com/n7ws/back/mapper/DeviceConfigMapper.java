package com.n7ws.back.mapper;

import com.n7ws.back.domain.DeviceConfigDomain;
import com.n7ws.back.entity.DeviceConfigEntity;
import com.n7ws.back.model.DeviceConfigModel;

public interface DeviceConfigMapper extends Mapper {
    static DeviceConfigDomain toDomain(DeviceConfigEntity deviceConfigEntity) {
        return new DeviceConfigDomain(
            deviceConfigEntity.getUid(),
            deviceConfigEntity.getCpuName(),
            deviceConfigEntity.getCpuCount(),
            deviceConfigEntity.getCpuFreq(),
            deviceConfigEntity.getRamSize(),
            deviceConfigEntity.getRamFreq()
        );
    }

    static DeviceConfigModel toModel(DeviceConfigDomain deviceConfigDomain) {
        return new DeviceConfigModel(
            deviceConfigDomain.uid(),
            deviceConfigDomain.cpuName(),
            deviceConfigDomain.cpuCount(),
            deviceConfigDomain.cpuFreq(),
            deviceConfigDomain.ramSize(),
            deviceConfigDomain.ramFreq()
        );
    }
}
