package com.n7ws.back.mapper;

import com.n7ws.back.domain.ScriptDomain;
import com.n7ws.back.entity.ScriptEntity;
import com.n7ws.back.model.ScriptModel;

public interface ScriptMapper {
    static ScriptDomain toScriptDomain(ScriptEntity scriptEntity) {
        return new ScriptDomain(
            scriptEntity.getUid(),
            scriptEntity.getName(),
            scriptEntity.getPath()
        );
    }

    static ScriptModel toScriptModel(ScriptDomain scriptDomain) {
        return new ScriptModel(
            scriptDomain.uid(),
            scriptDomain.name(),
            scriptDomain.path()
        );
    }
}
