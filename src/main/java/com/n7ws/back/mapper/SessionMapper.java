package com.n7ws.back.mapper;

import com.n7ws.back.domain.SessionDomain;
import com.n7ws.back.entity.SessionEntity;
import com.n7ws.back.model.SessionModel;

public interface SessionMapper extends Mapper {
    static SessionDomain toDomain(SessionEntity sessionEntity) {
        return new SessionDomain(
            sessionEntity.getUid(),
            UserMapper.toDomain(sessionEntity.getOwner()),
            sessionEntity.getExpiration()
        );
    }

    static SessionModel toModel(SessionDomain sessionDomain) {
        return new SessionModel(
            sessionDomain.uid(),
            UserMapper.toModel(sessionDomain.owner()),
            sessionDomain.expiration()
        );
    }
}
