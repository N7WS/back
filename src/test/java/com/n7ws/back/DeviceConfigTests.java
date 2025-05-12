package com.n7ws.back;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.n7ws.back.domain.DeviceConfigDomain;
import com.n7ws.back.entity.DeviceConfigEntity;
import com.n7ws.back.entity.DeviceEntity;
import com.n7ws.back.mapper.DeviceConfigMapper;
import com.n7ws.back.model.DeviceConfigModel;

@SpringBootTest(classes = BackApplication.class)
public class DeviceConfigTests {
    private DeviceConfigDomain deviceConfigDomain;
    private DeviceConfigModel deviceConfigModel;
    private DeviceConfigEntity deviceConfigEntity;

    @Test
    void domainConstructorNoException() {
        // Tests if the constructor of DeviceConfigDomain does not throw an exception
        assertDoesNotThrow(() -> {
            new DeviceConfigDomain(
                "uid",
                "intel i5",
                4,
                354,
                8,
                2000
            );
        });
    }

    @Test
    void constructorCorrectness() {
        // Tests if the constructor of DeviceConfigDomain initializes the attributes correctly
        assertEquals("uid", deviceConfigDomain.uid());
        assertEquals("intel i5", deviceConfigDomain.cpuName());
        assertEquals(4, deviceConfigDomain.cpuCount());
        assertEquals(354, deviceConfigDomain.cpuFreq());
        assertEquals(8, deviceConfigDomain.ramSize());
        assertEquals(2000, deviceConfigDomain.ramFreq());
    }

    @Test
    void mapDomainToModel() {
        // Tests if the mapping from DeviceConfigDomain to DeviceConfigModel is correct
        deviceConfigModel = null;
        deviceConfigModel = DeviceConfigMapper.toModel(deviceConfigDomain);
        assertEquals(deviceConfigDomain.uid(), deviceConfigModel.uid());
        assertEquals(deviceConfigDomain.cpuName(), deviceConfigModel.cpuName());
        assertEquals(deviceConfigDomain.cpuCount(), deviceConfigModel.cpuCount());
        assertEquals(deviceConfigDomain.cpuFreq(), deviceConfigModel.cpuFreq());
        assertEquals(deviceConfigDomain.ramSize(), deviceConfigModel.ramSize());
        assertEquals(deviceConfigDomain.ramFreq(), deviceConfigModel.ramFreq());
    }

    @Test
    void mapEntityToDomain() {
        // Tests if the mapping from DeviceConfigEntity to DeviceConfigDomain is correct
        deviceConfigDomain = null;
        deviceConfigDomain = DeviceConfigMapper.toDomain(deviceConfigEntity);
        assertEquals(deviceConfigEntity.getUid(), deviceConfigDomain.uid());
        assertEquals(deviceConfigEntity.getCpuName(), deviceConfigDomain.cpuName());
        assertEquals(deviceConfigEntity.getCpuCount(), deviceConfigDomain.cpuCount());
        assertEquals(deviceConfigEntity.getCpuFreq(), deviceConfigDomain.cpuFreq());
        assertEquals(deviceConfigEntity.getRamSize(), deviceConfigDomain.ramSize());
        assertEquals(deviceConfigEntity.getRamFreq(), deviceConfigDomain.ramFreq());
    }

    @BeforeEach
    void init() {
        // Initializes a DeviceConfigDomain object before each test
        this.deviceConfigDomain = new DeviceConfigDomain(
            "uid",
            "intel i5",
            4,
            354,
            8,
            2000
        );

        // Initializes a DeviceConfigModel object before each test
        this.deviceConfigModel = new DeviceConfigModel(
            "uid",
            "intel i5",
            4,
            354,
            8,
            2000
        );

        // Initializes a DeviceConfigEntity object before each test
        this.deviceConfigEntity = new DeviceConfigEntity(
            "uid",
            new DeviceEntity(),
            "intel i5",
            4,
            354,
            8,
            2000
        );
    }
}
