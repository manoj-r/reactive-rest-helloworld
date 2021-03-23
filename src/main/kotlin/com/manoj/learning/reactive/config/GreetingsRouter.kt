package com.manoj.learning.reactive.config

import com.manoj.learning.reactive.handler.GreetingsHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
class GreetingsRouter {

    @Bean
    fun route(handler: GreetingsHandler): RouterFunction<ServerResponse> {
        return router {
            GET("/hello") {
                handler.hello()
            }
        }
    }
}