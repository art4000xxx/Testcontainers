package com.example.conditionalapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ConditionalAppApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private static GenericContainer<?> devApp = new GenericContainer<>("devapp")
			.withExposedPorts(8080);
	private static GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
			.withExposedPorts(8081);

	@BeforeAll
	static void setUp() {
		devApp.start();
		prodApp.start();
	}

	@Test
	void testDevProfile() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				"http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class);
		assertEquals("Current profile is dev", response.getBody());
	}

	@Test
	void testProdProfile() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				"http://localhost:" + prodApp.getMappedPort(8081) + "/profile", String.class);
		assertEquals("Current profile is production", response.getBody());
	}
}