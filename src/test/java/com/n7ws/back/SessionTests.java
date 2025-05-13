package com.n7ws.back;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.n7ws.back.domain.SessionDomain;
import com.n7ws.back.entity.SessionEntity;
import com.n7ws.back.mapper.SessionMapper;
import com.n7ws.back.model.SessionModel;

@SpringBootTest(classes = BackApplication.class)
public class SessionTests {
    private SessionDomain sessionDomain;
    private SessionModel sessionModel;
    private SessionEntity sessionEntity;
    private LocalDateTime dateTime = LocalDateTime.now();

    @Test
    void domainConstructorNoException() {
        // Tests if the constructor of SessionDomain does not throw an exception
        assertDoesNotThrow(() -> {
            new SessionDomain(
                "uid",
                null,
                dateTime
            );
        });
    }

    @Test
    void constructorCorrectness() {
        // Tests if the constructor of SessionDomain initializes the attributes correctly
        assertEquals("uid", sessionDomain.uid());
        assertEquals(dateTime, sessionDomain.expiration());
    }

    @Test
    void mapDomainToModel() {
        // Tests if the mapping from SessionDomain to SessionModel is correct
        sessionModel = null;
        sessionModel = SessionMapper.toModel(sessionDomain);
        assertEquals(sessionDomain.expiration(), sessionModel.expiration());
    }

    @Test
    void mapEntityToDomain() {
        // Tests if the mapping from SessionEntity to SessionDomain is correct
        sessionDomain = null;
        sessionDomain = SessionMapper.toDomain(sessionEntity);
        assertEquals(sessionEntity.getExpiration(), sessionDomain.expiration());
    }

    @BeforeEach
    void init() {
        // Initializes a SessionDomain object before each test
        this.sessionDomain = new SessionDomain(
            "uid",
            null,
            dateTime
        );

        // Initializes a SessionModel object before each test
        this.sessionModel = new SessionModel(
            "uid",
            null,
            dateTime
        );

        // Initializes a SessionEntity object before each test
        this.sessionEntity = new SessionEntity(
            null,
            dateTime
        );
    }
}
