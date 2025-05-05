package com.n7ws.back.mapper;

import com.n7ws.back.domain.HealthInfoDomain;
import com.n7ws.back.entity.HealthInfoEntity;
import com.n7ws.back.model.HealthInfoModel;

public interface HealthInfoMapper {
    static HealthInfoDomain toHealthInfoDomain(HealthInfoEntity healthInfoEntity) {
        return new HealthInfoDomain(
            healthInfoEntity.getUid(),
            healthInfoEntity.getPing(),
            healthInfoEntity.getCpu(),
            healthInfoEntity.getRam()
        );
    }

    static HealthInfoModel toHealthInfoModel(HealthInfoDomain healthInfoDomain) {
        return new HealthInfoModel(
            healthInfoDomain.uid(),
            healthInfoDomain.ping(),
            healthInfoDomain.cpu(),
            healthInfoDomain.ram()
        );
    }
}
