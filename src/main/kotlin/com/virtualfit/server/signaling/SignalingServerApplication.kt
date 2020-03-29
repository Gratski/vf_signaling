package com.virtualfit.server.signaling

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SignalingServerApplication

fun main(args: Array<String>) {
	runApplication<SignalingServerApplication>(*args)
}
