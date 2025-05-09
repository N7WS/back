package com.n7ws.back.mapper;

import com.n7ws.back.domain.UserDomain;
import com.n7ws.back.entity.UserEntity;
import com.n7ws.back.model.UserModel;

public interface UserMapper extends Mapper {
    static UserDomain toDomain(UserEntity userEntity) {
        return new UserDomain(
            userEntity.getUid(),
            userEntity.getLastname(),
            userEntity.getFirstname(),
            userEntity.getPassword(),
            userEntity.getAdmin()
        );
    }

    static UserModel toModel(UserDomain userDomain) {
        return new UserModel(
            userDomain.uid(),
            userDomain.lastname(),
            userDomain.firstname(),
            userDomain.password(),
            userDomain.admin()
        );
    }
}
