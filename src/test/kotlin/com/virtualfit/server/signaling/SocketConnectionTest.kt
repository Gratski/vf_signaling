package com.virtualfit.server.signaling

import com.virtualfit.server.signaling.socket.MyJavaWebSocket
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.messaging.converter.StringMessageConverter
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.web.socket.client.WebSocketClient
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient
import java.net.URI


@RunWith(SpringRunner::class)
@SpringBootTest(classes = [SignalingServerApplication::class], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SocketConnectionTest() {

    @Test
    @Throws(Exception::class)
    fun testGetLog() {
        val webSocketClient: WebSocketClient = StandardWebSocketClient()
        val stompClient = WebSocketStompClient(webSocketClient)
        stompClient.messageConverter = StringMessageConverter()

        val url = "ws://localhost:8080/offer"
        val sessionHandler: StompSessionHandler = StompHandler()
        val session: ListenableFuture<StompSession> = stompClient.connect(url, sessionHandler)
        Assert.assertTrue(session.get().isConnected)


        Thread.sleep(5000)
    }

}