package com.virtualfit.server.signaling.socket

import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandler
import java.lang.reflect.Type

class MyStompHandler : StompSessionHandler {
    override fun handleException(p0: StompSession, p1: StompCommand?, p2: StompHeaders, p3: ByteArray, p4: Throwable) {
        println("HAS EXCEPTIONNNNNNNNNNNNNN")
    }

    override fun handleTransportError(p0: StompSession, p1: Throwable) {
        TODO("Not yet implemented")
    }

    override fun handleFrame(p0: StompHeaders, p1: Any?) {
        TODO("Not yet implemented")
    }

    override fun afterConnected(p0: StompSession, p1: StompHeaders) {
        println("BOOOOOOOOOOM")
    }

    override fun getPayloadType(p0: StompHeaders): Type {
        TODO("Not yet implemented")
    }
}