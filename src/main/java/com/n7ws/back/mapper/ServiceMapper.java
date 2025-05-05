package com.n7ws.back.mapper;

import com.n7ws.back.domain.ServiceDomain;
import com.n7ws.back.entity.ServiceEntity;
import com.n7ws.back.model.ServiceModel;

public interface ServiceMapper {
    static ServiceDomain toServiceDomain(ServiceEntity serviceEntity) {
        return new ServiceDomain(
            serviceEntity.getUid(),
            serviceEntity.getName(),
            serviceEntity.getPort(),
            serviceEntity.getScripts()
                .stream()
                .map(ScriptMapper::toScriptDomain)
                .toList()
        );
    }

    static ServiceModel toServiceModel(ServiceDomain serviceDomain) {
        return new ServiceModel(
            serviceDomain.uid(),
            serviceDomain.name(),
            serviceDomain.port(),
            serviceDomain.scripts()
                .stream()
                .map(ScriptMapper::toScriptModel)
                .toList()
        );
    }
}
