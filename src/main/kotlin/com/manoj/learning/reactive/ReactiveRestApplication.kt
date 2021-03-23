package com.manoj.learning.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveRestApplication

fun main(args: Array<String>) {
	runApplication<ReactiveRestApplication>(*args)
}
