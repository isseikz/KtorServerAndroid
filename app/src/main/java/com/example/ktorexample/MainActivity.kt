package com.example.ktorexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.jetty.Jetty
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Default).launch {
            embeddedServer(Jetty, 8080) {
                routing {
                    get("/") {
                        call.respondText("Hello", ContentType.Text.Html)
                    }
                }
            }.start(wait = true)
        }
    }
}