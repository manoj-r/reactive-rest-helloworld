package com.manoj.learning.reactive

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.ClientResponse

import reactor.core.publisher.Mono




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReactiveRestApplicationTests {

	@LocalServerPort
	private var localPort: Int? = null

	private lateinit var client:WebClient

	private lateinit var result: Mono<ClientResponse>

	@BeforeAll
	fun setUp() {
		client = WebClient.create("http://localhost:${localPort}")

		result = client.get()
			.uri("/hello")
			.accept(MediaType.TEXT_PLAIN)
			.exchange()
	}

	@Test
	fun contextLoads() {
		val result = ">> result=${result.flatMap { it.bodyToMono(String::class.java) }.block()}"

		Assertions.assertNotNull(result)
	}

}
