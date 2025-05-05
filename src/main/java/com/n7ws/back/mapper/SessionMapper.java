package com.n7ws.back.mapper;

import com.n7ws.back.domain.SessionDomain;
import com.n7ws.back.entity.SessionEntity;
import com.n7ws.back.model.SessionModel;

public interface SessionMapper {
    static SessionDomain toSessionDomain(SessionEntity sessionEntity) {
        return new SessionDomain(
            sessionEntity.getUid(),
            UserMapper.toUserDomain(sessionEntity.getOwner()),
            sessionEntity.getExpiration()
        );
    }

    static SessionModel toSessionModel(SessionDomain sessionDomain) {
        return new SessionModel(
            sessionDomain.uid(),
            UserMapper.toUserModel(sessionDomain.owner()),
            sessionDomain.expiration()
        );
    }
}
