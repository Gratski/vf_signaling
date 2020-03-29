package com.virtualfit.server.signaling

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(classes = [SignalingServerApplication::class], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SocketConnectionTest() {

    @Autowired
    lateinit var msgTemplate: SimpMessagingTemplate

    @Test
    @Throws(Exception::class)
    fun testGetLog() {
        msgTemplate.userDestinationPrefix = "/app"
        msgTemplate.defaultDestination = "/app"
        msgTemplate.convertAndSend("/class", "This is the payload!");
        Thread.sleep(5000)
    }

}