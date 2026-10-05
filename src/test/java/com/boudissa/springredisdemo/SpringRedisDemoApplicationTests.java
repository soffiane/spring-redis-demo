package com.boudissa.springredisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class SpringRedisDemoApplicationTests {

    @Container
    @ServiceConnection
    private static final GenericContainer<?> REDIS_CONTAINER = new GenericContainer<>(
            DockerImageName.parse("redis:alpine"))
            .withExposedPorts(6379);

    @Test
    void contextLoads() {
        assertThat(REDIS_CONTAINER.isCreated()).isTrue();
        assertThat(REDIS_CONTAINER.isRunning()).isTrue();
    }

}
