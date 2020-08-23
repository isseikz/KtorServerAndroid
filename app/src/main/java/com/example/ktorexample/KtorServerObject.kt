package com.example.ktorexample

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty

object KtorServerObject {
    internal fun start(port: Int = 8080) {
        embeddedServer(Jetty, port) {
            routing {
                get("/") {
                    call.respondText("Hello", ContentType.Text.Html)
                }
            }
        }.start(wait = true)
    }
}