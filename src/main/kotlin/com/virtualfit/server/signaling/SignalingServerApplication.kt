package com.virtualfit.server.signaling

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class SignalingServerApplication: SpringBootServletInitializer()

fun main(args: Array<String>) {
	runApplication<SignalingServerApplication>(*args)
}
