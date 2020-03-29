package com.virtualfit.server.signaling.controller

import com.virtualfit.server.signaling.domain.classes.ClassSignalingIn
import com.virtualfit.server.signaling.domain.classes.ClassSignalingOut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class ClassMessageHandler {

    @Autowired
    lateinit var template: SimpMessagingTemplate;

    @MessageMapping("/class/{id}")
    @Throws(Exception::class)
    fun onOffer(@DestinationVariable("id") id: String?, @Payload msg: ClassSignalingIn) {
        template.convertAndSend("/topic/class/$id", ClassSignalingOut(type = msg.type, sender = msg.sender, payload = msg.payload))
    }

}