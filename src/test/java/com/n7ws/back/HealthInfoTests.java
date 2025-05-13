package com.n7ws.back;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.n7ws.back.domain.HealthInfoDomain;
import com.n7ws.back.entity.HealthInfoEntity;
import com.n7ws.back.mapper.HealthInfoMapper;
import com.n7ws.back.model.HealthInfoModel;

@SpringBootTest(classes = BackApplication.class)
public class HealthInfoTests {
    private HealthInfoDomain healthInfoDomain;
    private HealthInfoModel healthInfoModel;
    private HealthInfoEntity healthInfoEntity;

    @Test
    void domainConstructorNoException() {
        // Tests if the constructor of HealthInfoDomain does not throw an exception
        assertDoesNotThrow(() -> {
            new HealthInfoDomain(
                "uid",
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
            );
        });

        // Tests if the constructor of HealthInfoDomain does not throw an exception
        assertDoesNotThrow(() -> {
            new HealthInfoDomain(
                "uid",
                // Ping :
                Arrays.asList(50, 48, 52, 49, 51, 50, 50, 52, 46, 45, 48, 49),
                // CPU (percentage):
                Arrays.asList(77, 75, 79, 82, 80, 78, 79, 74, 74, 75, 82, 79),
                // Memory (Mo):
                Arrays.asList(3044, 3502, 2800, 3400, 4632, 5380, 4408, 4500, 5096, 6378, 6048, 7680)
            );
        });
    }

    @Test
    void constructorCorrectness() {
        // Tests if the constructor of HealthInfoDomain initializes the attributes correctly
        assertEquals("uid", healthInfoDomain.uid());
        assertEquals(
            Arrays.asList(50, 48, 52, 49, 51, 50, 50, 52, 46, 45, 48, 49),
            healthInfoDomain.ping()
        );
        assertEquals(
            Arrays.asList(77, 75, 79, 82, 80, 78, 79, 74, 74, 75, 82, 79),
            healthInfoDomain.cpu()
        );
        assertEquals(
            Arrays.asList(3044, 3502, 2800, 3400, 4632, 5380, 4408, 4500, 5096, 6378, 6048, 7680),
            healthInfoDomain.ram()
        );
    }

    @Test
    void mapDomainToModel() {
        // Tests if the mapping from HealthInfoDomain to HealthInfoModel is correct
        healthInfoModel = null;
        healthInfoModel = HealthInfoMapper.toModel(healthInfoDomain);
        assertEquals(healthInfoDomain.ping(), healthInfoModel.ping());
        assertEquals(healthInfoDomain.cpu(), healthInfoModel.cpu());
        assertEquals(healthInfoDomain.ram(), healthInfoModel.ram());
    }

    @Test
    void mapEntityToDomain() {
        // Tests if the mapping from HealthInfoEntity to HealthInfoDomain is correct
        healthInfoDomain = null;
        healthInfoDomain = HealthInfoMapper.toDomain(healthInfoEntity);
        assertEquals(healthInfoEntity.getPing(), healthInfoDomain.ping());
        assertEquals(healthInfoEntity.getCpu(), healthInfoDomain.cpu());
        assertEquals(healthInfoEntity.getRam(), healthInfoDomain.ram());
    }

    @BeforeEach
    void init() {
        // Initializes a HealthInfoDomain object before each test
        this.healthInfoDomain = new HealthInfoDomain(
            "uid",
            // Ping :
            Arrays.asList(50, 48, 52, 49, 51, 50, 50, 52, 46, 45, 48, 49),
            // CPU (percentage):
            Arrays.asList(77, 75, 79, 82, 80, 78, 79, 74, 74, 75, 82, 79),
            // Memory (Mo):
            Arrays.asList(3044, 3502, 2800, 3400, 4632, 5380, 4408, 4500, 5096, 6378, 6048, 7680)
        );

        // Initializes a HealthInfoModel object before each test
        this.healthInfoModel = new HealthInfoModel(
            "uid",
            // Ping :
            Arrays.asList(50, 48, 52, 49, 51, 50, 50, 52, 46, 45, 48, 49),
            // CPU (percentage):
            Arrays.asList(77, 75, 79, 82, 80, 78, 79, 74, 74, 75, 82, 79),
            // Memory (Mo):
            Arrays.asList(3044, 3502, 2800, 3400, 4632, 5380, 4408, 4500, 5096, 6378, 6048, 7680)
        );

        // Initializes a HealthInfoEntity object before each test
        this.healthInfoEntity = new HealthInfoEntity(
            null,
            // Ping :
            Arrays.asList(50, 48, 52, 49, 51, 50, 50, 52, 46, 45, 48, 49),
            // CPU (percentage):
            Arrays.asList(77, 75, 79, 82, 80, 78, 79, 74, 74, 75, 82, 79),
            // Memory (Mo):
            Arrays.asList(3044, 3502, 2800, 3400, 4632, 5380, 4408, 4500, 5096, 6378, 6048, 7680)
        );
    }
}
